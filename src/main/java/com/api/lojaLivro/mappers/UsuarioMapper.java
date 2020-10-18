package com.api.lojaLivro.mappers;

import com.api.lojaLivro.dto.UsuarioDTO;
import com.api.lojaLivro.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO usuarioToDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        } else {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNomeDeUsuario(usuario.getNomeDeUsuario());
            usuarioDTO.setEndereco(usuario.getEndereco());
            usuarioDTO.setTelefone(usuario.getTelefone());
            return usuarioDTO;
        }
    }


    public Usuario DTOtoUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null;
        } else {
            Usuario usuario = new Usuario();
            usuario.setNomeDeUsuario(usuarioDTO.getNomeDeUsuario());
            usuario.setEndereco(usuarioDTO.getEndereco());
            usuario.setTelefone(usuarioDTO.getTelefone());
            return usuario;
        }
    }


}
