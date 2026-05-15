package sptech.school.blsd_notificacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.blsd_notificacao.dtos.NotificacaoSmsWhatsappRequest;
import sptech.school.blsd_notificacao.dtos.WhatsappRequest;
import sptech.school.blsd_notificacao.service.IWhatsappSender;


@RestController
@RequestMapping("/whatsapp")
public class WhatsappSenderController {
    @Autowired
    @Qualifier("twilio_whatsapp")
    IWhatsappSender whatsappSender;

    @PostMapping
    public void sendWhatsapp(@RequestBody NotificacaoSmsWhatsappRequest whatsappRequest){
        whatsappSender.sendWhatsapp(whatsappRequest);
    }
}
