package sptech.school.blsd_notificacao.usecases.dtos;

public record NotificacaoSmsWhatsappRequest(String rementente, int ddd, String numero, String mensagem) {
}