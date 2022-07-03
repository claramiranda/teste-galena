package com.cannamiranda.galena.model;

public class Galener {
    private String email;
    private String nome;
    private Grupo grupo;
    private String cpf;
    private String telefone;
    private String dtNascimento;
    private String endereco;


    @Override
    public String toString() {
        String galener = new String();

        galener.concat("Nome: " + getNome());
        galener.concat("\nEmail: " + getEmail());
        galener.concat("\nCPF: " + getCpf());
        galener.concat("\nTelefone: " + getTelefone());
        galener.concat("\nData de Nascimento: " + getDtNascimento());
        galener.concat("\nEndereco: " + getEndereco());
        galener.concat("\nGrupo: " + getGrupo());

        return galener;
    }


    //CONSTRUCTOR
    public Galener(String email, String nome, String grupoId, String grupoNome, String cpf, String telefone, String dtNascimento, String endereco) {
        this.email = email;
        this.nome = nome;
        this.grupo = new Grupo(grupoId, grupoNome);
        this.cpf = cpf;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
    }

    public Galener() {
        this.email = "";
        this.nome = "";
        this.grupo = new Grupo();
        this.cpf = "";
        this.telefone = "";
        this.dtNascimento = "";
        this.endereco = "";

    }

    //GETTERS AND SETTERS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email == null || email == ""){
            System.out.println("Email nao informado");
            this.email = null;
        }
        else {
            this.email = email;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;

        if (cpf == null || cpf == ""){
            System.out.println("CPF nao informado");
        }

        this.cpf = "Não informado";

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {

        if (telefone == null || telefone == ""){
            System.out.println("Telefone nao informado");
        }


        this.telefone = "Não informado";
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
