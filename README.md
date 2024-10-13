# Parking Meter API

## Descrição

Esta API gerencia vagas de estacionamento e tickets para veículos. Foi construída usando Spring Boot 3, com OpenAPI para
a documentação da API e MapStruct para o mapeamento de objetos.

## Tecnologias Utilizadas:

- **Spring Boot 3.3.4**: Framework para o desenvolvimento da aplicação.
- **Java 21**: Linguagem de programação utilizada.
- **MapStruct 1.6.2**: Utilizado para o mapeamento de objetos (DTOs e entidades).
- **OpenAPI**: Para a documentação e geração automática de código.
- **H2 Database**: Banco de dados em memória para testes e desenvolvimento.
- **Lombok**: Para reduzir o código boilerplate (getters, setters, construtores).

## Pré-requisitos

- **JDK 21** ou superior.
- **Maven**: Para o gerenciamento de dependências e build.

## Instalação

1. **Clonar o Repositório:**

```bash
  git clone https://github.com/seu-usuario/parking-meter-api.git
  cd parking-meter-api
```

### 🚀 Opções de Build e Execução

Abaixo segue duas opções de build e execução da aplicação: Dockerfile e com o Maven.

ponível em http://localhost:8080.

## Build com Docker
Para construir a aplicação utilizando o Docker, execute o seguinte comando no diretório do projeto:

```bash
  docker build -t parking-meter-app .
```
Após a construção da imagem, você pode executar a aplicação com o comando:

```bash
  docker run -p 8080:8080 parking-meter-app
```



## Gerando os Recursos com o OpenAPI Generator

O OpenAPI Generator é uma ferramenta fundamental que automatiza a geração de código com base na 
especificação OpenAPI. Alguns dos principais benefícios incluem:

- Redução de Erros: O código gerado segue rigorosamente o contrato definido pela especificação 
OpenAPI.
- Aceleração do Desenvolvimento: Não há necessidade de escrever manualmente os 
controladores e modelos da API.
- Facilidade de Manutenção: Qualquer alteração na especificação OpenAPI é rapidamente 
   refletida no código com uma simples geração dos recursos.

2. Gerar os Controladores e Modelos:

Para gerar automaticamente as classes necessárias, execute o seguinte comando Maven:

``` bash
  mvn clean generate-sources 
```
Isso criará os controladores, modelos e outros recursos com base na especificação openapi.yaml
localizada em src/main/resources/.


## Executando a Aplicação

3. Compilar o Projeto:
Após gerar os recursos, compile o projeto:

``` bash
   mvn clean install
```

4. Executar a Aplicação:
Em seguida, execute a aplicação:

``` bash
   mvn spring-boot:run
```
A aplicação estará disponível em http://localhost:8080.

## Endpoints

### Vagas 
**GET** _/parking_spots_: Retorna todas as vagas de estacionamento.
- **Resposta**: 
  - **200 OK**: Lista de vagas de estacionamento.

**POST** _/parking_spots_: Cria uma nova vaga de estacionamento.
- **Parâmetros**:
  - **Body**: Objeto `ParkingSpotRequest`.
- **Resposta**:
  - **201 Created**: Vaga de estacionamento criada com sucesso.
  - **400 Bad Request**: Requisição inválida.

**GET** _/parking_spots/{id}_: Retorna uma vaga de estacionamento pelo ID.
- **Parâmetros**:
  - **Path**: `id` (integer, obrigatório)
- **Resposta**:
  - **200 OK**: Objeto `ParkingSpotResponse`.
  - **404 Not Found**: Vaga de estacionamento não encontrada.

**PUT** _/parking_spots/{id}_: Atualiza os dados de uma vaga de estacionamento.
- **Parâmetros**:
  - **Path**: `id` (integer, obrigatório)
  - **Body**: Objeto `ParkingSpotRequest`.
- **Resposta**:
  - **200 OK**: Vaga de estacionamento atualizada com sucesso.
  - **400 Bad Request**: Requisição inválida.
  - **404 Not Found**: Vaga de estacionamento não encontrada.

**DELETE** _/parking_spots/{id}_: Remove uma vaga de estacionamento.
- **Parâmetros**:
  - **Path**: `id` (integer, obrigatório)
- **Resposta**:
  - **204 No Content**: Vaga de estacionamento removida com sucesso.
  - **404 Not Found**: Vaga de estacionamento não encontrada.

### Tickets

**POST** _/tickets_: Cria um novo ticket de estacionamento.
- **Parâmetros**:
  - **Body**: Objeto `TicketRequest`.
- **Resposta**:
  - **201 Created**: Ticket criado com sucesso.
  - **400 Bad Request**: Requisição inválida.
  - **500 Internal Server Error**: Erro interno do servidor.
  
## Documentação OpenAPI
A documentação da API pode ser acessada em:

```bash
  http://localhost:8080/swagger-ui/index.html
```