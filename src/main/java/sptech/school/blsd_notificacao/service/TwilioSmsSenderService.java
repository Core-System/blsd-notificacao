package sptech.school.blsd_notificacao.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.blsd_notificacao.config.TwilioConfiguration;
import sptech.school.blsd_notificacao.dtos.SmsRequest;

@Service("twilio_sms")
@Slf4j
public class TwilioSmsSenderService implements ISmsSender{
    @Autowired
    TwilioConfiguration twilioConfiguration;

    @Override
    public void sendSms(SmsRequest smsRequest) {
        String from = "De: "+ smsRequest.sender() + "\n";
        Message message = Message
                .creator(
                        new PhoneNumber("+55" + smsRequest.ddd() + smsRequest.phoneNumber()),
                        new PhoneNumber(twilioConfiguration.getPhoneNumber()),
                        from + smsRequest.message()
                ).create();
        log.info("Sms enviado com sucesso");
    }
}
