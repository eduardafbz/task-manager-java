# TaskManager - Projeto de Gerenciamento de Tarefas
Este é um projeto evolutivo de um sistema de gerenciamento de tarefas (Task Manager), desenvolvido com o objetivo de praticar e demonstrar a progressão de conhecimento em Java, boas práticas de programação, persistência de dados, arquitetura e organização de código.

---

## Objetivo

Criar um projeto simples e ir aprimorando gradualmente seus recursos, arquitetura e tecnologias utilizadas, simulando como aplicações reais são construídas e mantidas com o tempo.

---

## Tecnologias utilizadas (por nível)

- Java
- IDE: VS Code / IntelliJ
- H2 Database (nível 2+)
- Spring Boot (nível 3+)
- Git & GitHub

---

## Níveis de Evolução do Projeto

Cada nível representa uma etapa de aprendizado e melhoria da aplicação.

### 🔹 **Nível 1 – Estrutura Básica (Console e Lista em Memória)**
- CRUD de tarefas (adicionar, listar, atualizar, remover)
- Interface via terminal com `Scanner`
- Dados salvos em uma `List<String>`
- Estrutura simples com classes `Main` e `Functions`
- Nenhuma persistência (os dados se perdem ao encerrar)

✅ *Status:* Concluído

---

### 🔹 **Nível 2 – Persistência em Arquivo**
- Salvar tarefas em um arquivo `.txt`
- Carregar tarefas automaticamente na inicialização
- Uso de `FileWriter` e `BufferedReader`
- Separação de lógica de persistência

✅ *Status:* Em andamento

---

### 🔹 **Nível 3 – Arquitetura em Camadas**
- Separar responsabilidades em: Model, Service, Repository, Controller
- Organização de pacotes por domínio
- Aplicação de boas práticas (ex: princípio da responsabilidade única)

🔜 *Status:* Em breve

---

### 🔹 **Nível 4 – API REST com Spring Boot**
- Transformar o sistema em uma API RESTful
- Endpoints para CRUD de tarefas (`GET`, `POST`, `PUT`, `DELETE`)
- Retorno e recebimento de dados em JSON

🔜 *Status:* Em breve

---

### 🔹 **Nível 5 – Integração com Frontend**
- Criar uma interface web para consumo da API
- Pode ser com HTML/CSS/JS ou frameworks como React
- Separação total entre frontend e backend

🔜 *Status:* Em breve

---

### 🔹 **Nível 6 – Autenticação de Usuários**
- Criar sistema de cadastro e login
- Cada usuário gerencia suas próprias tarefas
- Uso de tokens JWT e Spring Security

🔜 *Status:* Em breve

---

### 🔹 **Nível 7 – Testes Automatizados**
- Testes unitários com JUnit
- Testes de integração com Spring Test
- Garantia de funcionamento da aplicação após mudanças

🔜 *Status:* Em breve

---

### 🔹 **Nível 8 – Deploy**
- Publicar a aplicação em nuvem (Render, Vercel, Heroku ou com Docker)
- Fazer deploy da API e/ou frontend para acesso externo

🔜 *Status:* Em breve

---

### 🔹 **Nível 9 – Documentação e Profissionalização**
- README completo e atualizado ✅
- Swagger UI para documentação da API
- Uso de `.gitignore`, boas mensagens de commit e organização do repositório

🔜 *Status:* Em breve

---

## ✨ Como rodar o projeto (nível 1)
```bash
git clone https://github.com/seu-usuario/taskmanager.git
cd taskmanager
# Abrir no VS Code ou IntelliJ e rodar o arquivo Main.java
````

---

## 📚 Aprendizados

Este projeto é uma forma prática de fixar conceitos como:

* Evolução progressiva de sistemas
* Boas práticas em Java
* Persistência de dados
* Arquitetura orientada a camadas
* Desenvolvimento de APIs RESTful
* Testes e deploy

---

## 🙋‍♀️ Feito por

**Maria Eduarda Braz**
