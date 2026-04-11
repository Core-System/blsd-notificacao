package sptech.school.blsd_notificacao.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WhatsappRequest(String sender, int ddd, String phoneNumber, String message) {
    public WhatsappRequest(@JsonProperty("sender") String sender, @JsonProperty("ddd") int ddd, @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("message") String message) {
        this.sender = sender;
        this.ddd = ddd;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
}