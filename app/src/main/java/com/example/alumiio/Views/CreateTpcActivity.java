package com.example.alumiio.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Aluno;
import com.example.alumiio.models.Disciplina_Turma;
import com.example.alumiio.models.Tpc;
import com.example.alumiio.models.Turma;
import com.example.alumiio.utils.RecadoJsonParser;

import java.util.ArrayList;
import java.util.List;

public class CreateTpcActivity extends AppCompatActivity {

    String[] data = {"sou algo",
            "Sou nada",
            "Sou uma algo",
    };

    private TextView textViewDescricao;

    private ArrayList<Disciplina_Turma> disciplina_turmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tpc);

        textViewDescricao = findViewById(R.id.editTextDescricaoTPC);

        disciplina_turmas = AlumioSingleton.getInstance(getApplicationContext()).getDisciplinaTurmasBD();

        ArrayAdapter<Disciplina_Turma> adapter = new ArrayAdapter<Disciplina_Turma>(
                this, android.R.layout.simple_spinner_item, disciplina_turmas);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinnerDisciplinaTurma);
        sItems.setAdapter(adapter);


        // Spinner spinner = (Spinner) findViewById(R.id.spinnerDisciplinaTurma);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,data);

        //    spinner.setAdapter(adapter);
        //    adapter.notifyDataSetChanged();
    }


    //Todo:Fazer Proteções
    public void SubmeterTPConCLick(View view) {
        SharedPreferences prefs = getSharedPreferences("LoggedInUser", MODE_PRIVATE);

        Tpc tpc = new Tpc(textViewDescricao.getText().toString(), 1, 321);
        long id = AlumioSingleton.getInstance(getApplicationContext()).addTpcDB(tpc);

        AlumioSingleton.getInstance(getApplicationContext()).postTpcAPI(
                prefs.getString("username", "")
                , prefs.getString("password", "")
                , getApplicationContext(), RecadoJsonParser.isConnectionInternet(getApplicationContext())
                ,tpc.getDescricao()
                , String.valueOf(tpc.getId_disciplina_turma()));

        tpc.setId(id);
        finish();
    }
}
