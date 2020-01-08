package com.example.alumiio.models;

public class Tpc {

    public long id;
    public String Descricao;

    public Tpc(long id, String descricao) {
        this.id = 0;
        Descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
