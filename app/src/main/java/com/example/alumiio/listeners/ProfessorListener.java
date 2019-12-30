package com.example.alumiio.listeners;

import com.example.alumiio.models.Professor;

import java.util.ArrayList;

public interface ProfessorListener {

    void onRefreshProfessorList(ArrayList<Professor> professorList);

    //void onUpdateProfessorlist(Professor professor, int operation);
}
