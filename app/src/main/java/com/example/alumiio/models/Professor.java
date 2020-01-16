package com.example.alumiio.models;

public class Professor {

    private int id;
    private String Nome;

    public Professor(int id, String nome) {
        this.id = id;
        Nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

}
