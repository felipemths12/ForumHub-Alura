package com.example.ForumHub.service;

import com.example.ForumHub.domain.usuario.Usuario;
import com.example.ForumHub.dto.DadosCadastroUsuario;
import com.example.ForumHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario criarUsuario(DadosCadastroUsuario dados) {
        if (usuarioRepository.findByEmail(dados.email()) != null) {
            throw new IllegalArgumentException("Usuário com este e-mail já existe.");
        }

        var senhaCriptografada = passwordEncoder.encode(dados.senha());
        var novoUsuario = new Usuario(null, dados.nome(), dados.email(), senhaCriptografada);

        return usuarioRepository.save(novoUsuario);
    }
}