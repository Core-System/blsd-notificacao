package sptech.school.blsd_notificacao.usecases;

import sptech.school.blsd_notificacao.infrastructure.dtos.EmailRequest;

public interface IEmailSender {
    void sendEmail(EmailRequest emailRequest);
}
