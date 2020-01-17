package com.example.alumiio.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Teste;

public class CreateTesteActivity extends AppCompatActivity {

    EditText editTextdescricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_teste);

        editTextdescricao = findViewById(R.id.editTextDescricaoTeste);
    }

    public void criarTesteonClick(View view) {

        Teste teste = new Teste(editTextdescricao.getText().toString(),222,2,2);

        long id = AlumioSingleton.getInstance(getApplicationContext()).addTesteDB(teste);
        teste.setId(id);
        finish();
    }
}
