package com.api.lojaLivro.services;

import com.api.lojaLivro.dto.ReservaDTO;
import com.api.lojaLivro.exception.EntidadeNaoEncontradaException;
import com.api.lojaLivro.exception.ErroInternoException;
import com.api.lojaLivro.exception.RegraDeNegocioException;
import com.api.lojaLivro.mappers.LivroMapper;
import com.api.lojaLivro.mappers.ReservaMapper;
import com.api.lojaLivro.models.Livro;
import com.api.lojaLivro.models.Reserva;
import com.api.lojaLivro.models.Usuario;
import com.api.lojaLivro.repositories.LivroRepository;
import com.api.lojaLivro.repositories.ReservaRepository;
import com.api.lojaLivro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservaService {


    private final LivroMapper livroMapper;

    private final LivroRepository livroRepository;

    private final UsuarioRepository usuarioRepository;

    private final ReservaRepository reservaRepository;

    private final ReservaMapper reservaMapper;


    @Autowired
    public ReservaService(LivroMapper livroMapper, LivroRepository livroRepository, UsuarioRepository usuarioRepository, ReservaRepository reservaRepository, ReservaMapper reservaMapper) {
        this.livroMapper = livroMapper;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
    }

    public ReservaDTO reservarLivro(Long idLivro, Long idUsuario) {
        Optional<Livro> talvezLivro = livroRepository.findById(idLivro);
        Optional<Usuario> talvezUsuario = usuarioRepository.findById(idUsuario);
        Livro livro = null;
        Usuario usuario = null;
        if (talvezLivro.isEmpty() || talvezUsuario.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Livro ou Usuário não encontrado");
        }
        livro = talvezLivro.get();
        usuario = talvezUsuario.get();

        if (livro.isReservado() || livro.isAlugado()) {
            throw new RegraDeNegocioException("Livro indisponível para reserva");
        }
        livro.setReservado(true);
        livroRepository.save(livro);

        return reservaMapper.reservaDTO(reservaRepository.save(Reserva.builder()
                .dataReserva(LocalDate.now())
                .livro(livro)
                .usuario(usuario)
                .build()));
    }

    public void cancelarReserva(Long idReserva) {

        Optional<Reserva> talvezReserva = reservaRepository.findById(idReserva);
        Reserva reserva = null;
        if (talvezReserva.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Reserva não encontrada");
        }
        reserva = talvezReserva.get();

        Optional<Livro> talvezLivro = livroRepository.findById(reserva.getLivro().getId());
        Livro livro = null;
        if (talvezLivro.isEmpty()) {
            throw new ErroInternoException("Ocorreu um erro inesperado, livro não encontrado");
        }
        livro = talvezLivro.get();
        livro.setReservado(false);
        reservaRepository.delete(reserva);


    }


}
