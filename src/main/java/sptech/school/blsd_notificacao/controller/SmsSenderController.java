package sptech.school.blsd_notificacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.blsd_notificacao.dtos.SmsRequest;
import sptech.school.blsd_notificacao.service.ISmsSender;

@RestController
@RequestMapping("/sms")
public class SmsSenderController {

    @Autowired
    @Qualifier("twilio_sms")
    ISmsSender smsSender;

    @PostMapping
    public void sendSms(@RequestBody SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }

}