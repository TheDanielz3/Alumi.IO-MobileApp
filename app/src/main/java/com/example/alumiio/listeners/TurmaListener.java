package com.example.alumiio.listeners;

import com.example.alumiio.models.Turma;

import java.util.ArrayList;

public interface TurmaListener {
    void onRefreshTurmaList(ArrayList<Turma> turmaList);

    void onUpdateTurmalist(Turma turma, int operation);
}
