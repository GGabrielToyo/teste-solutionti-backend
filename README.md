
# Backend Teste Solution TI

Api desenvolvida para etapa de teste do processo seletivo da empresa Solution TI.




## Stack utilizada

**Back-end:** JAVA 21, Spring Boot 3.5.4, Maven, PostgreSQL, Docker


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

