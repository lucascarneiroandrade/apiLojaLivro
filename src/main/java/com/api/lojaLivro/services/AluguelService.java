package com.api.lojaLivro.services;

import com.api.lojaLivro.dto.AluguelDTO;
import com.api.lojaLivro.mappers.AluguelMapper;
import com.api.lojaLivro.mappers.LivroMapper;
import com.api.lojaLivro.models.Aluguel;
import com.api.lojaLivro.repositorios.AluguelRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AluguelService {
    private final LivroService livroService;

    private final AluguelRepositorio aluguelRepositorio;

    private final float PRIMEIRA_SEMANA_PENALIDADE = 3.00f;

    private final int PERIODO_ALUGUEL = 14;

    private final float PENALIDADE_DIARIA = 1f;

    private final LivroMapper livroMapper;

    private final AluguelMapper aluguelMapper;

    @Autowired
    public AluguelService(AluguelRepositorio aluguelRepositorio, LivroService livroService, LivroMapper livroMapper, AluguelMapper aluguelMapper){
        this.aluguelRepositorio = aluguelRepositorio;
        this.livroService = livroService;
        this.livroMapper = livroMapper;
        this.aluguelMapper = aluguelMapper;
    }



    public List<AluguelDTO> findAll(){
        List<Aluguel> aluguels = aluguelRepositorio.findAll();
        List<AluguelDTO> aluguelDTO = new ArrayList<AluguelDTO>();
        for (Aluguel a : aluguels){
            AluguelDTO dto = aluguelMapper.aluguelToDTO(a);
            aluguelDTO.add(dto);
        }
        return aluguelDTO;
    }

   /* @Override
    public AluguelDTO create(Livro livro){
        if(hasPenalty(getCurrentUser()))
            throw new RuntimeException("Você não pode alugar um livro pois possui uma penalidade");
        if (livro != null){
            if (livro.isAlugado())
                throw new RuntimeException("Você não pode alugar um livro indisponível");

            livro.setAlugado(true);
            livroService.update(livroMapper.LivroToDTO(livro));
            LocalDate dataAtual = LocalDate.now();
            return aluguelMapper.aluguelToDTO(aluguelRepositorio.save(Aluguel.builder()
                    .livro(livro)
                    .aluguelData(dataAtual)
                    .devolucaoData(dataAtual.plusDays((PERIODO_ALUGUEL))
                            .devolvido(false)
                            .usuario(getCurrentUser())
                            .penalidade(0f)
                            .build()
                    )));}
        return null;{
        }
    }
*/
    /*
    public AluguelDTO devolverLivro(Aluguel aluguel){
        if (aluguel != null){
            if (!aluguel.isDevolvido()){
                Livro aluguelLivro = aluguel.getLivro();
                aluguelLivro.setAlugado(false);
                livroService.update(livroMapper.LivroToDTO(aluguelLivro));
                aluguel.setDevolvido(true);

                LocalDate dataAtual = LocalDate.now();
                float penalidade = 0;
                if (dataAtual.isAfter(aluguel.getDevolucaoData())){
                    long dias = Duration.between((aluguel.getDevolucaoData().atStartOfDay()), dataAtual.atStartOfDay()).toDays();
                    if (dias > 0){
                        penalidade = dias <=7
                                ? PRIMEIRA_SEMANA_PENALIDADE
                                : PRIMEIRA_SEMANA_PENALIDADE + (dias - 7) * PENALIDADE_DIARIA;
                    }
                }
                aluguel.setPenalidade(penalidade);
            }
            return aluguelMapper.aluguelToDTO(aluguelRepositorio.save(aluguel));
        } else {
            throw new RuntimeException(("Aluguel inválido!"));
        }
    }*/


}
