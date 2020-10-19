package com.api.lojaLivro.util;

import com.api.lojaLivro.dto.ResponseDTO;
import com.api.lojaLivro.exception.EntidadeNaoEncontradaException;
import com.api.lojaLivro.exception.ErroInternoException;
import com.api.lojaLivro.exception.RegraDeNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GloboControllerExceptionHandler {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)  // 422
    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseDTO handleRegraDeNegocioException(RegraDeNegocioException e) {
        return new ResponseDTO(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(ErroInternoException.class)
    public ResponseDTO handleErroInternoException(ErroInternoException e) {
        return new ResponseDTO(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseDTO handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException e) {
        return new ResponseDTO(e.getMessage());

    }
}
