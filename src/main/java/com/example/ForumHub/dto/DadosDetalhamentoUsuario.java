package com.example.ForumHub.dto;

import com.example.ForumHub.domain.usuario.Usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String email) {

    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}