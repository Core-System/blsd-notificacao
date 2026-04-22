package sptech.school.blsd_notificacao.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SmsRequest(
        String remetente,
        int ddd,
        String telefone,
        String mensagem
) {
    public SmsRequest(@JsonProperty("remetente") String remetente, @JsonProperty("ddd") int ddd, @JsonProperty("telefone") String telefone, @JsonProperty("mensagem") String mensagem) {
        this.remetente = remetente;
        this.ddd = ddd;
        this.telefone = telefone;
        this.mensagem = mensagem;
    }
}

