package com.api.lojaLivro.dto;

import com.api.lojaLivro.models.Livro;
import com.sun.istack.NotNull;

import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class AluguelDTO {

    private Long id;

    @NotNull
    private Livro livro;

    @NotNull
    private LocalDate aluguelData;

    @NotNull
    private LocalDate devolucaoData;
    private boolean devolvido;

    /*@NotNull
    private Usuario usuario;*/

    @PositiveOrZero
    private Float penalidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getAluguelData() {
        return aluguelData;
    }

    public void setAluguelData(LocalDate aluguelData) {
        this.aluguelData = aluguelData;
    }

    public LocalDate getDevolucaoData() {
        return devolucaoData;
    }

    public void setDevolucaoData(LocalDate devolucaoData) {
        this.devolucaoData = devolucaoData;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public Float getPenalidade() {
        return penalidade;
    }

    public void setPenalidade(Float penalidade) {
        this.penalidade = penalidade;
    }
}
