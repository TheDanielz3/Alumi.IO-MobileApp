package com.example.alumiio.listeners;

import com.example.alumiio.models.Turma;

import java.util.ArrayList;

public interface TurmaListener {
    void onRefreshTpcList(ArrayList<Turma> turmaList);

    void onUpdateTpclist(Turma turma, int operation);
}
