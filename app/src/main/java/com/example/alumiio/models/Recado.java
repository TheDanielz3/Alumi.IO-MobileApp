package com.example.alumiio.models;

public class Recado {

    public String Recado;
    public boolean assinado = false;

    public String getRecado() {
        return Recado;
    }

    public void setRecado(String recado) {
        Recado = recado;
    }

    public boolean isAssinado() {
        return assinado;
    }

    public void setAssinado(boolean assinado) {
        this.assinado = assinado;
    }
}
