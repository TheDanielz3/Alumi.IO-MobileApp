package com.example.alumiio.models;

public class Disciplina_Turma {

    private long id;
    private int id_disciplina;
    private int id_turma;
    private int id_professor;

    public Disciplina_Turma(/*int id,*/ int id_disciplina, int id_turma, int id_professor) {
        //this.id = id;
        this.id_disciplina = id_disciplina;
        this.id_turma = id_turma;
        this.id_professor = id_professor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    @Override
    public String toString() {
        return "Disciplina_Turma{" +
                "id=" + id +
                ", id_disciplina=" + id_disciplina +
                ", id_turma=" + id_turma +
                '}';
    }
}
