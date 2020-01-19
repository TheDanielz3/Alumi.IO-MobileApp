package com.example.alumiio.models;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.alumiio.listeners.AlunoListener;
import com.example.alumiio.listeners.DisciplinaTurmaListener;
import com.example.alumiio.listeners.ProfessorListener;
import com.example.alumiio.listeners.RecadoListener;
import com.example.alumiio.listeners.TesteListener;
import com.example.alumiio.listeners.TpcListener;
import com.example.alumiio.listeners.TurmaListener;
import com.example.alumiio.utils.AlunoJsonParser;
import com.example.alumiio.utils.DisciplinaTurmaJsonParser;
import com.example.alumiio.utils.RecadoJsonParser;
import com.example.alumiio.utils.TesteJsonParser;
import com.example.alumiio.utils.TpcJsonParser;
import com.example.alumiio.utils.TurmaJsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class AlumioSingleton {

    //Acesso base de dados
    private static final int ADD_DB = 1;
    private static final int EDIT_DB = 2;
    private static final int REMOVE_DB = 3;
    private static AlumioSingleton INSTANCE = null; // para garantir que é unica
    private AlumioBDHelper alumioBDHelper;

    //Instanciar ArraysLists dos modelos
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professors;
    private ArrayList<Recado> recados;
    private ArrayList<Tpc> tpcs;
    private ArrayList<Teste> testes;
    private ArrayList<Turma> turmas;
    private ArrayList<Disciplina_Turma> disciplinaTurmas;


    //Acesso API
    private static RequestQueue volleyQueue = null;
    private static String IP_API = "192.168.1.20"; // Colocar Aqui o IP da Máquina
    private String URL_ALUNOS = "http://" + IP_API + "/Alumi.IO-WebApp/api/web/v1/aluno";
    private String URL_DISCIPLINA_TURMAS = "http://" + IP_API + "/Alumi.IO-WebApp/api/web/v1/disciplinaturma";
    private String URL_RECADOS = "http://" + IP_API + "/Alumi.IO-WebApp/api/web/v1/recado";
    private String URL_TESTES = "http://" + IP_API + "/Alumi.IO-WebApp/api/web/v1/teste";
    private String URL_TPCS = "http://" + IP_API + "/Alumi.IO-WebApp/api/web/v1/tpc";
    private String URL_TURMAS = "http://" + IP_API + "/Alumi.IO-WebApp/api/web/v1/turma";

    private String URL_LOGIN_CHECK = "http://" + IP_API + "/Alumi.IO-WebApp/api/web/v1/disciplinaturma/turmaspessoais";
    private String tokenAPI = "AMSI-TOKEN"; //Adicionar o token aqui

    private ProfessorListener professorListener;
    private AlunoListener alunoListener;
    private RecadoListener recadoListener;
    private TpcListener tpcListener;
    private TesteListener testeListener;
    private TurmaListener turmaListener;
    private DisciplinaTurmaListener disciplinaTurmaListener;

    private AlumioSingleton(Context context) {
        alunos = new ArrayList<>();
        professors = new ArrayList<>();
        recados = new ArrayList<>();
        tpcs = new ArrayList<>();
        alumioBDHelper = new AlumioBDHelper(context);
    }


    //Funcao para ir buscar a Instancia
    public static synchronized AlumioSingleton getInstance(Context context) {
        if (INSTANCE == null)
        {
            INSTANCE = new AlumioSingleton(context);
            //volleyQueue = Volley.newRequestQueue(context);
        }

        return INSTANCE;
    }



    public void setAlunoListener(AlunoListener alunoListener) { this.alunoListener = alunoListener; }

    public void setProfessorListener(ProfessorListener professorListener) { this.professorListener = professorListener;}

    public void setRecadoListener(RecadoListener recadoListener){ this.recadoListener = recadoListener; }

    public void setTpcListener(TpcListener tpcListener) { this.tpcListener = tpcListener; }

    public void setTesteListener(TesteListener testeListener) { this.testeListener = testeListener; }

    public void setTurmaListener(TurmaListener turmaListener) {this.turmaListener = turmaListener; }

    public void setDisciplinaTurmaListener(DisciplinaTurmaListener disciplinaTurmaListener) {this.disciplinaTurmaListener = disciplinaTurmaListener; }

    public ArrayList<Aluno> getAlunosBD()
    {
        alunos = alumioBDHelper.getAllAlunosDB();
        return alunos;
    }

    public ArrayList<Recado> getRecadosBD()
    {
        recados = alumioBDHelper.getAllRecadosDB();
        return recados;
    }

    public ArrayList<Tpc> getTpcsBD()
    {
        tpcs = alumioBDHelper.getALLTpcDB();
        return tpcs;
    }
    public ArrayList<Teste> getTestesBD()
    {
        testes = alumioBDHelper.getAllTestesDB();
        return testes;
    }

    public ArrayList<Turma> getTurmasBD()
    {
        turmas = alumioBDHelper.getAllTurmasDB();
        return turmas;
    }

    public ArrayList<Disciplina_Turma> getDisciplinaTurmasBD()
    {
        disciplinaTurmas = alumioBDHelper.getAllDisciplinaTurmasDB();
        return disciplinaTurmas;
    }


    public Aluno getAlunoById(long id)
    {
        for(Aluno aluno: alunos)
        {
            if (aluno.getId() == id)
            {
                return aluno;
            }
        }

        return null;
    }

    public Recado getRecadoById(long id)
    {
        for(Recado recado: recados)
        {
            if (recado.getId() == id)
            {
                return recado;
            }
        }

        return null;
    }

    public Tpc getTpcById(long id)
    {
        for (Tpc tpc: tpcs)
        {
            if (tpc.getId() == id)
            {
                return tpc;
            }
        }
        return null;
    }

    public Teste getTesteById(long id)
    {
        for (Teste teste: testes)
        {
            if (teste.getId() == id)
            {
                return teste;
            }
        }
        return null;
    }
    public Turma getTurmaById(long id)
    {
        for (Turma turma:turmas)
        {
            if (turma.getId() == id)
            {
                return  turma;
            }
        }
        return null;
    }

    public Disciplina_Turma getDisciplinaTurmaById(long id)
    {
        for (Disciplina_Turma disciplinaTurma:disciplinaTurmas)
        {
            if (disciplinaTurma.getId() == id)
            {
                return  disciplinaTurma;
            }
        }
        return null;
    }

    public long addAlunoDB (Aluno aluno)
    {
         return alumioBDHelper.addAlunoToDB(aluno);
    }

    public long addRecadoDB (Recado recado)
    {
       return alumioBDHelper.addRecadoToDB(recado);
    }

    public long addTesteDB (Teste teste)
    {
       return alumioBDHelper.addTesteToDB(teste);
    }

    public long addTpcDB (Tpc tpc)
    {
      return   alumioBDHelper.addTpcToDB(tpc);
    }
    public void addTurmaDB(Turma turma)
    {
        alumioBDHelper.addTurmaToDB(turma);
    }
    public void addDisciplinaTurmaDB(Disciplina_Turma disciplinaTurma)
    {
        alumioBDHelper.addDisciplinaTurmaToDB(disciplinaTurma);
    }

    public void removeAlunoDB(long alunoId)
    {
        if(alumioBDHelper.deleteAlunoDB(alunoId))
        {
            Aluno aluno = getAlunoById(alunoId);
            alunos.remove(aluno);
        }
    }

    public void removeRecadoDB (long recadoId)
    {
        if(alumioBDHelper.deleteRecadoDB(recadoId))
        {
            Recado recado = getRecadoById(recadoId);
            recados.remove(recado);
        }
    }
    public void removeTesteDB(long testeId)
    {
        if(alumioBDHelper.deleteTesteDB(testeId))
        {
            Teste teste = getTesteById(testeId);
            testes.remove(teste);
        }
    }
    public void removeTpcDB(long tpcId)
    {
        if(alumioBDHelper.deleteTpcDB(tpcId))
        {
            Tpc tpc = getTpcById(tpcId);
            tpcs.remove(tpc);
        }
    }

    public void removeDisciplinaTurmaDB(long disciplinaTurmaId)
    {
        if(alumioBDHelper.deleteDisciplinaTurmaDB(disciplinaTurmaId))
        {
            Disciplina_Turma disciplinaTurma = getDisciplinaTurmaById(disciplinaTurmaId);
            disciplinaTurmas.remove(disciplinaTurma);
        }
    }


//    public void removeDisciplinaTurmaDB(long disciplinaTurmaId)
//    {
//        if(alumioBDHelper.deleteDisciplinaTurmaDB(disciplinaTurmaId))
//        {
//            Disciplina_Turma disciplinaTurma = getDisciplinaTurmaById(disciplinaTurmaId);
//            disciplinaTurmas.remove(disciplinaTurma);
//        }
//    }
    public void editAlunoDB(Aluno aluno){
        if (alunos.contains(aluno))
        {
            return;
        }

        Aluno auxAluno = getAlunoById(aluno.getId());
        auxAluno.setNome(aluno.getNome());
        auxAluno.setNumeroDeEstudante(aluno.getNumeroDeEstudante());

        alumioBDHelper.updateAlunoDB(auxAluno);
    }

    public void editRecadoDB(Recado recado){
        if (recados.contains(recado))
        {
            return;
        }

        Recado auxRecado = getRecadoById(recado.getId());
        auxRecado.setDescricao(recado.getDescricao());
        auxRecado.setAssinado(recado.getAssinado());

        alumioBDHelper.updateRecadoDB(auxRecado);
    }
    public void editTpcDB(Tpc tpc) {
        if (tpcs.contains(tpc))
        {
            return;
        }

        Tpc auxTpc  = getTpcById(tpc.getId());
        auxTpc.setDescricao(tpc.getDescricao());
        auxTpc.setId_disciplina_turma(tpc.getId_disciplina_turma());
        auxTpc.setId_professor(tpc.getId_professor());

        alumioBDHelper.updateTpcDB(auxTpc);
    }

    public void editDisciplinaTurmaDB(Disciplina_Turma disciplinaTurma){
        if (!disciplinaTurmas.contains(disciplinaTurma))
        {
            return;
        }

        Disciplina_Turma auxDisciplinaTurma = getDisciplinaTurmaById(disciplinaTurma.getId());
        auxDisciplinaTurma.setId_disciplina(disciplinaTurma.getId_disciplina());
        auxDisciplinaTurma.setId_turma(disciplinaTurma.getId_turma());
        auxDisciplinaTurma.setId_professor(disciplinaTurma.getId_professor());

        alumioBDHelper.updateDisciplinaTurmaDB(auxDisciplinaTurma);
    }

    public void removeAllDisciplinaTurmasDB() {
        alumioBDHelper.deleteAllDisciplinaTurmaDB();
        try {
            disciplinaTurmas.clear();
        }catch (Exception ignored){}
    }

    public void removeAllTurmasDB() {
        alumioBDHelper.deleteAllTurmaDB();
        try {
            turmas.clear();
        }catch (Exception ignored){}
    }

    public void removeAllAlunosDB() {
        alumioBDHelper.deleteAllAlunosDB();
        try {
            alunos.clear();
        }catch (Exception ignored){}
    }

    public void removeAllRecadosDB() {
        alumioBDHelper.deleteAllRecadosDB();
        try {
            recados.clear();
        }catch (Exception ignored){}
    }

    public void removeAllTestesDB() {
        alumioBDHelper.deleteAllTestesDB();
        try {
            testes.clear();
        }catch (Exception ignored){}
    }

    public void removeAllTpcsDB() {
        alumioBDHelper.deleteAllTpcDB();
        try {
            tpcs.clear();
        }catch (Exception ignored){}
    }

    //TODO: Acabar a parte da API

    public void getAllAlunosAPI(final String username, final String password, final Context context, final boolean isConnected) {

        Log.i("Username: ",username);
        Log.i("Password: ",password);

        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.GET, URL_ALUNOS, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("On Response: ", response.toString());
                    if (!response.toString().equals("[]")){
                        ArrayList<Aluno> alunos = AlunoJsonParser.parserJsonAlunos(response, context);
                        for (Aluno aluno : alunos) {
                            addAlunoDB(aluno);
                        }
                    }else{
                        Toast.makeText(context, "Haha, vazio", Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error: ", error.toString());
                    Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                //            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer " + "professorToken");
//                return params;
//            }
                @Override
                public Map<String, String> getHeaders(){
                    String credentials = username + ":" + password;
                    String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.DEFAULT);
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Basic " + base64EncodedCredentials);
                    return headers;
                }
            };
            volleyQueue = Volley.newRequestQueue(context);
            volleyQueue.add(request);

        }
    }

    public void getAllDisciplinaTurmasAPI(final String username, final String password, final Context context, final boolean isConnected) {

        Log.i("Username: ",username);
        Log.i("Password: ",password);

        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.GET, URL_DISCIPLINA_TURMAS, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("On Response: ", response.toString());
                    if (!response.toString().equals("[]")){
                        ArrayList<Disciplina_Turma> disciplina_turmas = DisciplinaTurmaJsonParser.parserJsonDisciplinaTurma(response, context);
                        for (Disciplina_Turma disciplinaTurma : disciplina_turmas) {
                            addDisciplinaTurmaDB(disciplinaTurma);
                        }
                    }else{
                        Toast.makeText(context, "Haha, vazio", Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error: ", error.toString());
                    Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                //            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer " + "professorToken");
//                return params;
//            }
                @Override
                public Map<String, String> getHeaders(){
                    String credentials = username + ":" + password;
                    String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.DEFAULT);
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Basic " + base64EncodedCredentials);
                    return headers;
                }
            };
            volleyQueue = Volley.newRequestQueue(context);
            volleyQueue.add(request);

        }
    }

    public void getAllRecadosAPI(final String username, final String password, final Context context, final boolean isConnected) {
        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.GET, URL_RECADOS, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("On Response: ", response.toString());
                    ArrayList<Recado> recados = RecadoJsonParser.parserJsonRecados(response, context);
                    for (Recado recado : recados) {
                        addRecadoDB(recado);
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("Error: ", error.toString());
                    Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                //            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer " + "professorToken");
//                return params;
//            }
                @Override
                public Map<String, String> getHeaders(){
                    String credentials = username + ":" + password;
                    String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.DEFAULT);
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Basic " + base64EncodedCredentials);
                    return headers;
                }
            };
            volleyQueue = Volley.newRequestQueue(context);
            volleyQueue.add(request);
        }
    }

    public void getAllTestesAPI(final String username, final String password, final Context context, final boolean isConnected) {
        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.GET, URL_TESTES, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("On Response: ", response.toString());
                    ArrayList<Teste> testes = TesteJsonParser.parserJsonTestes(response, context);
                    for (Teste teste : testes) {
                        addTesteDB(teste);
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("Error: ", error.toString());
                    Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                //            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer " + "professorToken");
//                return params;
//            }
                @Override
                public Map<String, String> getHeaders(){
                    String credentials = username + ":" + password;
                    String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.DEFAULT);
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Basic " + base64EncodedCredentials);
                    return headers;
                }
            };
            volleyQueue = Volley.newRequestQueue(context);
            volleyQueue.add(request);
        }
    }

    public void getAllTpcsAPI(final String username, final String password, final Context context, final boolean isConnected) {
        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.GET, URL_TPCS, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("On Response: ", response.toString());
                    ArrayList<Tpc> tpcs = TpcJsonParser.parserJsonTpcs(response, context);
                    for (Tpc tpc  : tpcs) {
                        addTpcDB(tpc);
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("Error: ", error.toString());
                    Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                //            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer " + "professorToken");
//                return params;
//            }
                @Override
                public Map<String, String> getHeaders(){
                    String credentials = username + ":" + password;
                    String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.DEFAULT);
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Basic " + base64EncodedCredentials);
                    return headers;
                }
            };
            volleyQueue = Volley.newRequestQueue(context);
            volleyQueue.add(request);
        }
    }

    // TODO: Fix
    public void getAllTurmasAPI(final String username, final String password, final Context context, final boolean isConnected) {
        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.GET, URL_TURMAS, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("On Response: ", response.toString());
                    ArrayList<Turma> turmas = TurmaJsonParser.parserJsonTurmas(response, context);
                    for (Turma turma : turmas) {
                        addTurmaDB(turma);
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("Error: ", error.toString());
                    Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                //            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer " + "professorToken");
//                return params;
//            }
                @Override
                public Map<String, String> getHeaders(){
                    String credentials = username + ":" + password;
                    String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.DEFAULT);
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Basic " + base64EncodedCredentials);
                    return headers;
                }
            };
            volleyQueue = Volley.newRequestQueue(context);
            volleyQueue.add(request);
        }
    }



    public void loginWithAPI(final String username, final String password, final Context context, final boolean isConnected) {

        Log.i("Username: ",username);
        Log.i("Password: ",password);

        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.GET, URL_LOGIN_CHECK, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("On Response: ", response.toString());
                    if (!response.toString().equals("[]")){
                        context.getSharedPreferences("LoggedInUser", MODE_PRIVATE).edit().putString("username", username).apply();
                        context.getSharedPreferences("LoggedInUser", MODE_PRIVATE).edit().putString("password", password).apply();
                    }else{
                        Toast.makeText(context, "Esta conta não pode fazer login.", Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error: ", error.toString());
                    Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                //            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer " + "professorToken");
//                return params;
//            }
                @Override
                public Map<String, String> getHeaders(){
                    String credentials = username + ":" + password;
                    String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.DEFAULT);
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Basic " + base64EncodedCredentials);
                    return headers;
                }
            };
            volleyQueue = Volley.newRequestQueue(context);
            volleyQueue.add(request);

        }
    }


}
