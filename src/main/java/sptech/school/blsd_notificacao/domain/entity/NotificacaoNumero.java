package sptech.school.blsd_notificacao.domain.entity;

import java.time.LocalDateTime;

public class NotificacaoNumero {

    private String rementente;
    private int ddd;
    private String numero;
    private String mensagem;
    private LocalDateTime dataHoraEnvio;


    public NotificacaoNumero(String rementente, int ddd, String numero, String mensagem) {
        this.rementente = rementente;
        this.ddd = ddd;
        this.numero = numero;
        this.mensagem = mensagem;
        this.dataHoraEnvio = LocalDateTime.now();
    }

    public NotificacaoNumero() {
    }

    public String getRementente() {
        return rementente;
    }

    public void setRementente(String rementente) {
        this.rementente = rementente;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
