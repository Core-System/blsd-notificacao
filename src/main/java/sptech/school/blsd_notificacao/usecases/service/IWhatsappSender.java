package sptech.school.blsd_notificacao.usecases.service;

import sptech.school.blsd_notificacao.usecases.dtos.NotificacaoSmsWhatsappRequest;


public interface IWhatsappSender {
    void sendWhatsapp(NotificacaoSmsWhatsappRequest whatsappRequest);;
}
