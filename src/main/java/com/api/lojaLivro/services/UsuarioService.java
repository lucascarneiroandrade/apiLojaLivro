package com.api.lojaLivro.services;

import com.api.lojaLivro.dto.UsuarioDTO;
import com.api.lojaLivro.mappers.UsuarioMapper;
import com.api.lojaLivro.models.Usuario;
import com.api.lojaLivro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("usuarioService")
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;

    }

    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        if (usuarioDTO != null) {
            Usuario mapped = usuarioMapper.DTOtoUsuario(usuarioDTO);
            return usuarioMapper.usuarioToDTO(usuarioRepository.save(mapped));
        }
        return null;
    }

    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
        for (Usuario u : usuarios) {
            UsuarioDTO dto = usuarioMapper.usuarioToDTO(u);
            usuariosDTO.add(dto);
        }
        return usuariosDTO;
    }

    public UsuarioDTO update(UsuarioDTO usuario) {
        if (usuario != null) {
            Usuario mapped = usuarioMapper.DTOtoUsuario(usuario);
            return usuarioMapper.usuarioToDTO(usuarioRepository.save(mapped));
        }
        return null;
    }


    public boolean deleteById(Long id) {
        if (id != null && usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
