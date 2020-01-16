package com.example.alumiio.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alumiio.R;

import androidx.appcompat.app.AppCompatActivity;

public class RecadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recados);
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("--> Activity Recados on Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("--> Activity Recados on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("--> Activity Recados on Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("--> Activity Recados on Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("--> Activity Recados on Resume");
    }

    public void criarRecadoClick(View view) {
        System.out.println("--> Clicar no butao de Criar");

        Intent myIntent = new Intent(getBaseContext(), CreateRecadoActivity.class);
        startActivity(myIntent);
    }
}
