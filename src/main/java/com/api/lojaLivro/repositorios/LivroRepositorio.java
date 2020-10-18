package com.api.lojaLivro.repositorios;

import com.api.lojaLivro.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {
    Livro findByTitulo(String titulo);
}
