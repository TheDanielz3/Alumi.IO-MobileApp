package com.example.alumiio.models;

public class Recado {

    private int id;
    private String topico;
    private String descricao;
    private int assinado;
    private int data_hora;
    private int id_disciplina_turma;
    private int id_aluno;
    private int id_professor;

    public Recado(int id, String topico, String descricao, int assinado, int data_hora, int id_disciplina_turma, int id_aluno, int id_professor) {
        this.id = id;
        this.topico = topico;
        this.descricao = descricao;
        this.assinado = assinado;
        this.data_hora = data_hora;
        this.id_disciplina_turma = id_disciplina_turma;
        this.id_aluno = id_aluno;
        this.id_professor = id_professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAssinado() {
        return assinado;
    }

    public void setAssinado(int assinado) {
        this.assinado = assinado;
    }

    public int getData_hora() {
        return data_hora;
    }

    public void setData_hora(int data_hora) {
        this.data_hora = data_hora;
    }

    public int getId_disciplina_turma() {
        return id_disciplina_turma;
    }

    public void setId_disciplina_turma(int id_disciplina_turma) {
        this.id_disciplina_turma = id_disciplina_turma;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }
}
