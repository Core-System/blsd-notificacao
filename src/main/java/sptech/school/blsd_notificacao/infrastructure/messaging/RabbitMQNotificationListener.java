package sptech.school.blsd_notificacao.infrastructure.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sptech.school.blsd_notificacao.infrastructure.config.RabbitMQConfig;
import sptech.school.blsd_notificacao.infrastructure.dtos.EmailRequest;
import sptech.school.blsd_notificacao.infrastructure.dtos.NotificacaoSmsWhatsappRequest;
import sptech.school.blsd_notificacao.usecases.IEmailSender;
import sptech.school.blsd_notificacao.usecases.ISmsSender;
import sptech.school.blsd_notificacao.usecases.IWhatsappSender;

@Component
@Slf4j
public class RabbitMQNotificationListener {

    private final IEmailSender emailSender;
    private final ISmsSender smsSender;
    private final IWhatsappSender whatsappSender;

    public RabbitMQNotificationListener(
            @Qualifier("email_service") IEmailSender emailSender,
            @Qualifier("twilio_sms") ISmsSender smsSender,
            @Qualifier("twilio_whatsapp") IWhatsappSender whatsappSender) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.whatsappSender = whatsappSender;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_EMAIL)
    public void emailNotification(EmailRequest request) {
        log.info("[RabbitMQ] Consumindo mensagem de E-mail para: {}", request.destinatario());
        emailSender.sendEmail(request);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_SMS)
    public void smsNotification(NotificacaoSmsWhatsappRequest request) {
        log.info("[RabbitMQ] Consumindo mensagem de SMS para DDD: {} Numero: {}", request.ddd(), request.numero());
        smsSender.sendSms(request);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_WHATSAPP)
    public void whatsappNotification(NotificacaoSmsWhatsappRequest request) {
        log.info("[RabbitMQ] Consumindo mensagem de WhatsApp para DDD: {} Numero: {}", request.ddd(), request.numero());
        whatsappSender.sendWhatsapp(request);
    }
}