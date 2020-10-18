package com.api.lojaLivro.repositories;

import com.api.lojaLivro.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNomeDeUsuario(String nomeDeUsuario);
}
