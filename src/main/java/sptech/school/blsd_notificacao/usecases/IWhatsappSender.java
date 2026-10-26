package sptech.school.blsd_notificacao.usecases;

import sptech.school.blsd_notificacao.infrastructure.dtos.NotificacaoSmsWhatsappRequest;


public interface IWhatsappSender {
    void sendWhatsapp(NotificacaoSmsWhatsappRequest whatsappRequest);;
}
