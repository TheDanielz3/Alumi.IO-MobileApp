package com.example.alumiio.Views;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
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
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Authenticator;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.alumiio.R;
import com.example.alumiio.models.AlumioBDHelper;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Aluno;
import com.example.alumiio.models.Turma;
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

        AlumioSingleton.getInstance(getApplicationContext()).getAllRecados("prof1", "123456", getApplicationContext(), RecadoJsonParser.isConnectionInternet(getApplicationContext()));

        EditText editName = (EditText) findViewById(R.id.editText);
        EditText editPassword = (EditText) findViewById(R.id.editText2);

        SharedPreferences prefs = getSharedPreferences("userLogedIn", MODE_PRIVATE);
        editName.setText(prefs.getString("username", ""));
        editPassword.setText(prefs.getString("password", ""));

        if ((!TextUtils.isEmpty(editName.getText())) && (!TextUtils.isEmpty(editPassword.getText()))) {
            Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(myIntent);
        }


    }

    public void onButtonClick(View v) {
        Aluno aluno = new Aluno(1, 12, "nome", 232323);
        long id_a_meter = AlumioSingleton.getInstance(getApplicationContext()).addAlunoDB(aluno);
        aluno.setId(id_a_meter);

        Turma turma = new Turma(2, "L");
        AlumioSingleton.getInstance(getApplicationContext()).addTurmaDB(turma);

        EditText editName = (EditText) findViewById(R.id.editText);
        String name = editName.getText().toString();

        EditText editPassword = (EditText) findViewById(R.id.editText2);
        String password = editName.getText().toString();


        SharedPreferences.Editor editor = getSharedPreferences("userLogedIn", MODE_PRIVATE).edit();
        editor.putString("username", name);
        editor.putString("password", password);
        editor.apply();

//        aluno.setId(id);
//        System.out.println("--> Add Aluno: " + id);


//        aluno = new Aluno(2,"daniel1",1233214);
//        long id1 = AlumioSingleton.getInstance(getApplicationContext()).addAlunoDB(aluno);
//        aluno.setId(id1);
//        System.out.println("--> Add Aluno: " + id1);
//
//        System.out.println("--> Click on Button on Login Activity called Login");
        Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(myIntent);
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
