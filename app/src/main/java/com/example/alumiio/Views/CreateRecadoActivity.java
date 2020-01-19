package com.example.alumiio.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alumiio.R;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Aluno;
import com.example.alumiio.models.Recado;

import java.util.ArrayList;
import java.util.Objects;

public class CreateRecadoActivity extends AppCompatActivity {

    private EditText editTextTopico;
    private EditText editTextDescricao;
    private Spinner spinnerAluno;
    private Spinner spinnerTurma;

    ArrayAdapter<Aluno> alunoArrayAdapter;

    private ArrayList<Aluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recado);

        alunos = AlumioSingleton.getInstance(getApplicationContext()).getAlunosBD();

        editTextDescricao = findViewById(R.id.editTextDescricao);
        editTextTopico = findViewById(R.id.editTextTopico);

        spinnerAluno = findViewById(R.id.spinnerAlunos);
        spinnerTurma = findViewById(R.id.spinnerDisciplinaTurma);


        alunoArrayAdapter = new ArrayAdapter<Aluno>(this,R.layout.support_simple_spinner_dropdown_item,alunos);

        alunoArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinnerAluno.setAdapter(alunoArrayAdapter);

    }

    public void SubmeterRecadoClick(View view) {
    System.out.println("--> Butao em criar recado");
    Recado recado = new Recado(editTextTopico.getText().toString(), editTextDescricao.getText().toString(),0,123,321,951,159);
    System.out.println("--> Recado: " + recado.getDescricao());
       long id = AlumioSingleton.getInstance(getApplicationContext()).addRecadoDB(recado);
       recado.setId(id);
       finish();
    }
}
