package sptech.school.blsd_notificacao.service;

import sptech.school.blsd_notificacao.dtos.NotificacaoSmsWhatsappRequest;


public interface IWhatsappSender {
    void sendWhatsapp(NotificacaoSmsWhatsappRequest whatsappRequest);;
}
