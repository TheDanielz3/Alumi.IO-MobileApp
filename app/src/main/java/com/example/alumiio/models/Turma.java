package com.example.alumiio.models;

public class Turma {

    private int id;
    private int ano;
    private String letra;

    public Turma(int id, int ano, String letra) {
        this.id = id;
        this.ano = ano;
        this.letra = letra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
