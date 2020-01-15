package com.example.alumiio.models;

public class Aluno {

  //  public long id;
    public String nome;
    public int numeroDeEstudante;
    public int id_turma;



    public Aluno( String nome, int numeroDeEstudante) {
     //   this.id = id;
        this.nome = nome;
        this.numeroDeEstudante = numeroDeEstudante;
    }

 //   public long getId() {
     //   return id;
   // }

   // public void setId(long id) {
     //   this.id = id;
   // }

    public int getNumeroDeEstudante() {
        return numeroDeEstudante;
    }

    public void setNumeroDeEstudante(int numeroDeEstudante) {
        this.numeroDeEstudante = numeroDeEstudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
