package com.example.alumiio.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Tpc;

public class CreateTpcActivity extends AppCompatActivity {

    private TextView textViewDescricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tpc);

        textViewDescricao = findViewById(R.id.editTextDescricaoTPC);

    }


    //Todo:Fazer Proteções
    public void SubmeterTPConCLick(View view) {

        Tpc tpc = new Tpc(1,textViewDescricao.getText().toString());
        AlumioSingleton.getInstance(getApplicationContext()).addTpcDB(tpc);
        finish();
    }
}
