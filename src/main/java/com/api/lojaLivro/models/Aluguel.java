package com.api.lojaLivro.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "aluguéis")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @Column(name = "aluguel_data")
    private LocalDate aluguelData;

    @Column(name = "devolucao_data")
    private LocalDate devolucaoData;

    @Column(name = "devolvido")
    private boolean devolvido;

    /*
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    */
    @Column(name = "penalidade")
    private Float penalidade;


}
