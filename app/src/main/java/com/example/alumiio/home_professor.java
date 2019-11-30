package com.example.alumiio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class home_professor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_professor);
    }

    public void onclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), home_professor2.class);
        startActivity(myIntent);
    }
}
