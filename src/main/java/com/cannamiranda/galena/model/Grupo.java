package com.cannamiranda.galena.model;

public class Grupo {
    private String id;
    private String nome;

    public Grupo(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Grupo() {
        this.id = "";
        this.nome = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        String str = new String();
        str = str.concat("id: " + getId());
        str = str.concat("\nnome do grupo: " + getNome());


        return str;
    }
}
