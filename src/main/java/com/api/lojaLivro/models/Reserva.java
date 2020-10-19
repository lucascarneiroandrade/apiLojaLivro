package com.api.lojaLivro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataReserva")
    private LocalDate dataReserva;


    @JsonIgnore
    @JoinColumn(name = "livro_id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Livro livro;

    @JsonIgnore
    @JoinColumn(name = "usuario_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;


}
