package sptech.school.blsd_notificacao.infrastructure.config;

import com.twilio.Twilio;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class SenderInitialazer {
    public static Logger logger = Logger.getLogger(SenderInitialazer.class.getName());
    public SenderInitialazer(TwilioConfiguration senderConfiguration){
        Twilio.init(senderConfiguration.getAccountSid(), senderConfiguration.getAuthToken());

        logger.info("Credenciais do Twilio inicializadas para o número configurado.");
    }
}