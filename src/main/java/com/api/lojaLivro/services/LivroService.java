package com.api.lojaLivro.services;

import com.api.lojaLivro.dto.LivroDTO;
import com.api.lojaLivro.mappers.LivroMapper;
import com.api.lojaLivro.models.Livro;
import com.api.lojaLivro.repositorios.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepositorio livroRepositorio;

    private final LivroMapper livroMapper;

    @Autowired
    public LivroService(LivroRepositorio livroRepositorio, LivroMapper livroMapper) {
        this.livroRepositorio = livroRepositorio;
        this.livroMapper = livroMapper;
    }

    public LivroDTO create(LivroDTO livroDTO) {
        if (livroDTO != null) {
            Livro mapped = livroMapper.DTOtoLivro(livroDTO);
            return livroMapper.LivroToDTO(livroRepositorio.save(mapped));
        }
        return null;
    }

    public List<LivroDTO> findAll() {
        List<Livro> livros = livroRepositorio.findAll();
        List<LivroDTO> livrosDTO = new ArrayList<LivroDTO>();
        for (Livro l : livros) {
            LivroDTO dto = livroMapper.LivroToDTO(l);
            livrosDTO.add(dto);
        }
        return livrosDTO;
    }


    public boolean delete(LivroDTO livroDTO) {
        if (livroDTO != null) {
            if (livroRepositorio.existsById(livroDTO.getId())) {
                Livro mapped = livroMapper.DTOtoLivro(livroDTO);
                livroRepositorio.delete(mapped);
                return true;
            }
        }
        return false;
    }


    public LivroDTO update(LivroDTO livro) {
        if (livro != null) {
            Livro mapped = livroMapper.DTOtoLivro(livro);
            return livroMapper.LivroToDTO(livroRepositorio.save(mapped));
        }
        return null;
    }
}
