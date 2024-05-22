# Student Management System

Este projeto é um sistema de gerenciamento de estudantes construído utilizando Spring Boot 3 e JPA. O objetivo do projeto é fornecer uma API para realizar operações CRUD (Create, Read, Update, Delete) na entidade `Student`.

## Estrutura do Projeto

- **Entity**: A classe `Student` mapeia a tabela `student` no banco de dados.
- **DAO**: A interface `StudentDAO` define os métodos para operações CRUD, enquanto a implementação `StudentDAOImpl` realiza essas operações utilizando o `EntityManager`.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- JPA (Jakarta Persistence API)
- MySQL
- Maven

## Configuração do Projeto

### Pré-requisitos

- Java JDK 17
- Maven
- MySQL Server
