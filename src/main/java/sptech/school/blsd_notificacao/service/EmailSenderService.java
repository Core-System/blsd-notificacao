package sptech.school.blsd_notificacao.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import sptech.school.blsd_notificacao.dtos.EmailRequest;
import sptech.school.blsd_notificacao.exception.EmailNotSendException;

import java.io.UnsupportedEncodingException;

@Service("email_service")
@Slf4j
public class EmailSenderService implements IEmailSender{

    private final JavaMailSender javaMailSender;

    private static final String EMAIL_ORIGEM = "blessed7@gmail.com";

    private static final String NOME_ENVIADOR = "Sistema de forncedores";
    public EmailSenderService(JavaMailSender javaMailSender) {
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
