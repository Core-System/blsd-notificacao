package sptech.school.blsd_notificacao.usecases.service;

import sptech.school.blsd_notificacao.usecases.dtos.EmailRequest;

public interface IEmailSender {
    void sendEmail(EmailRequest emailRequest);
}
