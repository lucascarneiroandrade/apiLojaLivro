package com.api.lojaLivro.repositories;

import com.api.lojaLivro.models.Livro;
import com.api.lojaLivro.models.Reserva;
import com.api.lojaLivro.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Optional<Reserva> findByLivro(Livro livro);

}
