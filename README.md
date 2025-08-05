# Projeto Arquitetura de Sistemas QualificaSP

# 🎯 Contexto e Problematização
Você foi contratado como desenvolvedor júnior pela startup DeliveryTech, uma nova empresa que quer competir com iFood e Uber Eats. O CTO da empresa te deu a primeira missão:

"Precisamos começar do zero. Temos uma ideia revolucionária para delivery, mas precisamos de uma base sólida.
Sua missão é preparar o ambiente de desenvolvimento e criar a estrutura inicial do nosso sistema.
Lembre-se: grandes projetos começam com fundações bem construídas!"
---

# 🚀 Cenário Real
Imagine que você está no primeiro dia de trabalho em uma startup. O time de produto já definiu que o sistema deve:

⚖️ Ser escalável (começar pequeno, crescer grande)

🛠️ Usar tecnologias modernas e confiáveis (JDK 21 LTS)

🧑‍💻 Ter um ambiente de desenvolvimento padronizado

🤝 Permitir que outros desenvolvedores entrem no projeto facilmente

---


# Delivery Tech API

Sistema de delivery desenvolvido com Spring Boot e Java 21.

## 🚀 Tecnologias
- **Java 21 LTS** (versão mais recente)
- Spring Boot 3.5.4
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## ⚡ Recursos Modernos Utilizados
- Records (Java 14+)
- Text Blocks (Java 15+)
- Pattern Matching (Java 17+)
- Virtual Threads (Java 21)

## 🏃‍♂️ Como executar
1. **Pré-requisitos:** JDK 21 instalado
2. Clone o repositório
3. Execute: `./mvnw spring-boot:run`
4. Acesse: http://localhost:8080/health

## 📋 Endpoints
- GET /health - Status da aplicação (inclui versão Java)
- GET /info - Informações da aplicação
- GET /h2-console - Console do banco H2

## 🔧 Configuração
- Porta: 8080
- Banco: H2 em memória
- Profile: development

## 👨‍💻 Desenvolvedor
[Luiz Henrique] - [STI58 02728]  
Desenvolvido com JDK 21 e Spring Boot 3.5.4