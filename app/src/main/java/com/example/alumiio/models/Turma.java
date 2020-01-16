package com.example.alumiio.models;

public class Turma {

    public long id;
    public int ano;
    public String letra;

    public Turma(long id, int ano, String letra) {
        this.id = 0;
        this.ano = ano;
        this.letra = letra;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
