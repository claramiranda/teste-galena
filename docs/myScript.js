class Galener{

    constructor(email, nome, cpf, dtNasc, endereco, telefone, grupoId, grupoNome)
    {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.grupoId = grupoId;
        this.grupoNome = grupoNome;
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

    let galener = new Galener(emailValue, nomeValue, cpfValue, telefoneValue, dtNascValue, enderecoValue, grupoIdValue, grupoNomeValue);

    console.log(galener)

    /*var galener = {
        nome: nomeValue,
        email: emailValue,
        cpf:cpfValue,
        telefone:telefoneValue,
        dtNasc:dtNascValue,
        endereco:enderecoValue,
        grupoId:grupoIdValue,
        grupoNome:grupoNomeValue
    };*/

    var parsed = JSON.stringify(galener);
    console.log(parsed);
    

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/galeners");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = () => console.log(xhr.responseText);
    xhr.send(parsed);

};


function enviarPlanilha(){

    
    let data = document.getElementById("carregarPlanilhaGaleners").files[0];
    let entry = document.getElementById("carregarPlanilhaGaleners").files[0];


    //console.log('doupload',entry,data)
    fetch('carregarPlanilha' + encodeURIComponent(entry.name), {method:'POST',body:data});
    
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/carregarPlanilha");
    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Access-Control-Allow-Origin","*");
    xhr.setRequestHeader("fileName",data.name)
    xhr.setRequestHeader("rowStart","4")
    xhr.setRequestHeader("cellMax","7")

    xhr.onload = () => console.log(xhr.responseText);
    xhr.send();
    //alert('your file has been uploaded');


   /* let req = new XMLHttpRequest();
    let formData = new FormData();

    formData.append("photo", photo);                                
    req.open("POST", '/upload/image');
    req.send(formData);*/

    console.log(data.name);
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
    alert(id)

    var  url = "http://localhost:8080/galeners/"
    url += id

    let xhr = new XMLHttpRequest();
    xhr.open("DELETE", url);
    xhr.send();



}

function showCards(galeners){
    let output = ''


    for (let galener of galeners){

        output += `<div class="card" style="width: 18rem;">`
        output += `<div class="card-header" id="cardNome"> ${galener.nome} </div>`
        output += `<ul class="list-group list-group-flush">`
        output += `<li class="list-group-item" id="cardEmail"> ${galener.email}</li>`
        output += `<li class="list-group-item" id="cardTelefone"> ${galener.telefone}</li>`
        output += `<li class="list-group-item" id="cardGrupo">${galener.gruponome}</li>`
        output += `<a href="#" class="btn btn-secondary">Editar Informações</a>`
        output += `<a href="#" class="btn btn-danger" onclick=deletarGalener(${galener.id})>Deletar</a>`
        output += `</ul></div>`
        output += `</br>`

        console.log("passando no laço" + galener)

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