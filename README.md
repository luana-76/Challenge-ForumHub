# ChallengeForumHub

Um projeto em **Spring Boot** que simula um fórum com funcionalidades de CRUD para **usuários**, **tópicos**, **cursos** e **perfis**. A aplicação também conta com autenticação, organização em camadas e boas práticas de REST API.

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate
- MySql
- Maven
- Git

---

## 📂 Funcionalidades

### ✅ Usuários
- Criar, listar, atualizar e deletar usuários.
- Atribuir perfis (como `USER`, `ADMIN` etc).
- Protegido por autenticação (dependendo da configuração de segurança).

### ✅ Tópicos
- Criar tópicos relacionados a cursos.
- Listar todos os tópicos ou buscar por ID.
- Atualizar e deletar tópicos.

### ✅ Cursos
- Cadastrar cursos disponíveis para associação aos tópicos.

### ✅ Perfis
- CRUD simples para controle de papéis de usuário.

---

## 🔐 Segurança

A segurança da aplicação está **em desenvolvimento**.

Atualmente, os endpoints estão com acesso liberado via `permitAll()` nas configurações de segurança, mas a aplicação já está preparada para futura integração com autenticação e controle de acesso por perfis de usuário.

A configuração atual pode ser encontrada em:

```java
Infra/Security/Configurations.java
