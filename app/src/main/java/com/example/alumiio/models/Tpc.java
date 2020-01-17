package com.example.alumiio.models;

public class Tpc {

    private long id;
    private String descricao;
    private int id_disciplina_turma;
    private int id_professor;

    public Tpc( String descricao, int id_disciplina_turma, int id_professor)
    {
        this.descricao = descricao;
        this.id_disciplina_turma = id_disciplina_turma;
        this.id_professor = id_professor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_disciplina_turma() {
        return id_disciplina_turma;
    }

    public void setId_disciplina_turma(int id_disciplina_turma) {
        this.id_disciplina_turma = id_disciplina_turma;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }
}
