# Projeto de Gerenciamento de Agendamentos de Comunicação

Este é um projeto simples para gerenciar agendamentos de comunicação (e-mail, SMS, push notification) usando Spring Boot. Ele permite agendar, consultar e cancelar comunicações.

## Tecnologias Utilizadas
-   Java 21
-   Spring Boot 3.5.4
-   Spring Data JPA
-   H2 Database (banco de dados em memória)
-   Maven
-   Lombok

## Como Executar o Projeto
Para rodar este projeto, você precisa ter o JDK 21 e o Maven instalados.

1.  **Clone o repositório:**
    `git clone https://github.com/LucianoMacedoSantos/magalu.git`
2.  **Navegue até o diretório do projeto:**
    `cd magalu`
3.  **Execute o projeto usando o Maven:**
    `./mvnw spring-boot:run`

A aplicação será iniciada na porta 1208.

## Endpoints da API

A API está disponível em `http://localhost:1208/api/comunicacoes`.

### 1. Agendar uma Comunicação
-   **Método:** `POST`
-   **URL:** `/api/comunicacoes`
-   **Headers:** `Content-Type: application/json`
-   **Corpo da Requisição (JSON):**
    ```json
    {
      "dataHoraEnvio": "2025-08-13T10:00:00",
      "destinatario": "luciano.santos@email.com",
      "mensagem": "Lembrete: sua consulta foi agendada para amanhã.",
      "tipoComunicacao": "email"
    }
    ```
-   **Resposta (Exemplo 200 OK):**
    ```json
    {
      "id": 1,
      "dataHoraEnvio": "2025-08-13T10:00:00",
      "destinatario": "luciano.santos@email.com",
      "mensagem": "Lembrete: sua consulta foi agendada para amanhã.",
      "tipoComunicacao": "email",
      "status": "agendado"
    }
    ```

### 2. Consultar uma Comunicação
-   **Método:** `GET`
-   **URL:** `/api/comunicacoes/{id}`
-   **Exemplo:** `/api/comunicacoes/1`
-   **Resposta (Exemplo 200 OK):**
    ```json
    {
      "id": 1,
      "dataHoraEnvio": "2025-08-13T10:00:00",
      "destinatario": "luciano.santos@email.com",
      "mensagem": "Lembrete: sua consulta foi agendada para amanhã.",
      "tipoComunicacao": "email",
      "status": "agendado"
    }
    ```

### 3. Cancelar uma Comunicação
-   **Método:** `DELETE`
-   **URL:** `/api/comunicacoes/{id}`
-   **Exemplo:** `/api/comunicacoes/1`
-   **Resposta:** `204 No Content` (se a comunicação for encontrada e cancelada) ou `404 Not Found` (se a comunicação não existir).

Após criar o arquivo, salve-o. Depois, faça um commit e um push para o GitHub para que a documentação seja incluída no seu repositório.

Me informe quando o arquivo estiver no seu repositório.
