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
            livroDTO.setAutor(livro.getAutor());
            livroDTO.setAlugado(livro.isAlugado());
            livroDTO.setReservado(livro.isReservado());

            return livroDTO;

        }
    }

    public Livro DTOtoLivro(LivroDTO livroDTO){
        if(livroDTO == null){
            return null;
        } else {
            Livro livro = new Livro();
            livro.setTitulo(livroDTO.getTitulo());
            livro.setAutor(livroDTO.getAutor());
            livro.setAlugado(livroDTO.isAlugado());
            livro.setReservado(livroDTO.isReservado());

            return livro;
        }
    }
}
