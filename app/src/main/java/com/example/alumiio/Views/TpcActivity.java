package com.example.alumiio.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alumiio.R;
import com.example.alumiio.adapters.TpcAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class TpcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpc);
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("--> Activity tpc on Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("--> Activity tpc on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("--> Activity tpc on Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("--> Activity tpc on Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("--> Activity tpc on Resume");

    }

    public void criarTPCClick(View view) {

        Intent intent = new Intent(getApplicationContext(),CreateTpcActivity.class);

        startActivity(intent);
    }
}
