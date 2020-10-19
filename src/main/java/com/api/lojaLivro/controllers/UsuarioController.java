package com.api.lojaLivro.controllers;


import com.api.lojaLivro.dto.UsuarioDTO;
import com.api.lojaLivro.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDTO> findAll(){
        return usuarioService.findAll();
    }

    @PostMapping
    public UsuarioDTO create (@Valid @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.create(usuarioDTO);
    }

    @PutMapping("/{id}")
    public UsuarioDTO update (@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.update(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return usuarioService.deleteById(id);
    }





}
