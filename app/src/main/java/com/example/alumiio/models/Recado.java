package com.example.alumiio.models;

public class Recado {

    public long id;
    public String descricao;
    public int assinado;

    public Recado(long id, String descricao, int assinado) {
        this.id = id;
        this.descricao = descricao;
        this.assinado = assinado;
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

    public int getAssinado() {
        return assinado;
    }

    public void setAssinado(int assinado) {
        this.assinado = assinado;
    }
}
