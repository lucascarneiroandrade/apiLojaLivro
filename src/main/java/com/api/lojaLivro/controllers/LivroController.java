package com.api.lojaLivro.controllers;

import com.api.lojaLivro.dto.LivroDTO;
import com.api.lojaLivro.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/livro")
public class LivroController {
    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroDTO> findAll() {
        return livroService.findAll();
    }

    @PostMapping
    public LivroDTO create(@Valid @RequestBody LivroDTO livroDTO) {
        return livroService.create(livroDTO);
    }

    @PutMapping("/{id}")
    public LivroDTO update(@PathVariable Long id, @Valid @RequestBody LivroDTO livroDTO) {
        return livroService.update(id, livroDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return livroService.deleteById(id);
    }
}
