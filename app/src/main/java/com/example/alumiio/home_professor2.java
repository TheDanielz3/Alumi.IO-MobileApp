package com.example.alumiio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class home_professor2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_professor2);
    }

    public void alunoclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), ver_alunos.class);
        startActivity(myIntent);
    }

    public void recadosclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), ver_recados.class);
        startActivity(myIntent);
    }

    public void tpcclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), ver_tpc.class);
        startActivity(myIntent);
    }
}
