package com.api.lojaLivro.services;

import com.api.lojaLivro.dto.AluguelDTO;
import com.api.lojaLivro.mappers.AluguelMapper;
import com.api.lojaLivro.mappers.LivroMapper;
import com.api.lojaLivro.models.Aluguel;
import com.api.lojaLivro.models.Livro;
import com.api.lojaLivro.models.Usuario;
import com.api.lojaLivro.repositories.AluguelRepository;
import com.api.lojaLivro.repositories.LivroRepository;
import com.api.lojaLivro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {
    private final LivroService livroService;

    private final AluguelRepository aluguelRepository;

    private final LivroMapper livroMapper;

    private final AluguelMapper aluguelMapper;

    private final LivroRepository livroRepository;

    private final UsuarioRepository usuarioRepository;

    private final float PRIMEIRA_SEMANA_PENALIDADE = 3.00f;

    private final int PERIODO_ALUGUEL = 14;

    private final float PENALIDADE_DIARIA = 1f;

    @Autowired
    public AluguelService(AluguelRepository aluguelRepository, LivroService livroService, LivroMapper livroMapper, AluguelMapper aluguelMapper, LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        this.aluguelRepository = aluguelRepository;
        this.livroService = livroService;
        this.livroMapper = livroMapper;
        this.aluguelMapper = aluguelMapper;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;

    }


    public List<AluguelDTO> findAll() {
        List<Aluguel> aluguels = aluguelRepository.findAll();
        List<AluguelDTO> aluguelDTO = new ArrayList<AluguelDTO>();
        for (Aluguel a : aluguels) {
            AluguelDTO dto = aluguelMapper.aluguelToDTO(a);
            aluguelDTO.add(dto);
        }
        return aluguelDTO;
    }


    public AluguelDTO create(Long idLivro, Long idUsuario) {

        Optional<Livro> talvezLivro = livroRepository.findById(idLivro);
        Optional<Usuario> talvezUsuario = usuarioRepository.findById(idUsuario);
        Livro livro = null;
        Usuario usuario = null;
        if (talvezLivro.isEmpty() || talvezUsuario.isEmpty()) {
            throw new RuntimeException("Livro ou usuário não encontrados");
        }
        livro = talvezLivro.get();
        usuario = talvezUsuario.get();


        if (hasPenalty(usuario))
            throw new RuntimeException("Você não pode alugar um livro pois possui uma penalidade");

        if (livro.isAlugado())
            throw new RuntimeException("Você não pode alugar um livro indisponível");

        livro.setAlugado(true);
        livroService.update(livroMapper.LivroToDTO(livro));
        LocalDate dataAtual = LocalDate.now();
        return aluguelMapper.aluguelToDTO(aluguelRepository.save(Aluguel.builder()
                .livro(livro)
                .aluguelData(dataAtual)
                .devolucaoData(dataAtual.plusDays((PERIODO_ALUGUEL)))
                .devolvido(false)
                .usuario(usuario)
                .penalidade(0f)
                .build()
        ));


    }


    public AluguelDTO devolverLivro(Long idAluguel) {

        Optional<Aluguel> talvezAluguel = aluguelRepository.findById(idAluguel);
        Aluguel aluguel = null;
        if (talvezAluguel.isEmpty()) {
            throw new RuntimeException("Aluguel não encontrado");
        }
        aluguel = talvezAluguel.get();


        if (!aluguel.isDevolvido()) {
            Livro aluguelLivro = aluguel.getLivro();
            aluguelLivro.setAlugado(false);
            livroService.update(livroMapper.LivroToDTO(aluguelLivro));
            aluguel.setDevolvido(true);

            LocalDate dataAtual = LocalDate.now();
            float penalidade = 0;
            if (dataAtual.isAfter(aluguel.getDevolucaoData())) {
                long dias = Duration.between((aluguel.getDevolucaoData().atStartOfDay()), dataAtual.atStartOfDay()).toDays();
                if (dias > 0) {
                    penalidade = dias <= 7
                            ? PRIMEIRA_SEMANA_PENALIDADE
                            : PRIMEIRA_SEMANA_PENALIDADE + (dias - 7) * PENALIDADE_DIARIA;
                }
            }
            aluguel.setPenalidade(penalidade);
        }
        return aluguelMapper.aluguelToDTO(aluguelRepository.save(aluguel));

    }

    private boolean hasPenalty(Usuario usuario) {
        return aluguelRepository.findAllByUsuario(usuario)
                .stream()
                .filter(e -> !e.isDevolvido())
                .anyMatch(e -> LocalDate.now().isAfter(e.getDevolucaoData()));
    }


}
