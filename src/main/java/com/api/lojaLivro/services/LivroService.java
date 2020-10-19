package com.api.lojaLivro.services;

import com.api.lojaLivro.dto.LivroDTO;
import com.api.lojaLivro.exception.EntidadeNaoEncontradaException;
import com.api.lojaLivro.mappers.LivroMapper;
import com.api.lojaLivro.models.Livro;
import com.api.lojaLivro.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    private final LivroMapper livroMapper;

    @Autowired
    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper) {
        this.livroRepository = livroRepository;
        this.livroMapper = livroMapper;
    }

    public LivroDTO create(LivroDTO livroDTO) {
        if (livroDTO != null) {
            Livro mapped = livroMapper.DTOtoLivro(livroDTO);
            return livroMapper.LivroToDTO(livroRepository.save(mapped));
        }
        return null;
    }

    public List<LivroDTO> findAll() {
        List<Livro> livros = livroRepository.findAll();
        List<LivroDTO> livrosDTO = new ArrayList<LivroDTO>();
        for (Livro l : livros) {
            LivroDTO dto = livroMapper.LivroToDTO(l);
            livrosDTO.add(dto);
        }
        return livrosDTO;
    }

    public LivroDTO update(Long id, LivroDTO livroDTO) {
        Optional<Livro> talvezLivro = livroRepository.findById(id);
        Livro livro = null;
        if (talvezLivro.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Livro não encontrado");
        }
        livro = talvezLivro.get();

        if (livro != null) {
            Livro mapped = livroMapper.DTOtoLivro(livroDTO);
            mapped.setId(livro.getId());
            return livroMapper.LivroToDTO(livroRepository.save(mapped));
        }
        return null;
    }


    public boolean deleteById(Long id) {
        if (id != null) {
            if (livroRepository.existsById(id)) {
                livroRepository.deleteById(id);
                return true;
            }
        }
        return false;
    }


}
