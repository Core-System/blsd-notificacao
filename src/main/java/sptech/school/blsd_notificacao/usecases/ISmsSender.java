package sptech.school.blsd_notificacao.usecases;

import sptech.school.blsd_notificacao.infrastructure.dtos.NotificacaoSmsWhatsappRequest;

public interface ISmsSender {
    void sendSms(NotificacaoSmsWhatsappRequest smsRequest);
}
