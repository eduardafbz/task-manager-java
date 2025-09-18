package com.eduardafbz.dto; 

public class LoginRequest {
    // Classe pública chamada LoginRequest.
    // Representa o objeto que vai carregar as informações do login (username e password).

    private String username;
    private String password;
    // Duas variáveis privadas (encapsulamento).
    // - username: armazena o nome do usuário.
    // - password: armazena a senha do usuário.

    public String getUsername() {
        return username;
    }
    // Getter para acessar o valor do atributo username.

    public void setUsername(String username) {
        this.username = username;
    }
    // Setter para alterar o valor do atributo username.

    public String getPassword() {
        return password;
    }
    // Getter para acessar o valor do atributo password.

    public void setPassword(String password) {
        this.password = password;
    }
    // Setter para alterar o valor do atributo password.
}