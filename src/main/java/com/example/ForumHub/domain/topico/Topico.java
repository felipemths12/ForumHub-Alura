package com.example.ForumHub.domain.topico;


import com.example.ForumHub.domain.curso.Curso;
import com.example.ForumHub.domain.resposta.Resposta;
import com.example.ForumHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List <Resposta> respostas;
}
