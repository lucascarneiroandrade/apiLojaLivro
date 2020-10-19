package com.api.lojaLivro.exception;

public class RegraDeNegocioException extends RuntimeException {

    private String detalhe;

    public RegraDeNegocioException() {
        super("Erro de negocio.");
    }

    public RegraDeNegocioException(String message) {
        super(message);
    }

}
