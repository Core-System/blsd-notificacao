package sptech.school.blsd_notificacao.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class TwilioConfiguration {
    private final String accountSid;
    private final String authToken;
    private final String phoneNumber;
    private final String whatsappNumber;


    public TwilioConfiguration(
            @Value(value = "${twilio.account_sid}")
            String accountSid,

            @Value(value = "${twilio.auth_token}")
            String authToken,

            @Value(value = "${twilio.phone_number}")
            String phoneNumber,

            @Value(value = "${twilio.whatsapp_number}")
            String whatsappNumber)
    {
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.phoneNumber = phoneNumber;
        this.whatsappNumber = whatsappNumber;
    }
}
