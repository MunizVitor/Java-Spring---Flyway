# Java-Spring---Flyway
# PROJETO DE ESTUDO DE Java Spring + Flyway + PostgreSQL

## Sobre o projeto

Este projeto é uma aplicação desenvolvida em Spring Boot com integração ao PostgreSQL, criada para demostrar a utilização do pacote de dependências FLYWAY (https://www.baeldung.com/database-migrations-with-flyway). Meu projeto é centrado em uma API que permite cadastrar, editar e excluir registros de produtos.

Nos endpoints GET, temos duas opções:

*   Retornar todos os produtos com id, nomeProduto, ean, descricaoProduto, categoriaProduto, precoCusto, precoProduto.
*   Retornar o produto específico tem 4 formas sendo elas EAN, CATEGORIAPRODUTO, DESCRICAOPRODUTO, NOMEPRODUTO URL.

No endpoint POST, a opção é:

*   Mandar nomeProduto, ean, descricaoProduto, categoriaProduto, precoCusto, precoProduto.

## 🛠 Tecnologias utilizadas

*   Java 21
*   Spring Boot
*   Spring Data JPA
*   Spring Flyway
*   H2 Database in memories
*   PostgreSQL
*   Maven
*   Postman

## 🧩 Explicação do código

A classe `ProductModel` possui os seguintes atributos:

*   `id` (UUID)
*   `nomeProduto` (String)
*   `descricaoProduto` (String)
*   `categoriaProduto` (String)
*   `ean` (String)
*   `precoCusto` (BigDecimal)
*   `precoProduto` (BigDecimal)

## 🗄 Banco de Dados / DER
![alt text](image.png)
(Diagrama omitido - refer to original PDF)

## ⚙ Configuração do ambiente

1.  Instale o Java (oracle.com in Bing).
2.  Instale o Maven.
3.  Instale e configure o PostgreSQL.
4.  Crie um banco de dados.
![alt text](image-1.png)
## 🔧 Configuração da aplicação

No arquivo `application.properties`:
![alt text](image-2.png)
(Configurações omitidas - refer to original PDF)

## ▶ Como rodar

1.  Clone o repositório:
![alt text](image-3.png)
2.  Entre na pasta do projeto:
![alt text](image-4.png)
3.  Rode a aplicação:
![alt text](image-5.png)

## 📌 Endpoints principais

*   `GET /alunos` → lista todos os alunos
![alt text](image-6.png)
*   `POST /alunos` → cadastra um novo aluno
![alt text](image-7.png)
*   `DELETE /alunos` → delete lógico de um aluno
![alt text](image-8.png)

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [Parece que o resultado não era seguro para exibição. Vamos mudar as coisas e tentar outra opção!] para mais detalhes.
