package com.api.lojaLivro.mappers;

import com.api.lojaLivro.dto.LivroDTO;
import com.api.lojaLivro.models.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {
    public LivroDTO LivroToDTO(Livro livro){
        if (livro == null){
            return null;
        } else{
            LivroDTO livroDTO = new LivroDTO();
            livroDTO.setId(livro.getId());
            livroDTO.setTitulo(livro.getTitulo());
            livroDTO.setAlugado(livro.isAlugado());

            return livroDTO;

        }
    }

    public Livro DTOtoLivro(LivroDTO livroDTO){
        if(livroDTO == null){
            return null;
        } else {
            Livro livro = new Livro();
            livro.setId(livroDTO.getId());
            livro.setTitulo(livro.getTitulo());
            livro.setAlugado(livro.isAlugado());

            return livro;
        }
    }
}