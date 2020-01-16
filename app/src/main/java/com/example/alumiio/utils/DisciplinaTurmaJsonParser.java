package com.example.alumiio.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.alumiio.models.Aluno;
import com.example.alumiio.models.Disciplina_Turma;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisciplinaTurmaJsonParser {

    public static ArrayList<Disciplina_Turma> parserJsonDisciplinaTurma(JSONArray response, Context context){

        ArrayList<Disciplina_Turma> tempDisciplinaTurmaList = new ArrayList<>();

        try {

            for (int i = 0; i < response.length(); i++){
                JSONObject Disciplina_Turma = (JSONObject) response.get(i);
                int id = Disciplina_Turma.getInt("id");
                int id_turma = Disciplina_Turma.getInt("id_turma");
                int id_disciplina = Disciplina_Turma.getInt("id_disciplina");
                int id_professor = Disciplina_Turma.getInt("id_professor");

            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return tempDisciplinaTurmaList;
    }

}
