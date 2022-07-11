# teste-galena

##
URL front: https://claramiranda.github.io/teste-galena/

## Como Executar o projeto
 Pré-requisito: baixar localmente o projeto e salvar o arquivo xlsx dentro da pasta /resources.

 1. Para iniciar o serviço back-end, deve-se executar o método main da classe GalenaApplication, ele subirá o servidor no endereço http://localhost:8080/.
 Com o back-end inicializado, o primeiro passo é inserir o nome do arquivo a ser processado na tab "Importar Dados" e clicar no botão "Processar Planilha", após isso os dados processados poderão ser visualizados na tab "Ver Todes". Nesse momento, os dados são processados e salvos numa base de dados local.


 2. Clicar no botão "Ver Todes", para ver cards montados com os dados importados da planilha.



## Rotas
    POST /carregarPlanilha
        Descrição: Rota utilizada para carregar dados advindos do xlsx
            corpo do request: 
                {
                    "fileName":"nome_do_arquivo.xlsx",
                }
            Resposta: json com os dados processados da planilha

    GET /galeners
        Descrição: Responde listagem de todes galeners cadastrados no banco        
            corpo do request: não necessário
            Resposta: json a listagem de todes galeners salvos no banco

    DELETE /galeners/{id}
        Descrição: Deleta galener da base de dados
            corpo do request: não necessário
            Resposta: codigo 200



    

## Sobre

O projeto abaixo foi desenvolvido para uma avaliação técnica. Trata-se de uma api desenvolvida em Java, utilizando o framework Spring Boot para ler, tratar e manipular dados recebidos de um arquivo .xlsx.

A api foi configurada para tratar um formato específico de planilha, e um exemplo pode ser [encontrado aqui] <https://docs.google.com/spreadsheets/d/1W-BNQydJBdoX7_Iw0wTAqAQnMpZ-nyAkhIYIV7IbgTw/edit?usp=sharing>.

O objetivo da ferramenta é ler e processar uma planilha com informações de Galeners e oferecer através de uma aplicação front-end a capacidade de adição, edição e remoção  dos dados.

## Tecnologias Envolvidas

  - Back-End
    - Java 8 + Spring Boot - Desenvolvimento de API Rest
    - MAVEN - Gerenciador de pacotes


- Front-End
  - HTML
  - CSS + Bootstrap
  - Javascript vanilla

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
    - [X] Requests via js
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

	
