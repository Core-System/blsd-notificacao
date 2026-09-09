package sptech.school.blsd_notificacao.infrastructure.dtos;

public record NotificacaoSmsWhatsappRequest(String rementente, int ddd, String numero, String mensagem) {
}