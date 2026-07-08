# To-do List

API REST para gerenciamento de tarefas (to-do list), construída com Spring Boot e MySQL.

## Tecnologias

- Java 17
- Spring Boot 4.1.0
- Spring Data JPA
- Spring Boot Actuator
- Spring WebSocket
- MySQL 8.0
- Maven

## Pré-requisitos

- JDK 17+
- Docker e Docker Compose (para o banco de dados)

## Como executar

1. Suba o banco de dados MySQL:

   ```bash
   docker compose up -d
   ```

   Isso cria o banco `todolist` com usuário/senha `todolist`/`todolist`, exposto na porta `3306`.

2. Rode a aplicação:

   ```bash
   cd demo
   ./mvnw spring-boot:run
   ```

   A API sobe em `http://localhost:8080`.

As configurações de conexão com o banco estão em [demo/src/main/resources/application.properties](demo/src/main/resources/application.properties).

## Endpoints da API

Base path: `/api/todos`

| Método | Rota              | Descrição                     |
|--------|-------------------|--------------------------------|
| POST   | `/create`         | Cria uma nova tarefa           |
| GET    | `/read`           | Lista todas as tarefas         |
| POST   | `/update`         | Atualiza uma tarefa existente  |
| DELETE | `/delete/{id}`    | Remove uma tarefa pelo ID      |

Todas as rotas retornam a lista atualizada de tarefas, ordenada por prioridade (decrescente) e nome (crescente).

### Modelo `Todo`

```json
{
  "id": 1,
  "name": "Estudar Spring Boot",
  "description": "Revisar conceitos de JPA",
  "completed": false,
  "priority": 1
}
```

## Estrutura do projeto

```
demo/src/main/java/todolist/demo/
├── DemoApplication.java
├── controller/TodoController.java
├── service/TodoService.java
├── repository/TodoRepository.java
└── entity/Todo.java
```
