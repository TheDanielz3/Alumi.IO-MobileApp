package com.example.alumiio.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.alumiio.R;
import com.example.alumiio.Views.ui.turmaactivity2.TurmaActivity2Fragment;

public class TurmaActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turma_activity2_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, TurmaActivity2Fragment.newInstance())
                    .commitNow();
        }
    }
}
