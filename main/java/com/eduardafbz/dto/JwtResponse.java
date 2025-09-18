package com.eduardafbz.dto;
// "dto" indica que a classe é um Data Transfer Object, usada para transferir dados entre cliente e servidor.

public class JwtResponse {
    // Classe pública chamada JwtResponse.
    // Representa a resposta da autenticação, contendo apenas o token JWT.

    private String token;
    // Atributo privado que armazena o token JWT gerado.

    public JwtResponse(String token) {
        this.token = token;
    }
    // Construtor da classe.
    // Ele recebe o token como parâmetro e inicializa o atributo "token".

    public String getToken() {
        return token;
    }
    // Getter para acessar o valor do token.
    // Como o cliente só precisa ler o token, não existe setter aqui.
}