
# Backend Teste Solution TI

Api desenvolvida para etapa de teste do processo seletivo da empresa Solution TI.

O backend esta rodando no servidor gratuito do Render e a documentação pode ser acessada aqui -> [https://teste-solutionti-backend.onrender.com/swagger-ui/index.html](https://teste-solutionti-backend.onrender.com/swagger-ui/index.html)


## Stack utilizada

**Back-end:** JAVA 17, Spring Boot 3.5.4, Maven, PostgreSQL, Docker

## Modelagem Simples desenvolvida

<img width="800" height="1143" alt="Modelagem da Aplicação do Teste Prático - Solution TI" src="https://github.com/user-attachments/assets/4284d64b-e1f4-49bc-914c-f6e98364d838" />

## Instalação

Crie uma imagem Docker do PostegreSQL para conexão com banco de dados
```bash
  docker run -d --name postgres-solution-ti -e POSTGRES_DB=solutionti -e POSTGRES_USER=root -e POSTGRES
_PASSWORD=<Escolha sua senha> -p 5432:5432 postgres
```


## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/GGabrielToyo/teste-solutionti-backend
```

Entre no diretório do projeto

Abra sua IDE de preferência e inicie o projeto.


## Variáveis de ambiente
Abra [application.properties](https://github.com/GGabrielToyo/teste-solutionti-backend/blob/main/src/main/resources/application.properties) para configurar as variáveis de ambiente.

- DB_URL -> jdbc:postgresql://localhost:5432/solutionti
- DB_USER -> root
- DB_PASSWORD - > A senha do banco que foi criado

## Documentação

Está sendo utilizado para documentação o Swagger. Após rodar o projeto, 

acesse o link abaixo para visualizar a documentação da api.

- [Swagger](https://localhost:8080/swagger-ui.html)


## Autores

- [Gabriel Toyo](https://github.com/GGabrielToyo)


## Observações

Caso queira realizar modificações ou testes, crie uma branch separada.

```bash
  git checkout -b <nome da nova branch>
```

