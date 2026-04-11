package sptech.school.blsd_notificacao.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sptech.school.blsd_notificacao.dtos.EmailRequest;

@Service("email_service")
@Slf4j
public class EmailSenderService implements IEmailSender{

    private final JavaMailSender javaMailSender;

    private final String remetente;

    public EmailSenderService(JavaMailSender javaMailSender, @Value("spring.mail.username") String remetente) {
        this.javaMailSender = javaMailSender;
        this.remetente = remetente;
    }


    @Override
    public void sendEmail(EmailRequest emailRequest){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(remetente);
        simpleMailMessage.setTo(emailRequest.destinatario());
        simpleMailMessage.setSubject(emailRequest.assunto());
        simpleMailMessage.setText(emailRequest.mensagem());
        javaMailSender.send(simpleMailMessage);
        log.info("Email enviado com sucesso");
    }
}
