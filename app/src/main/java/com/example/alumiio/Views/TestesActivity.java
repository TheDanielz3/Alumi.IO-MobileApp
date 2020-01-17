package com.example.alumiio.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alumiio.R;

public class TestesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testes);
    }

    public void criarTesteClick(View view) {

        Intent myIntent = new Intent(getApplicationContext(),CreateTesteActivity.class);
        startActivity(myIntent);


    }
}
