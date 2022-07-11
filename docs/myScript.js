class Galener{

    //constructor(email, nome, cpf, dtNasc, endereco, telefone, grupoId, grupoNome)
    constructor(email, nome, cpf, telefone, dtNasc, endereco, grupoid, gruponome)
    {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.grupoid = grupoid;
        this.gruponome = gruponome;
    }
    

}

function enviarFormulario(){
    var emailValue = document.getElementById('adicionarEmail').value;
    var nomeValue = document.getElementById('adicionarNome').value;
    var cpfValue = document.getElementById('adicionarCpf').value;
    var telefoneValue = document.getElementById('adicionarTelefone').value;
    var dtNascValue = document.getElementById('dataNascimento').value;
    var enderecoValue = document.getElementById('endereco').value;
    var grupoIdValue = document.getElementById('adicionarGrupoId').value;
    var grupoNomeValue = document.getElementById('adicionarGrupoNome').value;

    //let galener = new Galener(emailValue, nomeValue, cpfValue, telefoneValue, dtNascValue, enderecoValue, grupoIdValue, grupoNomeValue);
    let galener = new Galener(emailValue, nomeValue, cpfValue, telefoneValue, dtNascValue, enderecoValue, grupoIdValue, grupoNomeValue);
    console.log("enviarFormulario:galener = " + galener)
    var parsed = JSON.stringify(galener);
    console.log("enviarFormulario:parsed = " +parsed);
    

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/galeners");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = () => console.log(xhr.responseText);
    xhr.send(parsed);

};


function processarPlanilha(){

    var nomePlanilha = document.getElementById('nomePlanilha').value;
    console.log("nomePlanilha: " + nomePlanilha);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/carregarPlanilha");
    xhr.setRequestHeader("Content-Type", "application/json");
    var body = '{"fileName":"'
    body += nomePlanilha;
    body += '"}'
    console.log(body)
    xhr.send(body);
}

async function getGaleners(){
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8080/galeners");
    //xhr.setRequestHeader("Content-Type", "application/json");
    //xhr.onload = () => console.log("dentro do onload" + xhr.responseText);
    xhr.onload = () => {

        try {    
            //var array = JSON.parse(xhr.response)
            
              
            var array = xhr.responseText;

            var galeners = JSON.parse(array)

            for (var value in galeners) {
                console.log(value.value)
            }

            //console.log("array: " + array);

            console.log("galeners: " + galeners);
            showCards(galeners)

        } catch (error) {
            console.log(error)
        }
        var array = xhr.responseText
        
    
    }
    xhr.send();


    

    //console.log(array)

    
    
    //console.log(xhr.responseText)

   let galeners = JSON.parse(xhr.response);
    console.log("galeners = " + galeners)

    var result = [];

    for(var i in galeners){
        result.push([i, galeners [i]]);
    }

   // console.log("result: " + result)

    //showCards(galeners)
}

function deletarGalener(id)
{
    console.log("deletando" + id)
    alert("Deletando galeners com o id " + id)

    var  url = "http://localhost:8080/galeners/"
    url += id

    let xhr = new XMLHttpRequest();
    xhr.open("DELETE", url);
    xhr.send();

    //getGaleners()



}

function showCards(galeners){
    let output = ''


    for (let galener of galeners){

        output += `<div class=cardGalener>`
        output += `<div class="card" style="width: 18rem;">`
        output += `<div class="card-header" id="cardNome"> ${galener.nome} </div>`
        output += `<ul class="list-group list-group-flush">`
        output += `<li class="list-group-item" id="cardEmail"> ${galener.email}</li>`
        output += `<li class="list-group-item" id="cardTelefone"> ${galener.telefone}</li>`
        output += `<li class="list-group-item" id="cardGrupo">${galener.gruponome}</li>`
        output += `<a href="#" class="btn btn-info" data-toggle="modal" data-target="#exampleModal" onclick=editarInformacoes(${galener.id})>Editar Informações</a>`
        output += `<a href="#" class="btn btn-danger" onclick=deletarGalener(${galener.id})>Deletar</a>`
        output += `</ul></div></div>`
        output += `</br>`
    }
    document.querySelector('main').innerHTML = output;

}

function openTab(tabName) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";
    }
    document.getElementById(tabName).style.display = "block";
}

function editarInformacoes(){

    //pega dados no banco
    // insere dados do galener como placeholder
    
    //console.log("Editando id: " + id)
   carregaPlaceholderModal(id)

    var emailValue = document.getElementById('editEmail').value;
    var nomeValue = document.getElementById('editNome').value;
    var cpfValue = document.getElementById('editcpf').value;
    var telefoneValue = document.getElementById('editTelefone').value;
    //var dtNascValue = document.getElementById('editDtNasc').value;
    var enderecoValue = document.getElementById('editEndereco').value;
    var grupoIdValue = document.getEgetElementByIdlementsByName('editGrupoId').value;
    var grupoNomeValue = document.getElementById('editGrupoNome').value;

    let galener = new Galener(emailValue, nomeValue, cpfValue, telefoneValue, dtNascValue, enderecoValue, grupoIdValue, grupoNomeValue);

    let xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/galeners/";
    url += id;
    xhr.open("PUT", url);



}


async function carregaPlaceholderModal(id){
    let xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/galeners/";
    url += id;

    xhr.open("GET", url);
    xhr.onload = () => {

        try {    
        
             galener = JSON.parse(xhr.responseText);
             console.log(galener)
            
            document.getElementById('editEmail').placeholder = galener.email;
            document.getElementById('editNome').placeholder = galener.nome;
            document.getElementById('editcpf').placeholder = galener.cpf;
            document.getElementById('editTelefone').placeholder = galener.telefone;
            document.getElementById('editDtNasc').placeholder = galener.dtnascimento;
            document.getElementById('editEndereco').placeholder = galener.endereco;
            document.getElementById('editGrupoId').placeholder = galener.grupoid;
            document.getElementById('editGrupoNome').placeholder = galener.gruponome;


        } catch (error) {
            console.log(error)
        }
    }
    xhr.send();
}


