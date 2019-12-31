package com.example.alumiio.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alumiio.R;

import androidx.appcompat.app.AppCompatActivity;

public class TurmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turma);
    }

    public void alunoclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), AlunosActivity.class);
        startActivity(myIntent);
    }

    public void recadosclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), RecadosActivity.class);
        startActivity(myIntent);
    }

    public void tpcclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), TpcActivity.class);
        startActivity(myIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("--> Activity Turma on Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("--> Activity Turma on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("--> Activity Turma on Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("--> Activity Turma on Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("--> Activity Turma on Resume");
    }
}
