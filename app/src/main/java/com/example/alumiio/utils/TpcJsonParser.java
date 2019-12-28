package com.example.alumiio.utils;

import android.content.Context;
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

            }

        }catch (JSONException e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return tempTpc;
    }
}
