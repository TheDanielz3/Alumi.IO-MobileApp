package com.example.alumiio.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.alumiio.models.Teste;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TesteJsonParser {

    public static ArrayList<Teste> parserJsonTestes(JSONArray response, Context context){

        ArrayList<Teste> tempTeste = new ArrayList<>();

        try {
            for (int i = 0;i < response.length();i++)
            {
                JSONObject teste = (JSONObject) response.get(i);
                int testeID = teste.getInt("id");
                String testeDescricao = teste.getString("descricao");
                int testeDataHora = teste.getInt("data_hora");
                int testeID_DisciplinaTurma = teste.getInt("id_disciplina_turma");
                int testeID_Professor = teste.getInt("id_professor");

                Teste auxTeste = new Teste(testeID,testeDescricao,testeDataHora,testeID_DisciplinaTurma,testeID_Professor);

                tempTeste.add(auxTeste);
            }

        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();

        }

        return tempTeste;
    }

    public static  Teste parserJsonTpc(String response,Context context)
    {
        Teste auxTeste = null;

        try {
            JSONObject teste = new JSONObject(response);

            int testeID = teste.getInt("id");
            String testeDescricao = teste.getString("descricao");
            int testeDataHora = teste.getInt("data_hora");
            int testeID_DisciplinaTurma = teste.getInt("id_disciplina_turma");
            int testeID_Professor = teste.getInt("id_professor");

             auxTeste = new Teste(testeID,testeDescricao,testeDataHora,testeID_DisciplinaTurma,testeID_Professor);


        }
        catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return auxTeste;
    }

    public static boolean isConnectionInternet(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
