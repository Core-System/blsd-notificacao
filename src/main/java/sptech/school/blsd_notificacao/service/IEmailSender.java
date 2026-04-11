package sptech.school.blsd_notificacao.service;

import sptech.school.blsd_notificacao.dtos.EmailRequest;

public interface IEmailSender {
    void sendEmail(EmailRequest emailRequest);
}
