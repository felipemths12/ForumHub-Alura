package com.example.ForumHub.service;

import com.example.ForumHub.domain.curso.Curso;
import com.example.ForumHub.domain.topico.StatusTopico;
import com.example.ForumHub.domain.topico.Topico;
import com.example.ForumHub.domain.usuario.Usuario;
import com.example.ForumHub.dto.DadosCadastroTopico;
import com.example.ForumHub.repository.CursoRepository;
import com.example.ForumHub.repository.TopicoRepository;
import com.example.ForumHub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Topico criarTopico(DadosCadastroTopico dados) {
        if(topicoRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            throw new IllegalArgumentException("Tópico duplicado: já existe um tópico com mesmo título e mensagem");
        }

        Usuario autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));

        Curso curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        Topico novoTopico = new Topico(
                null,
                dados.titulo(),
                dados.mensagem(),
                LocalDateTime.now(),
                StatusTopico.NAO_RESOLVIDO,
                autor,
                curso,
                null
        );

        return topicoRepository.save(novoTopico);
    }
}
