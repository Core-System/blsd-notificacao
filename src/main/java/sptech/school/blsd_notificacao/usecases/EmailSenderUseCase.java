package sptech.school.blsd_notificacao.usecases;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import sptech.school.blsd_notificacao.infrastructure.dtos.EmailRequest;
import sptech.school.blsd_notificacao.domain.exception.EmailNotSendException;

import java.io.UnsupportedEncodingException;

@Service("email_service")
@Slf4j
public class EmailSenderUseCase implements IEmailSender{

    private final JavaMailSender javaMailSender;

    private static final String EMAIL_ORIGEM = "blessed7@gmail.com";

    private static final String NOME_ENVIADOR = "Sistema de forncedores";
    public EmailSenderUseCase(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void sendEmail(EmailRequest emailRequest){

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper simpleMailMessage = new MimeMessageHelper(message);

        try {
            simpleMailMessage.setFrom(EMAIL_ORIGEM, EMAIL_ORIGEM);
            simpleMailMessage.setTo(emailRequest.destinatario());
            simpleMailMessage.setSubject(emailRequest.assunto());
            simpleMailMessage.setText(emailRequest.mensagem(), true);
            log.info("Email enviado com sucesso");
        } catch(MessagingException | UnsupportedEncodingException e){
            throw new EmailNotSendException("Erro ao enviar email");
        }

        javaMailSender.send(message);

    }
}
