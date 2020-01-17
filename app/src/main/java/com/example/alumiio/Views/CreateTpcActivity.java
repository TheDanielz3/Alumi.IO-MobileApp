package com.example.alumiio.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Aluno;
import com.example.alumiio.models.Tpc;
import com.example.alumiio.models.Turma;

import java.util.ArrayList;
import java.util.List;

public class CreateTpcActivity extends AppCompatActivity {

    String[] data = {"sou algo",
            "Sou nada",
            "Sou uma algo",
    };


    private TextView textViewDescricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tpc);

        textViewDescricao = findViewById(R.id.editTextDescricaoTPC);


        //TODO: Addicionar o foreach para dar populate no spinner
//        List<String> spinnerArray =  new ArrayList<String>();
//        spinnerArray.add("item1");
//        spinnerArray.add("item2");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_spinner_item, spinnerArray);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Spinner sItems = (Spinner) findViewById(R.id.spinnerDisciplinaTurma);
//        sItems.setAdapter(adapter);


        String[] data= {"Grid view","chart view"};
        Spinner spinner = (Spinner) findViewById(R.id.spinnerDisciplinaTurma);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,data);

        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    //Todo:Fazer Proteções
    public void SubmeterTPConCLick(View view) {

        Tpc tpc = new Tpc(textViewDescricao.getText().toString(),123,321);
       long id = AlumioSingleton.getInstance(getApplicationContext()).addTpcDB(tpc);
       tpc.setId(id);
        //finish();
    }
}
