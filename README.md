#  Cadastro de Ninjas & Missões

Sistema Full Stack desenvolvido para gerenciar o recrutamento de ninjas e a atribuição de missões de alto nível.

##  Tecnologias Utilizadas
* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência de dados)
* **Thymeleaf** (Motor de template para a UI)
* **Bootstrap 5** (Estilização)
* **Lombok** (Produtividade no código)
* **H2/MySQL** (Banco de dados)

##  Padrões de Projeto (Design Patterns)
Este projeto não é apenas um CRUD. Ele implementa padrões de mercado como:
- **DTO (Data Transfer Object):** Para tráfego de dados seguro entre camadas.
- **Mappers:** Classes dedicadas para conversão de Entidades em DTOs, mantendo o Service limpo.
- **Relacionamentos JPA:** Gerenciamento de relações `@OneToMany` entre Missões e Ninjas.
- **RESTful API:** Endpoints padronizados com os verbos HTTP corretos e códigos de status (`201 Created`, `404 Not Found`, etc).

##  Interface
A interface foi construída com Thymeleaf e permite:
- Listagem de ninjas com seus respectivos ranks e fotos.
- Visualização condicional de missões (mostra "Sem Missão" caso o ninja esteja disponível).
- Design responsivo via Bootstrap.

##  Como rodar o projeto
1. Clone o repositório.
2. Certifique-se de ter o Maven instalado.
3. Execute `./mvnw spring-boot:run`.
4. Acesse `http://localhost:8080/ui/listar`.
