package com.example.alumiio.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.alumiio.models.Aluno;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AlunoJsonParser {

    public static ArrayList<Aluno> parserJsonAlunos(String response, Context context) {

        ArrayList<Aluno> tempAlunoList = new ArrayList<>();

        try {
            JSONArray jsonArrayResponse = new JSONArray(response);
            for (int i = 0; i < jsonArrayResponse.length(); i++) {
                JSONObject aluno = (JSONObject) jsonArrayResponse.get(i);
                int alunoID = aluno.getInt("id");
                //int alunoID_EncarregadoDeEducacao = aluno.getInt("id_encarregado_de_educacao");
                //int alunoID_Turma = aluno.getInt("id_turma");
                String alunoNome = aluno.getString("nome");
                //int alunoNumeroEstudante = aluno.getInt("numero_estudante");

                String STRING_alunoID_EncarregadoDeEducacao = aluno.getString("id_encarregado_de_educacao");
                int alunoID_EncarregadoDeEducacao = -1;

                boolean digitsOnly_STRING_alunoID_EncarregadoDeEducacao = TextUtils.isDigitsOnly(STRING_alunoID_EncarregadoDeEducacao);

                if (digitsOnly_STRING_alunoID_EncarregadoDeEducacao && STRING_alunoID_EncarregadoDeEducacao.length() > 0) {
                    alunoID_EncarregadoDeEducacao = aluno.getInt("id_encarregado_de_educacao");
                }

                String STRING_alunoID_Turma = aluno.getString("id_turma");
                int alunoID_Turma = -1;

                boolean digitsOnly_STRING_alunoID_Turma = TextUtils.isDigitsOnly(STRING_alunoID_Turma);

                if (digitsOnly_STRING_alunoID_Turma && STRING_alunoID_Turma.length() > 0) {
                    alunoID_Turma = aluno.getInt("id_turma");
                }

                String STRING_alunoNumeroEstudante = aluno.getString("numero_estudante");
                int alunoNumeroEstudante = -1;

                boolean digitsOnly_STRING_alunoNumeroEstudante = TextUtils.isDigitsOnly(STRING_alunoNumeroEstudante);

                if (digitsOnly_STRING_alunoNumeroEstudante && STRING_alunoNumeroEstudante.length() > 0) {
                    alunoNumeroEstudante = aluno.getInt("numero_estudante");
                }

                Aluno auxRecado = new Aluno(alunoID_EncarregadoDeEducacao,alunoID_Turma,alunoNome,alunoNumeroEstudante);

                tempAlunoList.add(auxRecado);

            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();

        }
        return tempAlunoList;
    }

    public static boolean isConnectionInternet(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
