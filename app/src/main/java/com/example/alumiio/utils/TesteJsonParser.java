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
                int testeHORA = teste.getInt("hora");
                int testeDATA = teste.getInt("data");
                String testeDESCRICAO = teste.getString("descricao");
                int testeTURMA = teste.getInt("turma");
                int testeDISCIPLINA = teste.getInt("disciplina");

                Teste auxTeste = new Teste(testeID,testeDATA,testeHORA,testeDESCRICAO,testeTURMA,testeDISCIPLINA);

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
        Teste tempTeste = null;

        try {
            JSONObject teste = new JSONObject(response);

            int testeID = teste.getInt("id");
            int testeHORA = teste.getInt("hora");
            int testeDATA = teste.getInt("data");
            String testeDESCRICAO = teste.getString("descricao");
            int testeTURMA = teste.getInt("turma");
            int testeDISCIPLINA = teste.getInt("disciplina");

            Teste auxTeste = new Teste(testeID,testeDATA,testeHORA,testeDESCRICAO,testeTURMA,testeDISCIPLINA);


        }
        catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return tempTeste;
    }

    public static boolean isConnectionInternet(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
