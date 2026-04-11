package sptech.school.blsd_notificacao.service;

import sptech.school.blsd_notificacao.dtos.WhatsappRequest;

public interface IWhatsappSender {
    void sendWhatsapp(WhatsappRequest whatsappRequest);
}
