package com.api.lojaLivro.repositories;

import com.api.lojaLivro.models.Aluguel;
import com.api.lojaLivro.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findAllByUsuario(Usuario usuario);

}
