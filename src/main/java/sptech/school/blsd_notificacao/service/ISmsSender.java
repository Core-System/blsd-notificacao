package sptech.school.blsd_notificacao.service;

import sptech.school.blsd_notificacao.dtos.NotificacaoSmsWhatsappRequest;
import sptech.school.blsd_notificacao.dtos.SmsRequest;

public interface ISmsSender {
    void sendSms(NotificacaoSmsWhatsappRequest smsRequest);
}
