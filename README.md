# Desafio NATI - Backend

## Backend
Módulo do desafio NATI

## Features
- Api de login dá aplicação (web e apps)
- Api para os CRUD's de Usuários, Curso e Disciplina
- Api para validação do token de acesso a aplicação

## Tecnologias utilizadas

- [Spring Boot 2.2.4.RELEASE](https://spring.io/projects/spring-boot)
- [Java 8](https://www.java.com/pt-BR/)
- [PostgresSql](https://www.postgresql.org/)
- [JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Apache Maven](https://maven.apache.org/)

## Instalação
Faça o clone do projeto no git, canto superior direito no repositório do projeto(Botão 'Code').

[Download do JDK 8](https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html)
Baixe a versão da JDK e utilize dela para rodar o projeto já clonado.

## Funcionamento da Aplicação
Autenticação foi feita apenas com email de um usuário.

Usuários foram catalogados por 4 tipos de numeros inteiros:
0 - Aluno
1 - Professor
2 - Administrador
3 - Coordenador

## Base de Dados- Relações
Banco de dados, usuário tem relação n para n com curso e disciplina, curso tem relação de n para n com usuário e semestre, além de um para n com disciplina, semestre tem relação n para n com curso e disciplina.
