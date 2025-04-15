# 📸 Memelândia - Microservices Edition

O **Memelândia** é um projeto originalmente desenvolvido como uma aplicação monolítica para o gerenciamento de memes, categorias e usuários. Visando maior escalabilidade, facilidade de manutenção e modularidade, o sistema foi **refatorado** para adotar uma arquitetura baseada em **microserviços**.

---

## 🧩 Arquitetura

A nova arquitetura é composta por **três serviços independentes**, cada um responsável por uma parte específica da lógica de negócios:

- **Serviço de Usuários**  
  Gerencia o cadastro, autenticação e informações dos usuários.

- **Serviço de Categorias**  
  Responsável pela criação, listagem e organização de categorias de memes.

- **Serviço de Memes**  
  Gerencia o envio, listagem e associação de memes às categorias e usuários.

Cada serviço possui seu **banco de dados H2** isolado e é executado em uma **porta distinta**, seguindo os princípios da separação de responsabilidades.

---

## 🔀 Comunicação entre Serviços

A comunicação entre os microserviços ocorre por meio de **API REST**, com endpoints bem definidos para cada funcionalidade. Para facilitar a integração e aumentar a segurança e desempenho, é utilizado um **API Gateway** que:

- Centraliza as requisições HTTP;
- Faz o roteamento para o serviço correspondente;
- Possibilita a implementação futura de autenticação, logging e rate limiting.

---

## 🚀 Tecnologias Utilizadas

- **Java + Spring Boot**
- **Banco de Dados H2** (em memória, para testes e desenvolvimento)
- **REST APIs**
- **Arquitetura de Microserviços**
- **API Gateway (Spring Cloud Gateway)**

---

## 🛠️ Como Executar

> ⚠️ Certifique-se de que você possui o **Java 17+** e **Maven** instalados.

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/memelandia.git
   cd memelandia
   ```

2. Execute cada serviço individualmente (via Maven ou IDE):
   ```bash
   cd usuarios-service
   mvn spring-boot:run

   cd categorias-service
   mvn spring-boot:run

   cd memes-service
   mvn spring-boot:run

   cd api-gateway
   mvn spring-boot:run
   ```

3. Acesse a aplicação via Gateway (ex: `http://localhost:8080/usuarios`, `.../categorias`, `.../memes`)

---

## 📚 Futuras Melhorias

- Integração com banco de dados PostgreSQL
- Autenticação JWT
- Front-end com React/Vue
- Containerização com Docker e orquestração com Kubernetes
- Monitoramento com Spring Boot Admin ou Prometheus + Grafana

---

## 👨‍💻 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir *issues*, propor melhorias ou enviar *pull requests*.

---

## 📄 Licença

Este projeto está sob a licença [MIT](LICENSE).
