package com.example.alumiio.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alumiio.R;
import com.example.alumiio.models.Recado;

public class CreateRecadoActivity extends AppCompatActivity {

    private EditText editTextTopico;
    private EditText editTextDescricao;
    private Spinner spinnerAluno;
    private Spinner spinnerTurma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recado);

        editTextDescricao = findViewById(R.id.editTextDescricao);
        editTextTopico = findViewById(R.id.editTextTopico);

        spinnerAluno = findViewById(R.id.spinnerAlunos);
        spinnerTurma = findViewById(R.id.spinnerDisciplinaTurma);



    }

    public void SubmeterRecadoClick(View view) {
    System.out.println("--> Butao em criar recado");
    Recado recado = new Recado(0,editTextTopico.getText().toString(), editTextDescricao.getText().toString(),0,123,321,951,159);


    System.out.println("--> Recado: " + recado.getDescricao());
    }
}
