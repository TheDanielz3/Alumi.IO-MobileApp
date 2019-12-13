package com.example.alumiio.listeners;

import com.example.alumiio.models.Recado;

import java.util.ArrayList;

public interface RecadoListener {


    void onRefreshTpcList(ArrayList<Recado> recadoList);

    void onUpdateTpclist(Recado recado, int operation);

}
