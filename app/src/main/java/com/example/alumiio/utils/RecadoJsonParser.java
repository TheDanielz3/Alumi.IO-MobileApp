package com.example.alumiio.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.alumiio.models.Recado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecadoJsonParser {

    public static ArrayList<Recado> parserJsonRecados(JSONArray response, Context context)
    {
        ArrayList<Recado> tempRecadoList = new ArrayList<>();

        try {
            for (int i = 0; i < response.length(); i++)
            {


                JSONObject recado = (JSONObject) response.get(i);
                int recadoID = recado.getInt("id");
                String recadoDESCRICAO = recado.getString("descricao");
                int recadoASSINADO = recado.getInt("assinado");

                Recado auxRecado = new Recado(recadoID,recadoDESCRICAO,recadoASSINADO);

                tempRecadoList.add(auxRecado);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context,"Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
        }

        return tempRecadoList;

    }
    public static Recado parserJsonRecado(String response, Context context)
    {
        Recado tempRecado = null;

        try {
            JSONObject recado = new JSONObject(response);
            int recadoID = recado.getInt("id");
            String recadoDESCRICAO = recado.getString("descricao");
            int recadoASSINADO = recado.getInt("assinado");

            Recado auxRecado = new Recado(recadoID,recadoDESCRICAO,recadoASSINADO);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
        }

        return tempRecado;
    }
    public static boolean isConnectionInternet(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
