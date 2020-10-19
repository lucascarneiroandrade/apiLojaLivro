package com.api.lojaLivro.controllers;

import com.api.lojaLivro.dto.ReservaDTO;
import com.api.lojaLivro.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/{idLivro}/{idUsuario}")
    public ReservaDTO reservarLivro(@PathVariable("idLivro") Long idLivro, @PathVariable("idUsuario") Long idUsuario) {
        return reservaService.reservarLivro(idLivro, idUsuario);

    }

    @DeleteMapping("/{idReserva}")
    public void cancelarReserva(@PathVariable("idReserva") Long idReserva) {
        reservaService.cancelarReserva(idReserva);
    }


}
