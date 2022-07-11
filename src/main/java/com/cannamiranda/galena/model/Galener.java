package com.cannamiranda.galena.model;


//TODO transformar classe em entidade

import com.cannamiranda.galena.repository.GalenerRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Galener {

    //@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id @GeneratedValue Long id;
    private String email;
    private String nome;
    private String grupoid;
    private String gruponome;

    //private Grupo grupo;
    private String cpf;
    private String telefone;
    private String dtnascimento;
    private String endereco;


    /** CONSTRUCTORS */
    public Galener(String email, String nome, String grupoid, String gruponome, String cpf, String telefone, String dtnascimento, String endereco) {
        //this.id = Long.valueOf(hashCode());
        this.email = email;
        this.nome = nome;
        this.grupoid = grupoid;
        this.gruponome = gruponome;
        //this.grupo = new Grupo(grupoId, grupoNome);
        this.cpf = cpf;
        this.telefone = telefone;
        this.dtnascimento = dtnascimento;
        this.endereco = endereco;
    }

    public Galener() {
        //this.id = Long.valueOf(hashCode());
        this.email = "";
        this.nome = "";
        //this.grupo = new Grupo();
        this.cpf = "";
        this.telefone = "";
        this.dtnascimento = "";
        this.endereco = "";

    }

    public Galener atualizar(Galener galener, GalenerRepository galenerRepository){
        //this.setId(galener.getId());

        this.setEmail(galener.getEmail());
        this.setNome(galener.getNome());
        this.setGrupoid(galener.getGrupoid());
        this.setGruponome(galener.getGruponome());
        this.setCpf(galener.getCpf());
        this.setTelefone(galener.getTelefone());
        this.setDtnascimento(galener.getDtnascimento());
        this.setEndereco(galener.getEndereco());

        galenerRepository.save(this);
        return this;
    }



    /** Override methods*/

    @Override
    public String toString() {
        String galener = new String();

        galener = galener.concat("Nome: " + getNome());
        galener = galener.concat("\nEmail: " + getEmail());
        galener = galener.concat("\nCPF: " + getCpf());
        galener = galener.concat("\nTelefone: " + getTelefone());
        galener = galener.concat("\nData de Nascimento: " + getDtnascimento());
        galener = galener.concat("\nEndereco: " + getEndereco());
        //galener = galener.concat("\nGrupo: " + getGrupo());
        galener = galener.concat("\nGrupo ID: " + getGrupoid());
        galener = galener.concat("\nGrupo Nome: " + getGruponome());

        return galener;
    }


    //GETTERS AND SETTERS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email == null || email == ""){
            //System.out.println("Email nao informado");
            this.email = "Nao Informado";
        }
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        //this.nome = nome;
        if (nome == null || nome == ""){
            //System.out.println("nome nao informado");
            this.nome = "Nao Informado";
        }
        this.nome = nome;

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;

        if (cpf == null || cpf == ""){
            //System.out.println("CPF nao informado");
            this.cpf = "Não informado";
        }

        this.cpf = cpf;

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {

        if (telefone == null || telefone == ""){
            //System.out.println("Telefone nao informado");
            this.telefone = "Não informado";
        }


        this.telefone = telefone;
    }

    public String getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(String dtnascimento) {
        //this.dtnascimento = dtnascimento;
        if (dtnascimento == null || dtnascimento.equals("")){
            //System.out.println("dtnascimento nao informado");
            this.dtnascimento = "Não informado";
        }
        this.dtnascimento = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        //this.endereco = endereco;
        if (endereco == null || endereco.equals("")){
            //System.out.println("endereco nao informado");
            this.endereco = "Não informado";
        }
        this.endereco = endereco;
    }

    public String getGrupoid() {
        return grupoid;
    }

    public void setGrupoid(String grupoid) {
        //this.grupoid = grupoid;
        if (grupoid == null || grupoid == ""){
            ///System.out.println("grupoid nao informado");
            this.grupoid = "Nao Informado";
        }
        this.grupoid = grupoid;
    }

    public String getGruponome() {
        return gruponome;
    }

    public void setGruponome(String gruponome) {
        //this.gruponome = gruponome;
        if (gruponome == null || gruponome == ""){
            //System.out.println("gruponome nao informado");
            this.gruponome = "Nao Informado";
        }
        this.gruponome = gruponome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
