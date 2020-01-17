package com.example.alumiio.models;

public class Professor {

    private long id;
    private String Nome;

    public Professor(String nome) {
        Nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

}
