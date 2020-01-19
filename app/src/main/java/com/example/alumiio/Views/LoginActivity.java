package com.example.alumiio.Views;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Authenticator;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.alumiio.R;
import com.example.alumiio.models.AlumioBDHelper;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Aluno;
import com.example.alumiio.models.Disciplina_Turma;
import com.example.alumiio.models.Turma;
import com.example.alumiio.utils.AlunoJsonParser;
import com.example.alumiio.utils.DisciplinaTurmaJsonParser;
import com.example.alumiio.utils.RecadoJsonParser;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String URL = "http://192.168.1.20:80/Alumi.IO-WebApp/api/web/v1/recado";

        RequestQueue requestQueue = Volley.newRequestQueue(this );


        //codigo de login
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("REST RESPONSE", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("REST ERROR", error.toString());
            }
        });


        requestQueue.add(objectRequest);
        SharedPreferences prefsFirstTime = getSharedPreferences("FirstTime", MODE_PRIVATE);

        EditText editName = (EditText) findViewById(R.id.editText);
        EditText editPassword = (EditText) findViewById(R.id.editText2);

        SharedPreferences prefs = getSharedPreferences("LoggedInUser", MODE_PRIVATE);
        editName.setText(prefs.getString("username", ""));
        editPassword.setText(prefs.getString("password", ""));

        if ((!TextUtils.isEmpty(editName.getText())) && (!TextUtils.isEmpty(editPassword.getText()))) {
            if (prefsFirstTime.getString("DB", "").equals("")) {
                GetAllDBData();
            }
            Login();
        }

    }

    public void onButtonClick(View v) {
        Login();
    }

    private void GetAllDBData() {

        Disciplina_Turma disciplina_turma = new Disciplina_Turma(1,2,2,2);
        AlumioSingleton.getInstance(getApplicationContext()).addDisciplinaTurmaDB(disciplina_turma);

        EditText editName  = (EditText) findViewById(R.id.editText);
        String name = editName.getText().toString();
        EditText editName = (EditText) findViewById(R.id.editText);
        String username = editName.getText().toString();

        EditText editPassword = (EditText) findViewById(R.id.editText2);
        String password = editPassword.getText().toString();

        AlumioSingleton.getInstance(getApplicationContext()).removeAllAlunosDB();
        AlumioSingleton.getInstance(getApplicationContext()).removeAllDisciplinaTurmasDB();
        AlumioSingleton.getInstance(getApplicationContext()).removeAllRecadosDB();
        AlumioSingleton.getInstance(getApplicationContext()).removeAllTestesDB();
        AlumioSingleton.getInstance(getApplicationContext()).removeAllTpcsDB();
        AlumioSingleton.getInstance(getApplicationContext()).removeAllTurmasDB();

        AlumioSingleton.getInstance(getApplicationContext()).getAllAlunosAPI(username, password, getApplicationContext(), AlunoJsonParser.isConnectionInternet(getApplicationContext()));
        AlumioSingleton.getInstance(getApplicationContext()).getAllDisciplinaTurmasAPI(username, password, getApplicationContext(), AlunoJsonParser.isConnectionInternet(getApplicationContext()));
        AlumioSingleton.getInstance(getApplicationContext()).getAllRecadosAPI(username, password, getApplicationContext(), RecadoJsonParser.isConnectionInternet(getApplicationContext()));
        AlumioSingleton.getInstance(getApplicationContext()).getAllTestesAPI(username, password, getApplicationContext(), RecadoJsonParser.isConnectionInternet(getApplicationContext()));
        AlumioSingleton.getInstance(getApplicationContext()).getAllTpcsAPI(username, password, getApplicationContext(), RecadoJsonParser.isConnectionInternet(getApplicationContext()));
        AlumioSingleton.getInstance(getApplicationContext()).getAllTurmasAPI(username, password, getApplicationContext(), RecadoJsonParser.isConnectionInternet(getApplicationContext()));

        getSharedPreferences("FirstTime", MODE_PRIVATE).edit().putString("DB", "Done").apply();
    }

    private void Login() {
        //Aluno aluno = new Aluno(1, 12, "nome", 232323);
        //long id_a_meter = AlumioSingleton.getInstance(getApplicationContext()).addAlunoDB(aluno);
        //aluno.setId(id_a_meter);

//        Turma turma = new Turma(2, "L");
//        AlumioSingleton.getInstance(getApplicationContext()).addTurmaDB(turma);

        EditText editName = (EditText) findViewById(R.id.editText);
        String username = editName.getText().toString();

        EditText editPassword = (EditText) findViewById(R.id.editText2);
        String password = editPassword.getText().toString();

        getSharedPreferences("LoggedInUser", MODE_PRIVATE).edit().putString("username", "").apply();
        getSharedPreferences("LoggedInUser", MODE_PRIVATE).edit().putString("password", "").apply();

        AlumioSingleton.getInstance(getApplicationContext()).loginWithAPI(username, password, getApplicationContext(), DisciplinaTurmaJsonParser.isConnectionInternet(getApplicationContext()));

        Handler handlerLogin = new Handler();
        handlerLogin.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs = getSharedPreferences("LoggedInUser", MODE_PRIVATE);
                if (!prefs.getString("username", "").equals("") && !prefs.getString("password", "").equals("")) {
                    SharedPreferences prefsFirstTime = getSharedPreferences("FirstTime", MODE_PRIVATE);
                    if (prefsFirstTime.getString("DB", "").equals("")) {
                        Toast.makeText(getApplicationContext(), "Carregado Dados", Toast.LENGTH_SHORT).show();
                        GetAllDBData();
                    }
                }

                //SharedPreferences prefs = getSharedPreferences("LoggedInUser", MODE_PRIVATE);
                if (!prefs.getString("username", "").equals("") && !prefs.getString("password", "").equals("")) {
                    Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(myIntent);
                }
            }
        }, 1500);

        System.out.println("--> Click on Button on Login Activity called Login");
        Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(myIntent);
//        aluno.setId(id);
//        System.out.println("--> Add Aluno: " + id);


//        aluno = new Aluno(2,"daniel1",1233214);
//        long id1 = AlumioSingleton.getInstance(getApplicationContext()).addAlunoDB(aluno);
//        aluno.setId(id1);
//        System.out.println("--> Add Aluno: " + id1);
//
//        System.out.println("--> Click on Button on Login Activity called Login");

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("--> Activity Login on Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("--> Activity Login on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("--> Activity Login on Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("--> Activity Login on Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("--> Activity Login on Resume");
    }
}
