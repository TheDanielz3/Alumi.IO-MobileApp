package com.example.alumiio.models;

public class Aluno {

    private long id;
    private int id_encarregado_de_educacao;
    private int id_turma;
    private String nome;
    private int numeroDeEstudante;

    public Aluno(int id_encarregado_de_educacao, int id_turma, String nome, int numeroDeEstudante) {
        this.id_encarregado_de_educacao = id_encarregado_de_educacao;
        this.id_turma = id_turma;
        this.nome = nome;
        this.numeroDeEstudante = numeroDeEstudante;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_encarregado_de_educacao() {
        return id_encarregado_de_educacao;
    }

    public void setId_encarregado_de_educacao(int id_encarregado_de_educacao) {
        this.id_encarregado_de_educacao = id_encarregado_de_educacao;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeEstudante() {
        return numeroDeEstudante;
    }

    public void setNumeroDeEstudante(int numeroDeEstudante) {
        this.numeroDeEstudante = numeroDeEstudante;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
