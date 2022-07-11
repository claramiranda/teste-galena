# teste-galena

##
URL front: https://claramiranda.github.io/teste-galena/

## Como Executar o projeto
 Pré-requisito: baixar localmente o projeto e salvar o arquivo xlsx dentro da pasta /resources.

 1. Para iniciar o serviço back-end, deve-se executar o método main da classe GalenaApplication, ele subirá o servidor no endereço http://localhost:8080/.
 Com o back-end inicializado, o primeiro passo é inserir o nome do arquivo a ser processado na tab "Importar Dados" e clicar no botão "Processar Planilha", após isso os dados processados poderão ser visualizados na tab "Ver Todes". Nesse momento, os dados são processados e salvos numa base de dados local.

Exemplo de planilha![Alt ou título da imagem](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto3.png?raw=true)

Localização do arquivo![Localização do Arquivo](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto2.png?raw=true)

Carregando a planilha, o front-end pode ser acessado através do link https://claramiranda.github.io/teste-galena/ ![Carregamento da planilha](https://github.com/claramiranda/teste-galena/blob/master/docs/img/carregamento.png?raw=true)

Dados salvos no banco, pode ser consultado via http://localhost:8080/h2-console ![Dados salvos no banco local](https://github.com/claramiranda/teste-galena/blob/master/docs/img/dadosnobanco.png?raw=true)


2. Alternar para a tab "Ver Todes", para ver cards montados com os dados importados da planilha. É necessário clicar no botão "Atualizar Lista para que os resultados sejam carregados."

Listagem de galeners ![Cards de Galeners](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto4.png?raw=true)



3. Para incluir um novo registro de galeners, é só navegar até a tab Adicionar galener e preencher o formulário. Após isso, se retornarmos a tab Ver Toder e atualizar a lista, podemos checar o novo Galener!

Adicionando galener ![Incluir Galener](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto5.png?raw=true)

Novo Galener na lista![CArd novo galener](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto6.png?raw=true)


4. Ao clicar no botão Editar Informações dentro do card de um galener, um modal é aberto, contendo o estado atual dos dados como placeholder.

Placeholder dos dados![Placeholder dados](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto7.png?raw=true)

5. Após preencher os dados é só clicar em Save changes e voltar para a listagem para ver o galener atualizado

Formulário preenchido![Formulario preenchido](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto8.png?raw=true)

Rota de detalhes do galener atulizado![Postman galener atualizado](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto9.png?raw=true)

Galener atulizado no banco![Galener atualizado no bd](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto10.png?raw=true)

Galener atualizado no front![Galener atualizado no front](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto11.png?raw=true)


6. Para deletar um galener, é só clicar no botão Deletar. Um alerta será emitido na página e após clicar em Atualizar Lista o card será removido do front.
Alerta de galener sendo excluido![Deletando Galener](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto12.png?raw=true)

Lista atualizada![Lista Atualizada](https://github.com/claramiranda/teste-galena/blob/master/docs/img/foto13.png?raw=true)


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

    GET /galeners/{id}
        Descrição: Carrega galener do banco usando ID como parametro      
            corpo do request: não necessário
            Resposta: json com dados de galener salvos no banco

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

	
