package com.api.lojaLivro.exception;

public class ErroInternoException extends RuntimeException {

    private String detalhe;

    public ErroInternoException() {
        super("Erro interno.");
    }

    public ErroInternoException(String message) {
        super(message);
    }


}
