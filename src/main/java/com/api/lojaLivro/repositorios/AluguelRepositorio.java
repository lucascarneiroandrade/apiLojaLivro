package com.api.lojaLivro.repositorios;

import com.api.lojaLivro.models.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepositorio extends JpaRepository<Aluguel, Long> {
    //List<Aluguel> findAllByUser(Usuario usuario);

}
