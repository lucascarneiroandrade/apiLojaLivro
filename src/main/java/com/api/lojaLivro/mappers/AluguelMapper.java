package com.api.lojaLivro.mappers;

import com.api.lojaLivro.dto.AluguelDTO;
import com.api.lojaLivro.models.Aluguel;
import org.springframework.stereotype.Component;

@Component
public class AluguelMapper {
    public Aluguel DTOtoAluguel(AluguelDTO aluguelDTO){
        if (aluguelDTO == null){
            return null;
        } else {
            Aluguel aluguel = new Aluguel();
            aluguel.setPenalidade(aluguelDTO.getPenalidade());
            aluguel.setId(aluguelDTO.getId());
            aluguel.setDevolvido(aluguelDTO.isDevolvido());
            aluguel.setLivro(aluguelDTO.getLivro());
            aluguel.setDevolucaoData(aluguelDTO.getDevolucaoData());
            //aluguel.setUsuario(aluguelDTO.getUsuario());
            aluguel.setAluguelData(aluguelDTO.getAluguelData());
            return aluguel;
        }
    }

    public AluguelDTO aluguelToDTO(Aluguel aluguel){
        if (aluguel == null) {
            return null;
        } else {
            AluguelDTO aluguelDTO = new AluguelDTO();
            aluguelDTO.setPenalidade(aluguel.getPenalidade());
            aluguelDTO.setId(aluguel.getId());
            aluguelDTO.setDevolvido(aluguel.isDevolvido());
            aluguelDTO.setLivro(aluguel.getLivro());
            aluguelDTO.setDevolucaoData(aluguel.getDevolucaoData());
            //aluguelDTO.setUsuario(aluguel.getUsuario());
            aluguelDTO.setAluguelData(aluguel.getAluguelData());
            return aluguelDTO;


        }
    }
}
