package com.example.alumiio.utils;

import android.content.Context;
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
            }

        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();

        }

        return tempTeste;
    }
}
