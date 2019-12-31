package com.example.alumiio.Views;

import android.os.Bundle;

import com.example.alumiio.R;

import androidx.appcompat.app.AppCompatActivity;

public class AlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("--> Activity Alunos on Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("--> Activity Alunos on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("--> Activity Alunos on Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("--> Activity Alunos on Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("--> Activity Alunos on Resume");
    }
}
