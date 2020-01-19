package com.example.alumiio.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alumiio.R;
import com.example.alumiio.adapters.TpcAdapter;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Tpc;

public class ViewDetailsTpcActivity extends AppCompatActivity {

    private long id;


    TpcAdapter tpcAdapter;
    private EditText editText;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details_tpc);

         id = getIntent().getLongExtra("ID_DO_TPC",0);

       Tpc auxTpc = AlumioSingleton.getInstance(getApplicationContext()).getTpcById(id);

        editText = findViewById(R.id.editTextDescricaoTPC);

        spinner = findViewById(R.id.spinnerDisciplinaTurmaDetais);

        editText.setText(auxTpc.getDescricao());

    }

    public void editarOnClick(View view) {

        Tpc tpc = new Tpc(editText.getText().toString(),1,1);
        tpc.setId(id);
        AlumioSingleton.getInstance(getApplicationContext()).editTpcDB(tpc);
        finish();


    }

    public void eliminarOnClick(View view) {

        AlumioSingleton.getInstance(getApplicationContext()).removeTpcDB(id);
        finish();

    }
}
