-- V1__create_all_tables.sql

-- Cria a tabela de usuários
CREATE TABLE usuarios (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          nome VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL,
                          PRIMARY KEY (id)
);

-- Cria a tabela de cursos
CREATE TABLE cursos (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        nome VARCHAR(255) NOT NULL,
                        categoria_curso VARCHAR(100) NOT NULL,
                        PRIMARY KEY (id)
);

-- Cria a tabela de tópicos
CREATE TABLE topicos (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         titulo VARCHAR(255) NOT NULL UNIQUE,
                         mensagem TEXT NOT NULL,
                         data_criacao DATETIME NOT NULL,
                         status VARCHAR(100) NOT NULL,
                         autor_id BIGINT NOT NULL,
                         curso_id BIGINT NOT NULL,
                         PRIMARY KEY (id),
                         FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                         FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

-- Cria a tabela de respostas
CREATE TABLE respostas (
                           id BIGINT NOT NULL AUTO_INCREMENT,
                           mensagem TEXT NOT NULL,
                           data_criacao DATETIME NOT NULL,
                           solucao BOOLEAN DEFAULT FALSE,
                           topico_id BIGINT NOT NULL,
                           autor_id BIGINT NOT NULL,
                           PRIMARY KEY (id),
                           FOREIGN KEY (topico_id) REFERENCES topicos(id),
                           FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);