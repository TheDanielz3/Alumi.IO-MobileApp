package com.example.alumiio.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.alumiio.models.Turma;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TurmaJsonParser {
    public static ArrayList<Turma> parserJsonTpcs(JSONArray response, Context context){

        ArrayList<Turma> tempTurma = new ArrayList<>();

        try {
            for (int i= 0; i< response.length();i++) {
                JSONObject turma = (JSONObject) response.get(i);
                int turmaID = turma.getInt("id");
                int turmaAno = turma.getInt("ano");
                String turmaLetra = turma.getString("letra");


                Turma auxTurma = new Turma(turmaID,turmaAno,turmaLetra);

                tempTurma.add(auxTurma);
            }

        }catch (JSONException e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return tempTurma;
    }
    public static Turma parserJsonTpc(String response,Context context)
    {
        Turma tempTurma = null;

        try {
            JSONObject turma = new JSONObject(response);

            int turmaID = turma.getInt("id");
            int turmaAno = turma.getInt("ano");
            String turmaLetra = turma.getString("letra");


            tempTurma = new Turma(turmaID,turmaAno,turmaLetra);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return tempTurma;
    }

    public static boolean isConnectionInternet(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
