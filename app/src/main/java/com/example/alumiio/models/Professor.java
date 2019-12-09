package com.example.alumiio.models;

public class Professor {

    public String Nome;
    public int id;

    public Professor(String nome, int id) {
        Nome = nome;
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
