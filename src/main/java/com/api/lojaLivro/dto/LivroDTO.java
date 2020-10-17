package com.api.lojaLivro.dto;


import javax.validation.constraints.NotBlank;

public class LivroDTO {

    private Long id;

    @NotBlank
    private String titulo;

    private boolean alugado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
}
