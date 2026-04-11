package sptech.school.blsd_notificacao.service;

import sptech.school.blsd_notificacao.dtos.SmsRequest;

public interface ISmsSender {
    void sendSms(SmsRequest smsRequest);
}
