package com.example.alumiio.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.alumiio.models.Recado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecadoJsonParser {

    public static ArrayList<Recado> parserJsonRecados(String response, Context context) {
        ArrayList<Recado> tempRecadoList = new ArrayList<>();

        try {
            JSONArray jsonArrayResponse = new JSONArray(response);
            for (int i = 0; i < jsonArrayResponse.length() -1; i++) {
                JSONObject recado = (JSONObject) jsonArrayResponse.get(i);
                int recadoID = recado.getInt("id");
                String recadoTopico = recado.getString("topico");
                String recadoDescricao = recado.getString("descricao");
                int recadoAssinado = recado.getInt("assinado");
                int recadoDataHora = recado.getInt("data_hora");
                int recadoID_DisciplinaTurma = recado.getInt("id_disciplina_turma");

                String id_Recado = recado.getString("id_aluno");
                int recadoID_Aluno = -1;

                boolean digitsOnly = TextUtils.isDigitsOnly(id_Recado);

                if (digitsOnly && id_Recado.length() > 0) {
                    recadoID_Aluno = recado.getInt("id_aluno");
                }

                int recadoID_Professor = recado.getInt("id_professor");

                Recado auxRecado = new Recado(recadoTopico, recadoDescricao, recadoAssinado, recadoDataHora, recadoID_DisciplinaTurma, recadoID_Aluno, recadoID_Professor);

                tempRecadoList.add(auxRecado);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return tempRecadoList;

    }

    public static Recado parserJsonRecado(String response, Context context) {
        Recado tempRecado = null;

        try {
            JSONObject recado = new JSONObject(response);
            int recadoID = recado.getInt("id");
            String recadoTopico = recado.getString("topico");
            String recadoDescricao = recado.getString("descricao");
            int recadoAssinado = recado.getInt("assinado");
            int recadoDataHora = recado.getInt("data_hora");
            int recadoID_DisciplinaTurma = recado.getInt("id_disciplina_turma");
            int recadoID_Aluno = recado.getInt("id_aluno");
            int recadoID_Professor = recado.getInt("id_professor");

            Recado auxRecado = new Recado(recadoTopico, recadoDescricao, recadoAssinado, recadoDataHora, recadoID_DisciplinaTurma, recadoID_Aluno, recadoID_Professor);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return tempRecado;
    }

    public static boolean isConnectionInternet(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
