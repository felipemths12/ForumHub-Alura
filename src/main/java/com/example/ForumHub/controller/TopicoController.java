package com.example.ForumHub.controller;

import com.example.ForumHub.dto.DadosCadastroTopico;
import com.example.ForumHub.dto.DadosDetalhamentoTopico;
import com.example.ForumHub.repository.TopicoRepository;
import com.example.ForumHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar (@RequestBody @Valid DadosCadastroTopico dados) {
        var topico = topicoService.criarTopico(dados);

        var dadosDetalhamento = new DadosDetalhamentoTopico(topico);

        return ResponseEntity.ok(dadosDetalhamento);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var pageDeTopicos = topicoRepository.findAll(paginacao);

        var pageDeTopicosDTO = pageDeTopicos.map(DadosDetalhamentoTopico::new);

        return ResponseEntity.ok(pageDeTopicosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {
        var topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            var dadosDetalhamento = new DadosDetalhamentoTopico(topico.get());
            return ResponseEntity.ok(dadosDetalhamento);
        }

        return ResponseEntity.notFound().build();
    }


}

