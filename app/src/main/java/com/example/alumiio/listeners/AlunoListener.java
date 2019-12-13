package com.example.alumiio.listeners;

import com.example.alumiio.models.Aluno;

import java.util.ArrayList;

public interface AlunoListener {

    void onRefreshTpcList(ArrayList<Aluno> alunoList);

    void onUpdateTpclist(Aluno aluno, int operation);

}
