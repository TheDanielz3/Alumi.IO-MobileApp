package com.example.alumiio.models;

public class Professor {

    public String Nome;
    public int id;

    public Professor(int id ,String nome) {
        Nome = nome;
        this.id = 0;
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
