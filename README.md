# Delivery API

Uma API RESTful para gerenciar pedidos, clientes, restaurantes e produtos em uma plataforma de delivery. Desenvolvido com Spring Boot seguindo Clean Architecture.

---

### **Tecnologias Utilizadas**

- **Java 21+**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **Maven**
- **H2 Database** (dev/testes)
- **Lombok** (reduz código repetitivo)

---

### **Pré-requisitos**

- JDK 21 ou superior
- Apache Maven

---

### **Como Executar**

1. Clone o repositório:
   ```bash
   git clone https://github.com/unnathLS/delivery-api-LuizHenrique.git
   ```
2. Navegue até o diretório:
   ```bash
   cd delivery-api-LuizHenrique
   ```
3. Inicie a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

---

### **Endpoints da API**

Base URL: `http://localhost:8080`

#### **Health Check**

| Método | Endpoint  | Descrição                    |
| ------ | --------- | ---------------------------- |
| GET    | `/health` | Status e informações básicas |
| GET    | `/info`   | Informações da aplicação     |

#### **Clientes (`/clientes`)**

| Método | Endpoint                   | Descrição                         |
| ------ | -------------------------- | --------------------------------- |
| POST   | `/clientes`                | Cadastra um novo cliente.         |
| GET    | `/clientes`                | Lista todos os clientes.          |
| GET    | `/clientes/{id}`           | Busca um cliente pelo seu ID.     |
| GET    | `/clientes/email/{email}`  | Busca um cliente pelo seu e-mail. |
| GET    | `/clientes/ativos`         | Lista todos os clientes ativos.   |
| PUT    | `/clientes/atualizar/{id}` | Atualiza os dados de um cliente.  |
| PATCH  | `/clientes/status/{id}`    | Ativa ou desativa um cliente.     |

#### **Restaurantes (`/restaurantes`)**

| Método | Endpoint                       | Descrição                   |
| ------ | ------------------------------ | --------------------------- |
| POST   | `/restaurantes`                | Cadastra restaurante        |
| GET    | `/restaurantes/todos`          | Lista todos os restaurantes |
| GET    | `/restaurantes/ativos`         | Lista restaurantes ativos   |
| PATCH  | `/restaurantes/ativar/{id}`    | Ativa restaurante           |
| PATCH  | `/restaurantes/desativar/{id}` | Desativa restaurante        |

#### **Produtos (`/produtos`)**

| Método | Endpoint                                      | Descrição                                |
| ------ | --------------------------------------------- | ---------------------------------------- |
| POST   | `/produtos/cadastrar-produto/{restauranteId}` | Cadastra produto vinculado a restaurante |
| GET    | `/produtos/todos`                             | Lista todos os produtos                  |

#### **Pedidos (`/pedidos`)**

| Método | Endpoint                  | Descrição                |
| ------ | ------------------------- | ------------------------ |
| POST   | `/pedidos`                | Cria novo pedido         |
| GET    | `/pedidos/{id}`           | Lista pedidos            |
| PUT    | `/pedidos/{id}/confirmar` | Confirma pedido          |
| PUT    | `/pedidos/{id}/preparo`   | Inicia preparo do pedido |
| PUT    | `/pedidos/{id}/enviar`    | Envia pedido             |
| PUT    | `/pedidos/{id}/entregar`  | Entrega pedido           |
| PUT    | `/pedidos/{id}/cancelar`  | Cancela pedido           |

---

### **Estrutura do Projeto**

- `controller/`: Requisições HTTP e respostas
- `service/`: Lógica de negócio
- `repository/`: Interação com banco de dados
- `entity/`: Modelos/tabelas

---

### **Novidades**

- Endpoints de health check (`/health` e `/info`)
- Listagem e ativação/inativação de clientes e restaurantes
- Cadastro de produtos vinculado ao restaurante
- Fluxo completo de status do pedido (confirmar, preparo, enviar, entregar, cancelar)

---
