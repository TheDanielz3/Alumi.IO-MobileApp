package com.example.alumiio.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.alumiio.models.Aluno;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AlunoJsonParser {

    public static ArrayList<Aluno> parserJsonAlunos(JSONArray response, Context context){

        ArrayList<Aluno> tempAlunoList = new ArrayList<>();

        try {

            for (int i = 0; i < response.length(); i++){
                JSONObject aluno = (JSONObject) response.get(i);
                int alunoID = aluno.getInt("id");
                String nome = aluno.getString("nome");


            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return tempAlunoList;
    }

}
