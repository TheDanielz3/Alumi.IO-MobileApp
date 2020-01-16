package com.example.alumiio.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.alumiio.models.Tpc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TpcJsonParser {
    public static ArrayList<Tpc> parserJsonTpcs(JSONArray response, Context context){

        ArrayList<Tpc> tempTpc = new ArrayList<>();

        try {
            for (int i= 0; i< response.length();i++) {
                JSONObject tpc = (JSONObject) response.get(i);
                int tpcID = tpc.getInt("id");
                String tpcDescricao = tpc.optString("descricao");
                int tpcID_DisciplinaTurma = tpc.getInt("id_disciplina_turma");
                int tpcID_Professor = tpc.getInt("id_professor");



                Tpc auxTpc = new Tpc(tpcID,tpcDescricao,tpcID_DisciplinaTurma,tpcID_Professor);

                tempTpc.add(auxTpc);
            }

        }catch (JSONException e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return tempTpc;
    }
    public static Tpc parserJsonTpc(String response,Context context)
    {
        Tpc tempTPC = null;

        try {
            JSONObject tpc = new JSONObject(response);

            int tpcID = tpc.getInt("id");
            String tpcDescricao = tpc.optString("descricao");
            int tpcID_DisciplinaTurma = tpc.getInt("id_disciplina_turma");
            int tpcID_Professor = tpc.getInt("id_professor");

            Tpc auxTpc = new Tpc(tpcID,tpcDescricao,tpcID_DisciplinaTurma,tpcID_Professor);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return tempTPC;
    }

    public static boolean isConnectionInternet(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
