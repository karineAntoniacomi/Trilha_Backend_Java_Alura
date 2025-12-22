package br.com.alura.screenMatch.excecao;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    private String mensagem;

    public ErroDeConversaoDeAnoException(String message) {
        this.mensagem = message;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
