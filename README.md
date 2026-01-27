# 📝Lista de Tarefas – Spring Boot

Aplicação **To‑Do List** desenvolvida com **Spring Boot**, **Thymeleaf** e **MySQL**.

## 🛠️ Tecnologias utilizadas

* **Java 21**
* **Spring Boot 4.0.1**
* Spring MVC
* Spring Data JPA
* Thymeleaf
* Lombok
* MySQL
* Bootstrap 5
* Maven

---

## 📂 Estrutura do projeto

```text
src/main/java/dev/kevin/todo
│
├── TodoApplication.java
└── tarefa
    ├── HomeController.java
    ├── Tarefa.java
    ├── TarefaDTO.java
    ├── TarefaMapper.java
    ├── TarefaRepository.java
    ├── TarefaService.java
    ├── TarefaController.java        # API REST
    └── TarefaUiController.java      # UI (Thymeleaf)

src/main/resources
├── templates
│   ├── listar-tarefas.html
│   ├── criar-tarefa.html
│   ├── editar-tarefa.html
│   └── deletar-tarefa.html
└── application.properties
```

---

## 🧩 Arquitetura

O projeto segue uma separação clara de responsabilidades:

* **Entity** – Representa a tabela no banco de dados
* **DTO** – Objeto de transferência de dados
* **Mapper** – Converte entre Entity e DTO
* **Repository** – Acesso ao banco via JPA
* **Service** – Regras de negócio
* **Controller REST** – API JSON
* **Controller UI** – Interface Web

---

## ⚙️ Configuração do banco de dados

No arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_todo_app
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

📌 Certifique-se de que:

* O MySQL esteja rodando
* O banco `spring_todo_app` exista
* As credenciais estejam corretas

---

## ▶️ Como executar o projeto

### Via Maven Wrapper

```bash
./mvnw spring-boot:run
```

Ou no Windows:

```bash
mvnw.cmd spring-boot:run
```

---

## 🌐 Acessos

### Interface Web (UI)

```
http://localhost:8080/
```

(redirect automático para `/ui/listar`)

### API REST

| Método | Endpoint      | Descrição     |
| ------ | ------------- | ------------- |
| GET    | /listar       | Lista tarefas |
| POST   | /criar        | Cria tarefa   |
| PUT    | /editar/{id}  | Edita tarefa  |
| DELETE | /deletar/{id} | Remove tarefa |

Exemplo de JSON:

```json
{
  "descricao": "Estudar Spring Boot",
  "concluida": false
}
```

