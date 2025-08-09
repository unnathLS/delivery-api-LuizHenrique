# Delivery API

Uma API RESTful para gerenciar pedidos, clientes, restaurantes e produtos em uma plataforma de delivery. Este projeto foi desenvolvido como parte de um programa de estudos em Spring Boot, seguindo uma arquitetura de camadas bem definida.

---

### **Tecnologias Utilizadas**

- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **Maven**
- **H2 Database** (para desenvolvimento e testes em memória)
- **Lombok** (para simplificar o código das entidades)

---

### **Pré-requisitos**

Para rodar a aplicação, você precisa ter instalado:

- Java Development Kit (JDK) 21 ou superior
- Apache Maven

---

### **Como Executar**

1. **Clone o repositório:**
    
    ```bash
    git clone https://github.com/unnathLS/delivery-api-LuizHenrique.git
    
    ```
    
2. **Navegue até o diretório do projeto:**
    
    ```bash
    cd delivery-api-LuizHenrique
    
    ```
    
3. **Inicie a aplicação:**
A aplicação será iniciada na porta `8080`.
    
    ```bash
    ./mvnw spring-boot:run
    
    ```
    

---

### **Endpoints da API**

Todos os endpoints estão disponíveis na URL base `http://localhost:8080`.

### **Clientes (`/clientes`)**

| Método | Endpoint | Descrição | Exemplo de Body |
| --- | --- | --- | --- |
| **POST** | `/clientes` | Cadastra um novo cliente | `{ "nome": "Ana Souza", "email": "ana.souza@email.com", "senha": "ana123" }` |
| **GET** | `/clientes` | Lista todos os clientes | N/A |
| **GET** | `/clientes/{id}` | Busca um cliente pelo ID | N/A |
| **PUT** | `/clientes/{id}` | Atualiza um cliente pelo ID | `{ "nome": "Ana Souza Santos", "email": "ana.s.santos@email.com" }` |
| **PATCH** | `/clientes/{id}/inativar` | Inativa um cliente | N/A |
| **PATCH** | `/clientes/{id}/ativar` | Ativa um cliente | N/A |

### **Restaurantes (`/restaurantes`)**

| Método | Endpoint | Descrição | Exemplo de Body |
| --- | --- | --- | --- |
| **POST** | `/restaurantes` | Cadastra um novo restaurante | `{ "nome": "Pizzaria do Bairro", "categoria": "Pizza" }` |
| **GET** | `/restaurantes` | Lista todos os restaurantes | N/A |
| **GET** | `/restaurantes/{id}` | Busca um restaurante pelo ID | N/A |
| **PUT** | `/restaurantes/{id}` | Atualiza um restaurante pelo ID | `{ "nome": "Pizzaria do Bairro", "categoria": "Italiana" }` |
| **PATCH** | `/restaurantes/{id}/inativar` | Inativa um restaurante | N/A |
| **PATCH** | `/restaurantes/{id}/ativar` | Ativa um restaurante | N/A |

### **Produtos (`/produtos`)**

| Método | Endpoint | Descrição | Exemplo de Body |
| --- | --- | --- | --- |
| **POST** | `/produtos` | Cadastra um novo produto | `{ "nome": "Pizza Margherita", "descricao": "Queijo, tomate e manjericão", "preco": 45.00, "restaurante": { "id": 1 } }` |
| **GET** | `/produtos` | Lista todos os produtos | N/A |
| **GET** | `/produtos/{id}` | Busca um produto pelo ID | N/A |

### **Pedidos (`/pedidos`)**

| Método | Endpoint | Descrição | Exemplo de Body |
| --- | --- | --- | --- |
| **POST** | `/pedidos` | Cria um novo pedido | `{ "cliente": { "id": 1 }, "restaurante": { "id": 1 }, "produtos": [ { "id": 1 } ] }` |
| **GET** | `/pedidos` | Lista todos os pedidos | N/A |
| **GET** | `/pedidos/{id}` | Busca um pedido pelo ID | N/A |
| **PATCH** | `/pedidos/{id}/status/{novoStatus}` | Altera o status do pedido | N/A |

---

### **Estrutura do Projeto**

O projeto segue a arquitetura de camadas, com responsabilidades bem definidas:

- `controller/`: Gerencia as requisições HTTP e as respostas.
- `service/`: Contém a lógica de negócio da aplicação.
- `repository/`: Responsável pela interação com o banco de dados.
- `entity/`: Representa o modelo de dados e as tabelas do banco.