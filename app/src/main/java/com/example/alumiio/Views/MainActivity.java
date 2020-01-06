package com.example.alumiio.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.alumiio.R;
import com.example.alumiio.models.Turma;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), TurmaActivity.class);
        startActivity(myIntent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("--> Activity Main on Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("--> Activity Main on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("--> Activity Main on Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("--> Activity Main on Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("--> Activity Main on Resume");
    }
}
