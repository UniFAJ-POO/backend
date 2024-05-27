## Descrição
Este projeto é uma aplicação back-end desenvolvida com Spring Boot. Ele utiliza Spring Data JPA para realizar operações de banco de dados de forma eficiente e simplificada. O projeto inclui várias entidades representando diferentes partes do sistema, como mesas, clientes, produtos, pedidos, itens de pedido e login de funcionários.

## Usando o Swagger
A documentação da API pode ser acessada através dos seguintes endpoints:

- Documentação em JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
- Interface do Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Executando a Aplicação
A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

## Configuração do Banco de Dados
Certifique-se de configurar o banco de dados no arquivo `application.properties` ou `application.yml`. Aqui está um exemplo de configuração para um banco de dados H2 em memória:

```properties
# Configurações do Datasource
spring.datasource.url=jdbc:h2:mem:restaurante
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=root
spring.datasource.password=root

# Configurações do H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configurações do JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Entidades e Repositórios
### Entidades
As entidades representam os objetos principais do sistema. Aqui estão as principais entidades e seus atributos:

### 1. Mesa
A entidade `Mesa` representa uma mesa no restaurante.

- `numMesa`: Identificador único da mesa.
- `qtdCadeira`: Quantidade de cadeiras na mesa.
- `statusMesa`: Status da mesa (disponível ou ocupada).

### 2. Cliente
A entidade `Cliente` representa um cliente do restaurante.

- `idCliente`: Identificador único do cliente.
- `nomeCliente`: Nome do cliente.
- `cpfCliente`: CPF do cliente (deve ser único).

### 3. Produto
A entidade `Produto` representa um produto disponível no restaurante.

- `idProduto`: Identificador único do produto.
- `nomeProduto`: Nome do produto.
- `valorProduto`: Valor do produto.
- `qtdProduto`: Quantidade disponível do produto.

### 4. Pedido
A entidade `Pedido` representa um pedido feito por um cliente.

- `idPedido`: Identificador único do pedido.
- `totalPedido`: Valor total do pedido.
- `statusPago`: Status de pagamento do pedido.
- `dataPedido`: Data do pedido.
- `mesa`: Mesa associada ao pedido.
- `cliente`: Cliente que fez o pedido.

### 5. Login
A entidade `Login` representa as credenciais de login de um funcionário.

- `idFuncionario`: Identificador único do funcionário.
- `username`: Nome de usuário do login (deve ser único).
- `senha`: Senha do login.

### 6. ItensPedido
A entidade `ItensPedido` representa os itens individuais em um pedido.

- `idPedido`: Identificador do pedido (chave composta).
- `produto`: Produto associado ao item do pedido (chave composta).
- `quantidadePedido`: Quantidade do produto no pedido.
- `valorTotal`: Valor total do item no pedido.

### Repositórios
Os repositórios são interfaces que fornecem métodos para acessar e manipular dados no banco de dados. Eles estendem as interfaces fornecidas pelo Spring Data JPA e podem incluir métodos personalizados para consultas específicas.