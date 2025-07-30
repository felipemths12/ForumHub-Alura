package com.example.ForumHub.controller;

import com.example.ForumHub.dto.DadosCadastroUsuario;
import com.example.ForumHub.dto.DadosDetalhamentoUsuario;
import com.example.ForumHub.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
        var novoUsuario = usuarioService.criarUsuario(dados);
        var dadosDetalhamento = new DadosDetalhamentoUsuario(novoUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(dadosDetalhamento);
    }
}