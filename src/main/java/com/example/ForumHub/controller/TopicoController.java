package com.example.ForumHub.controller;

import com.example.ForumHub.dto.DadosCadastroTopico;
import com.example.ForumHub.dto.DadosDetalhamentoTopico;
import com.example.ForumHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar (@RequestBody @Valid DadosCadastroTopico dados) {
        var topico = topicoService.criarTopico(dados);

        var dadosDetalhamento = new DadosDetalhamentoTopico(topico);

        return ResponseEntity.ok(dadosDetalhamento);
    }
}
