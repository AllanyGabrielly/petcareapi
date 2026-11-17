
# PetCare

API REST para gerenciamento de um pet shop, desenvolvida com Java e Spring Boot.

## Sobre o projeto

O **PetCare** é um sistema backend desenvolvido como projeto acadêmico, com o objetivo de organizar e facilitar o gerenciamento de clientes, animais de estimação, serviços, agendamentos e planos.

O projeto aplica conceitos de desenvolvimento de APIs REST, arquitetura em camadas e persistência de dados utilizando JPA e Hibernate.

## Funcionalidades

- **Clientes:** cadastro e organização dos dados dos clientes.
- **Pets:** cadastro dos animais de estimação vinculados aos seus respectivos donos.
- **Serviços:** gerenciamento dos serviços oferecidos pelo pet shop.
- **Agendamentos:** organização dos agendamentos de serviços para os pets.
- **Planos:** gerenciamento dos planos disponíveis e sua relação com os serviços.

## Tecnologias utilizadas

- Java 17
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- Hibernate
- Banco de dados H2
- Maven

## Estrutura do projeto

```text
src/
└── main/
    ├── java/
    │   └── com/petcare/api/
    │       ├── controllers/
    │       ├── services/
    │       ├── repositories/
    │       ├── entities/
    │       └── PetcareapiApplication.java
    │
    └── resources/
        └── application.properties
```

## Arquitetura

O projeto utiliza arquitetura em camadas:

- **Controllers:** recebem e respondem às requisições HTTP.
- **Services:** concentram as regras de negócio.
- **Repositories:** realizam o acesso e a persistência dos dados.
- **Entities:** representam as entidades e seus relacionamentos no banco de dados.

## Banco de dados

O projeto utiliza o banco de dados H2 em memória, integrado ao Spring Data JPA e ao Hibernate.

O Hibernate é responsável pela criação e atualização das tabelas conforme o mapeamento das entidades.

### Acesso ao console H2

Com a aplicação em execução, o console pode ser acessado pelo endereço:

http://localhost:8080/h2-console

## Como executar o projeto

### Pré-requisitos

- Java JDK 17 ou superior.
- Git.
- Maven Wrapper incluído no projeto.

### 1. Clonar o repositório

```bash
git clone https://github.com/AllanyGabrielly/petcareapi.git
```

### 2. Entrar na pasta do projeto

```bash
cd petcareapi
```

### 3. Executar a aplicação

No Windows, utilize:

```powershell
.\mvnw.cmd spring-boot:run
```

Após a inicialização, a aplicação estará disponível em:

http://localhost:8080

## Relacionamentos entre entidades

- Um cliente pode possuir vários pets.
- Um pet pode possuir vários agendamentos.
- Um plano pode estar associado a vários serviços.
- Um serviço pode estar presente em vários agendamentos.

## Status do projeto

Em desenvolvimento.

---

Desenvolvido como projeto acadêmico utilizando Java e Spring Boot.
