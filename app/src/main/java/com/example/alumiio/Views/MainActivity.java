package com.example.alumiio.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alumiio.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {
        Intent myIntent = new Intent(getBaseContext(), TurmaActivity.class);
        startActivity(myIntent);
    }
}
