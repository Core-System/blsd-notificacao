package sptech.school.blsd_notificacao.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmailRequest(
        String destinatario,
        String assunto,
        String mensagem
) {
    public EmailRequest(@JsonProperty("destinatario") String destinatario, @JsonProperty("assunto") String assunto, @JsonProperty("mensagem") String mensagem) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.mensagem = mensagem;
    }
}
