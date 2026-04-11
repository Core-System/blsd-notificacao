package sptech.school.blsd_notificacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.blsd_notificacao.dtos.EmailRequest;
import sptech.school.blsd_notificacao.service.IEmailSender;

@RestController
@RequestMapping("/email")
public class EmailSenderController {

    @Autowired
    @Qualifier("email_service")
    IEmailSender emailSender;

    @PostMapping
    public void sendEmail(@RequestBody EmailRequest emailRequest){
        emailSender.sendEmail(emailRequest);
    }
}
