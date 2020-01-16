package com.example.alumiio.listeners;

import com.example.alumiio.models.Aluno;

import java.util.ArrayList;

public interface AlunoListener {

    void onRefreshAlunoList(ArrayList<Aluno> alunoList);

    void onUpdateAlunolist(Aluno aluno, int operation);

}
