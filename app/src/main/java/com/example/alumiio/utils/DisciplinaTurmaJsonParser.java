package com.example.alumiio.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.alumiio.models.Aluno;
import com.example.alumiio.models.Disciplina_Turma;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisciplinaTurmaJsonParser {

    public static ArrayList<Disciplina_Turma> parserJsonDisciplinaTurma(String response, Context context){

        ArrayList<Disciplina_Turma> tempDisciplinaTurmaList = new ArrayList<>();

        try {
            JSONArray jsonArrayResponse = new JSONArray(response);
            for (int i = 0; i < jsonArrayResponse.length(); i++){
                JSONObject Disciplina_Turma = (JSONObject) jsonArrayResponse.get(i);
                int id = Disciplina_Turma.getInt("id");
                int id_turma = Disciplina_Turma.getInt("id_turma");
                int id_disciplina = Disciplina_Turma.getInt("id_disciplina");
                int id_professor = Disciplina_Turma.getInt("id_professor");

                Disciplina_Turma auxDisciplinaTurma = new Disciplina_Turma(/*id,*/id_disciplina,id_turma,id_professor);
                tempDisciplinaTurmaList.add(auxDisciplinaTurma);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return tempDisciplinaTurmaList;
    }

    public static boolean isConnectionInternet(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }

}
