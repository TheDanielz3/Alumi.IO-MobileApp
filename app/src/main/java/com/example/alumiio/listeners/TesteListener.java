package com.example.alumiio.listeners;

import com.example.alumiio.models.Teste;

import java.util.ArrayList;

public interface TesteListener {


    void onRefreshTpcList(ArrayList<Teste> testeList);

    void onUpdateTpclist(Teste teste, int operation);
}
