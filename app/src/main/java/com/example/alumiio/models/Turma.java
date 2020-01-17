package com.example.alumiio.models;

public class Turma {

    private long id;
    private int ano;
    private String letra;

    public Turma(/*int id,*/ int ano, String letra) {
      //  this.id = id;
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
