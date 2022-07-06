# teste-galena

## Sobre

O projeto abaixo foi desenvolvido para uma avaliação técnica. Trata-se de uma api desenvolvida em Java, utilizando o framework Spring Boot para ler, tratar e manipular dados recebidos de um arquivo .xlsx.

A api foi configurada para tratar um formato específico de planilha, e um exemplo pode ser [encontrado aqui] <https://docs.google.com/spreadsheets/d/1W-BNQydJBdoX7_Iw0wTAqAQnMpZ-nyAkhIYIV7IbgTw/edit?usp=sharing>.

O objetivo da ferramenta é ler e processar uma planilha com informações de Galeners e oferecer através de uma aplicação front-end a capacidade de adição, edição e remoção  dos dados.

## Tecnologias Envolvidas

  - Back-End
    - Java 8 + Spring Boot - Desenvolvimento de API Rest
    - MAVEN - Gerenciador de pacotes
    - Postgree - Banco de dados local


- Front-End
  - HTML
  - CSS + Bootstrap
  - Javascript 

## Objetivos
  - Back-End

  - [X] API Rest utilizando Spring
    - [X] Processamento da Planilha
    - [X] Salvar dados em bd
    - [X] Rota de listagem geral 
    - [X] Rota de listagem detalhada
    - [X] Rota de edição 
    - [X] Rota de deleção
    - [X] Tratamento de 404
    - [ ] Deploy da aplicação no Heroku 
    - [ ] Criação dos Swaggers 
    - [ ] Automatização de deploy via GH


  - Front-End
    - [ ] Estrutura HTML da página
    - [X] Aplicação de bootstrap
    - [ ] Requests via js
    - [X] Hospedar página no github pages

## Regras de negócio e cenários de exceção não tratados
Para limitação do escopo, foi dedidido que o e-mail é uma informação obrigatória para os Galeners, portanto a api processa os dados da planilha até encontrar uma célula com e-mail não preenchido.


## Dependências
  ### Framework Spring (org.springframework.boot)
   - spring-boot-starter-web
   - spring-boot-starter-test
   - spring-boot-devtools

  ### Apache POI (org.apache.poi) 
   - poi
   - poi-ooxml

	
