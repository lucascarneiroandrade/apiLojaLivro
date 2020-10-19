package com.api.lojaLivro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "livros")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 100)
    @NotBlank
    private String titulo;

    @Column(name = "autor", length = 100)
    @NotBlank
    private String autor;

    @Column(name = "alugado")
    private boolean alugado;

    @Column(name = "reservado")
    private boolean reservado;

    @JsonIgnore
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Aluguel> aluguel;

    @JsonIgnore
    @OneToOne(mappedBy = "livro", cascade = CascadeType.ALL)
    private Reserva reserva;


}
