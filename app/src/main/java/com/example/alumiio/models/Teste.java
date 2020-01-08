package com.example.alumiio.models;

public class Teste {

public long id;
public int Data;
public int Hora;
public String Descricao;
public int Turma;
public int Disciplina;

    public Teste(long id, int data, int hora, String descricao, int turma, int disciplina) {
        this.id = 0;
        Data = data;
        Hora = hora;
        Descricao = descricao;
        Turma = turma;
        Disciplina = disciplina;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int hora) {
        Hora = hora;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getTurma() {
        return Turma;
    }

    public void setTurma(int turma) {
        Turma = turma;
    }

    public int getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(int disciplina) {
        Disciplina = disciplina;
    }
}
