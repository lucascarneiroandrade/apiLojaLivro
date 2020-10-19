package com.api.lojaLivro.dto;

import com.api.lojaLivro.models.Livro;
import com.api.lojaLivro.models.Usuario;
import com.sun.istack.NotNull;

import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class ReservaDTO {

    private Long id;

    @NotNull
    private Livro livro;

    @NotNull
    private LocalDate dataReserva;

    @NotNull
    private Usuario usuario;

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

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
