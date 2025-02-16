
# Agendador de notificações

Esse projeto foi desenvolvido para um desafio técnico visando apresentar habilidades de desenvolvimento backend em java. Tem como escopo o cadastro de notificações para posterior envio.

## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/FellipeCavalcante/agendamento-notificacao-spring-api.git
```

Entre no diretório do projeto

```bash
  docker-compose --build
```



## Documentação da API

#### Cadastra notficações pendentes

```http
  POST /agendamento
```

| body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeDestinatario` | `string` | **Obrigatório**. Email do destinatário da notficação |
| `telefoneDestinatario` | `string` | **Obrigatório**. Telefone do destinatário da notficação |
| `mensagem` | `string` | **Obrigatório**. Mensagem de notficação |
| `dataHoraEnvio` | `LocalDateTime` | **Obrigatório**. Data e hora do evento no formato dd-MM-yyyy HH-mm-ss |


#### Retorna uma notficação por id

```http
  GET /agendamento/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer buscar |

#### Cancela uma notficação por id

```http
  DELETE /agendamento/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer cancelar|


## Rodando os testes

#### Para rodar os testes

```bash
  mvn test
```
