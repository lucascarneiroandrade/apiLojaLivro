package com.api.lojaLivro.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "livros")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titulo", length = 100)
    @NotBlank
    private String titulo;

    @Column(name = "alugado")
    private boolean alugado;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Aluguel> aluguel;


}
