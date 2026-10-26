package sptech.school.blsd_notificacao.usecases;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.blsd_notificacao.infrastructure.config.TwilioConfiguration;
import sptech.school.blsd_notificacao.infrastructure.dtos.NotificacaoSmsWhatsappRequest;

@Service("twilio_sms")
@Slf4j
public class TwilioSmsSenderUseCase implements ISmsSender{
    @Autowired
    TwilioConfiguration twilioConfiguration;

    @Override
    public void sendSms(NotificacaoSmsWhatsappRequest smsRequest) {
        String from = "De: "+ smsRequest.rementente() + "\n";
        Message message = Message
                .creator(
                        new PhoneNumber("+55" + smsRequest.ddd() + smsRequest.numero()),
                        new PhoneNumber(twilioConfiguration.getPhoneNumber()),
                        from + smsRequest.mensagem()
                ).create();
        log.info("Sms enviado com sucesso");
    }
}
