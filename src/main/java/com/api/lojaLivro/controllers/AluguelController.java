package com.api.lojaLivro.controllers;

import com.api.lojaLivro.dto.AluguelDTO;
import com.api.lojaLivro.models.Aluguel;
import com.api.lojaLivro.models.Livro;
import com.api.lojaLivro.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public AluguelDTO alugarLivro(@PathVariable("id") Livro livro) {
        //return aluguelService.create(livro);
        return null;
    }

    @GetMapping("/return/{id}")
    public AluguelDTO devolverLivro(@PathVariable("id") Aluguel aluguel) {
        //return aluguelService.devolverLivro(aluguel);
        return null;
    }
}
