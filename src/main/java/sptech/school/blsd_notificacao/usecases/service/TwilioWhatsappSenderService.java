package sptech.school.blsd_notificacao.usecases.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.blsd_notificacao.infrastructure.config.TwilioConfiguration;
import sptech.school.blsd_notificacao.usecases.dtos.NotificacaoSmsWhatsappRequest;

@Service("twilio_whatsapp")
@Slf4j
public class TwilioWhatsappSenderService implements IWhatsappSender{
    @Autowired
    TwilioConfiguration twilioConfiguration;

    @Override
    public void sendWhatsapp(NotificacaoSmsWhatsappRequest whatsappRequest) {
        String from = "De: "+ whatsappRequest.rementente() + "\n";
        Message message = Message
                .creator(
                        new PhoneNumber("whatsapp:+55" + whatsappRequest.ddd() + whatsappRequest.numero()),
                        new PhoneNumber("whatsapp:"+twilioConfiguration.getWhatsappNumber()),
                        from + whatsappRequest.mensagem()
                ).create();
        log.info("Whatsapp enviado com sucesso");
    }
}
