# API RESTful - E-commerce Pet Shop

**Desenvolvedor:** Felipe Araújo Lemos  
**Instituição:** Centro Universitário Alves Faria (UNIALFA)  
**Curso:** Análise e Desenvolvimento de Sistemas / Engenharia de Software (3º Período)  
**Disciplina:** Programação Web / Desenvolvimento Back-end  

---

## 📖 Descrição do Projeto

Este projeto consiste no desenvolvimento de uma API RESTful para um e-commerce voltado ao segmento pet. A solução foi idealizada para atender a necessidade de um proprietário de pet shop que busca migrar suas vendas online para uma plataforma própria, eliminando as taxas cobradas por plataformas de terceiros.

A API foi construída com foco na robustez, escalabilidade e boas práticas de Engenharia de Software, servindo como o "motor" (Back-end) que conecta o banco de dados a qualquer aplicação Front-end futura (Web ou Mobile).

## 🚀 Tecnologias e Ferramentas Utilizadas

A arquitetura do projeto foi desenvolvida utilizando o ecossistema Spring, garantindo agilidade e segurança:

* **Java 21:** Linguagem de programação principal.
* **Spring Boot (v4.0.6):** Framework para estruturação rápida da aplicação.
* **Spring Web:** Criação dos endpoints RESTful e servidor Tomcat embutido.
* **Spring Data JPA & Hibernate:** Mapeamento Objeto-Relacional (ORM) e persistência de dados.
* **Validation:** Validação de dados de entrada (Bean Validation).
* **MySQL:** Sistema de Gerenciamento de Banco de Dados Relacional (SGBD).
* **Maven:** Gerenciamento de dependências e build do projeto.
* **Lombok:** Otimização de código (geração automática de Getters, Setters e Construtores).
* **Swagger / OpenAPI:** Documentação interativa e automatizada da API.

---

## 🏗️ Arquitetura e Modelagem de Dados

O domínio da aplicação foi estruturado para refletir o cenário real de vendas do pet shop, contendo as seguintes entidades e relacionamentos:

1. **Categoria:** Agrupa os produtos (ex: Rações, Brinquedos, Medicamentos).
2. **Produto:** Mantém os detalhes do item, preço e controle de estoque. Relaciona-se com Categoria (N:1).
3. **Cliente:** Armazena os dados dos compradores, com validação de formato de e-mail e preenchimento obrigatório.
4. **Pedido:** Registra a transação de venda, vinculada a um Cliente (N:1) e contendo múltiplos itens.
5. **ItemPedido:** Tabela intermediária que relaciona o Produto ao Pedido (N:M), guardando a quantidade comprada e o preço unitário no momento da venda (histórico de preço).

### ⚙️ Regras de Negócio Implementadas
A camada de serviço (`PedidoService`) concentra as regras fundamentais do e-commerce:
* **Validação de Estoque:** Impede a criação de um pedido caso a quantidade solicitada seja maior que o estoque disponível.
* **Baixa de Estoque:** Deduz automaticamente a quantidade comprada do estoque do produto após a confirmação do pedido.
* **Cálculo de Total:** O sistema calcula automaticamente o subtotal de cada item e o valor total do pedido.

---

## 💻 Como Executar o Projeto Localmente

Siga os passos abaixo para compilar e testar a API em sua máquina:

### 1. Pré-requisitos
* Java Development Kit (JDK) 21 instalado.
* MySQL Server rodando na porta padrão (3306).
* IDE (IntelliJ IDEA, Eclipse, etc.) ou Maven configurado no terminal.

### 2. Configuração do Banco de Dados
Não é necessário criar as tabelas manualmente, o Spring Boot fará isso automaticamente. Você precisa apenas criar o banco de dados executando o comando abaixo no seu cliente MySQL (Workbench, DBeaver, etc.):

```sql
CREATE DATABASE petshop_db;
