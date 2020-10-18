package com.api.lojaLivro.controllers;

import com.api.lojaLivro.dto.AluguelDTO;
import com.api.lojaLivro.models.Aluguel;
import com.api.lojaLivro.models.Livro;
import com.api.lojaLivro.models.Usuario;
import com.api.lojaLivro.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/aluguel")
public class AluguelController {
    private final AluguelService aluguelService;

    @Autowired
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public List<AluguelDTO> findAll() {
        return aluguelService.findAll();
    }

    @PostMapping("/{idLivro}/{idUsuario}")
    public AluguelDTO alugarLivro(@PathVariable("idLivro") Long idLivro, @PathVariable("idUsuario") Long idUsuario) {
        return aluguelService.create(idLivro, idUsuario);

    }

    @PutMapping("/return/{idAluguel}")
    public AluguelDTO devolverLivro(@PathVariable("idAluguel") Long idAluguel) {
        return aluguelService.devolverLivro(idAluguel);

    }
}
