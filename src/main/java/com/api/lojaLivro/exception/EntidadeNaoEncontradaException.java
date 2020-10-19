package com.api.lojaLivro.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

    private String detalhe;

    public EntidadeNaoEncontradaException() {
        super("Entidade não encontrada.");
    }

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }

}
