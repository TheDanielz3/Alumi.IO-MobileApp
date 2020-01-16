package com.example.alumiio.listeners;

import com.example.alumiio.models.Aluno;
import com.example.alumiio.models.Disciplina_Turma;

import java.util.ArrayList;

public interface DisciplinaTurmaListener {

    void onRefreshDisciplinaTurmaList(ArrayList<Disciplina_Turma> disciplinaTurmaList);

    void onUpdateDisciplinaTurmalist(Disciplina_Turma disciplinaTurma, int operation);

}
