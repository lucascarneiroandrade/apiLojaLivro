package com.api.lojaLivro.mappers;

import com.api.lojaLivro.dto.AluguelDTO;
import com.api.lojaLivro.dto.ReservaDTO;
import com.api.lojaLivro.models.Aluguel;
import com.api.lojaLivro.models.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {


    public ReservaDTO reservaDTO(Reserva reserva) {
        if (reserva == null) {
            return null;
        } else {
            ReservaDTO reservaDTO = new ReservaDTO();
            reservaDTO.setId(reserva.getId());
            reservaDTO.setLivro(reserva.getLivro());
            reservaDTO.setUsuario(reserva.getUsuario());
            reservaDTO.setDataReserva(reserva.getDataReserva());
            return reservaDTO;


        }

    }

    public Reserva DTOtoReserva(ReservaDTO reservaDTO) {
        if (reservaDTO == null) {
            return null;
        } else {
            Reserva reserva = new Reserva();
            reserva.setLivro(reservaDTO.getLivro());
            reserva.setUsuario(reservaDTO.getUsuario());
            reserva.setDataReserva(reservaDTO.getDataReserva());
            return reserva;
        }
    }


}

