# Cadastro Ninja

## Descrição 
Uma simples api feita com java e springboot usando exemplos de naruto para facilitar a apreendizagem
As tecnologias escolhidas para a implementação são:

   ## Visão Geral do Projeto

Este sistema foi desenvolvido para gerenciar ninjas e suas missões. Cada ninja pode ser atribuído a uma única missão, enquanto uma missão pode ser associada a vários ninjas. As principais funcionalidades incluem:

    Cadastro de ninjas com nome, idade, email e rank.
    Atribuição de uma missão para um ninja.
    Gerenciamento de missões e dos ninjas associados a elas.

## Tecnologias Utilizadas

    Spring Boot: Para criação da aplicação web e gerenciamento de dependências.
    Banco de Dados H2: Banco de dados em memória para desenvolvimento e testes.
    Flyway: Para gerenciamento de migrações do banco de dados.
    JPA (Java Persistence API): Para mapeamento objeto-relacional (ORM).
    Git: Controle de versão para gerenciamento de mudanças no código.
    GitHub: Hospedagem do repositório para controle de versão.
    Spring Data JPA: Para interação com o banco de dados.
    Maven: Para build e gerenciamento de dependências do projeto.
    Docker: Para build externo do banco de dados
    SQL: Manipulação do banco de dados

## Design do Banco de Dados

O esquema do banco de dados segue as seguintes relações:

    Ninja: Contém atributos como id, nome, idade, email e rank.
    Missão: Contém atributos como id, título e descrição.
    Um Ninja pode ter apenas uma Missão, mas uma Missão pode ser atribuída a vários Ninjas.

## Endpoints
   / Listar + id
   vai listar o ninja por id
   /listar
   vai mostrar todos ninjas
   /alterarid 
   altera o ninja por id
   /apagar + id
   apaga o ninja selecionado
   /deletarTudo
   deleta todos o dados
   /atualizar + id
   atualiza o ninja selecionado
