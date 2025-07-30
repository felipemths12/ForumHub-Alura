# ForumHub API

## 📖 Sobre

A API ForumHub é um projeto de um fórum de discussões desenvolvido como parte do Challenge de Back-end da Alura em parceria com a Oracle (ONE). A aplicação permite que usuários se cadastrem, autentiquem e interajam com tópicos de discussão, incluindo a criação, visualização, atualização e exclusão dos mesmos.

## ✨ Funcionalidades

* **Autenticação e Autorização:** Sistema de login com geração de token JWT para proteger as rotas da aplicação.
* **Gerenciamento de Usuários:** Cadastro de novos usuários no sistema.
* **Gerenciamento de Tópicos:**
    * Listagem paginada de todos os tópicos.
    * Detalhamento de um tópico específico por ID.
    * Cadastro de novos tópicos, com validação para evitar duplicatas.
    * Atualização de informações de um tópico existente.
    * Exclusão de tópicos.
* **Banco de Dados:** Utiliza o MySQL como banco de dados e Flyway para o versionamento e controle das migrações do esquema.

## 🛠️ Tecnologias Utilizadas

O projeto foi construído com as seguintes tecnologias e dependências:

* **Java 21**
* **Spring Boot 3**
* **Spring Security** para a camada de segurança
* **Spring Data JPA** para persistência de dados
* **MySQL** como banco de dados relacional
* **Flyway** para migrações do banco de dados
* **Maven** para gerenciamento de dependências
* **Lombok** para reduzir código boilerplate
* **Java JWT (auth0)** para geração e validação de tokens JWT

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/ForumHub-Alura.git](https://github.com/seu-usuario/ForumHub-Alura.git)
    ```

2.  **Configure o Banco de Dados:**
    * Certifique-se de ter o MySQL instalado e em execução.
    * Abra o arquivo `src/main/resources/application.properties` e altere as seguintes propriedades com as suas credenciais do MySQL:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
        spring.datasource.username=seu-usuario
        spring.datasource.password=sua-senha
        ```
    * O banco de dados `forumhub` será criado automaticamente na primeira execução se não existir.

3.  **Execute a Aplicação:**
    * Você pode executar o projeto diretamente pela sua IDE (IntelliJ, Eclipse, etc.), localizando a classe `ForumHubApplication.java` e executando o método `main`.
    * Alternativamente, você pode usar o Maven Wrapper para compilar e executar o projeto via linha de comando:
        ```bash
        ./mvnw spring-boot:run
        ```

4.  **Acesse a API:**
    * Após a inicialização, a API estará disponível em `http://localhost:8080`.

## Endpoints da API

A seguir estão os principais endpoints disponíveis na API:

### Autenticação

* `POST /login`: Efetua o login de um usuário e retorna um token JWT para autenticação.

    **Exemplo de corpo da requisição:**
    ```json
    {
      "email": "usuario@exemplo.com",
      "senha": "123"
    }
    ```

### Usuários

* `POST /usuarios`: Cadastra um novo usuário no sistema.

    **Exemplo de corpo da requisição:**
    ```json
    {
      "nome": "Nome do Usuário",
      "email": "usuario@exemplo.com",
      "senha": "123"
    }
    ```

### Tópicos

* `GET /topicos`: Lista todos os tópicos de forma paginada.
* `GET /topicos/{id}`: Detalha um tópico específico pelo seu ID.
* `POST /topicos`: Cria um novo tópico. Requer token de autenticação.
* `PUT /topicos/{id}`: Atualiza um tópico existente. Requer token de autenticação.
* `DELETE /topicos/{id}`: Deleta um tópico. Requer token de autenticação.

Para os endpoints protegidos, é necessário enviar o token JWT no cabeçalho `Authorization`:
`Authorization: Bearer <seu-token-jwt>`
