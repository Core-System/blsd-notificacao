package sptech.school.blsd_notificacao.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.blsd_notificacao.config.TwilioConfiguration;
import sptech.school.blsd_notificacao.dtos.WhatsappRequest;

@Service("twilio_whatsapp")
@Slf4j
public class TwilioWhatsappSenderService implements IWhatsappSender{
    @Autowired
    TwilioConfiguration twilioConfiguration;

    @Override
    public void sendWhatsapp(WhatsappRequest whatsappRequest) {
        String from = "De: "+ whatsappRequest.remetente() + "\n";
        Message message = Message
                .creator(
                        new PhoneNumber("whatsapp:+55" + whatsappRequest.ddd() + whatsappRequest.telefone()),
                        new PhoneNumber("whatsapp:"+twilioConfiguration.getWhatsappNumber()),
                        from + whatsappRequest.mensagem()
                ).create();
        log.info("Whatsapp enviado com sucesso");
    }
}
