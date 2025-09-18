package com.eduardafbz.security; 

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
// Importa classes da biblioteca jjwt (JSON Web Token).
// - Claims: representa as informações (payload) dentro do token.
// - Jwts: classe utilitária para criar, analisar e validar tokens.
// - SignatureAlgorithm: enum que define o algoritmo de assinatura (ex: HS256).

import java.util.Date;
import java.util.function.Function;
// Date: usado para definir datas de criação e expiração do token.
// Function: permite passar funções como parâmetro para manipular claims.

@Service
public class JwTokenService {

    @Value("${jwt.secret}")
    private String secret;
    // Injeta do arquivo application.properties (ou application.yml)
    // a chave secreta usada para assinar/verificar os tokens.

    @Value("${jwt.expiration}")
    private long expirationMs;
    // Injeta do arquivo application.properties a validade do token (em milissegundos).

    // geração do token
    public String generateToken(String username) {
        return Jwts.builder() // Cria um construtor de token.
                .setSubject(username) // Define o "subject" (normalmente o username).
                .setIssuedAt(new Date(System.currentTimeMillis())) // Data/hora de criação.
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs)) // Define quando expira.
                .signWith(SignatureAlgorithm.HS256, secret) // Assina o token com algoritmo HS256 e a chave secreta.
                .compact(); // Finaliza e retorna o token como uma String.
    }

    // extração de informações 
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
        // Usa o método extractClaim para pegar o "subject" do token (o username).
    }

    // Verifica se o token já expirou
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
        // Pega a data de expiração do token e compara com a data atual.
    }

    // validação do token
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        // Extrai o usuário dentro do token.
        return (extractedUsername.equals(username) && !isTokenExpired(token));
        // O token é válido se:
        // 1. O usuário do token for igual ao esperado.
        // 2. O token ainda não tiver expirado.
    }

    // métodos auxiliares
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
        // Extrai a data de expiração usando extractClaim.
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        // Extrai todos os claims do token.
        return claimsResolver.apply(claims);
        // Aplica a função recebida (ex: getSubject ou getExpiration).
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser() // Cria um parser para decodificar o token.
                .setSigningKey(SECRET_KEY) // Define a chave usada para validar a assinatura.
                .parseClaimsJws(token) // Faz o parse do token JWT.
                .getBody(); // Retorna o corpo (payload) com os claims.
    }
}