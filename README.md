# API de Gerenciamento de Tarefas

Sistema simples para gerenciar tarefas desenvolvido com Spring Boot.

## Sobre o Projeto

Esta é uma API REST que permite criar, listar, atualizar e excluir tarefas. Foi desenvolvida durante meus estudos de Spring Boot e JPA para praticar conceitos de desenvolvimento backend.

## Tecnologias

- Java 21
- Spring Boot 3.5.5
- Spring Data JPA
- MySQL
- Maven

## Estrutura

```
src/main/java/com/example/projeto_api/
├── ProjetoApiApplication.java
├── Controller/TarefaController.java
├── Model/Tarefa.java
├── Repository/TarefaRepository.java
```

## Configuração

### Banco de dados (application.properties)
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projeto_api
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

### Criar banco
```sql
CREATE DATABASE projeto_api;
```

## Como usar

A API roda na porta 8080. Aqui estão os endpoints disponíveis:

**Listar tarefas**
```
GET http://localhost:8080/tarefas
```

**Buscar tarefa específica**
```
GET http://localhost:8080/tarefas/1
```

**Criar tarefa**
```
POST http://localhost:8080/tarefas
Content-Type: application/json

{
    "nome": "Minha tarefa",
    "dataEntrega": "2025-09-15",
    "responsavel": "João"
}
```

**Atualizar tarefa**
```
PUT http://localhost:8080/tarefas/1
Content-Type: application/json

{
    "nome": "Tarefa atualizada",
    "dataEntrega": "2025-09-20",
    "responsavel": "Maria"
}
```

**Excluir tarefa**
```
DELETE http://localhost:8080/tarefas/1
```

## Executar

```bash
./mvnw spring-boot:run
```

## Testei com

- Postman para testar os endpoints
- MySQL Workbench para verificar os dados

## Aprendizados

Durante este projeto aprendi sobre:
- Configuração do Spring Boot
- Mapeamento JPA com anotações
- Criação de APIs REST
- Integração com banco MySQL
- Padrão Repository


