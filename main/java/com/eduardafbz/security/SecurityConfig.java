package com.eduardafbz.security; 

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// Imports necessários:
// - Configuration: marca a classe como configuração do Spring.
// - EnableWebSecurity: ativa o Spring Security na aplicação.
// - BCryptPasswordEncoder: implementa um algoritmo seguro para encriptar senhas.

@Configuration
@EnableWebSecurity
public class SecurityConfig {
// @Configuration: indica que essa classe contém definições de configuração do Spring.
// @EnableWebSecurity: habilita os recursos de segurança da web (filtros, autenticação, etc).

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // Define um bean do tipo PasswordEncoder.
        // O BCrypt é usado para criptografar senhas antes de salvar no banco
        // e também para verificar senhas durante o login.
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Define a cadeia de filtros de segurança do Spring Security.
        // O HttpSecurity permite configurar quais rotas precisam de autenticação
        // e como o login/logout serão tratados.

        http.csrf(csrf -> csrf.disable())
            // Desabilita a proteção CSRF (Cross-Site Request Forgery).
            // Isso geralmente é feito em APIs REST, onde o CSRF não é necessário.
            
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/login", "/users/register").permitAll()
                // Essas rotas (login e registro) ficam liberadas sem autenticação.
                
                .anyRequest().authenticated()
                // Qualquer outra requisição precisa estar autenticada.
                
                .and()
                .formLogin() 
                // Habilita o login via formulário padrão do Spring Security.
                // (aquele form básico que ele gera automaticamente).
            );

        return http.build();
        // Constrói e retorna a configuração da cadeia de filtros de segurança.
    }
}