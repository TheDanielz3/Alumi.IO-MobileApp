package com.example.alumiio.models;

import android.content.Context;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.alumiio.listeners.AlunoListener;
import com.example.alumiio.listeners.ProfessorListener;
import com.example.alumiio.listeners.RecadoListener;
import com.example.alumiio.listeners.TesteListener;
import com.example.alumiio.listeners.TpcListener;
import com.example.alumiio.listeners.TurmaListener;
import com.example.alumiio.utils.AlunoJsonParser;

import org.json.JSONArray;

import java.util.ArrayList;

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


    //Acesso API
    private static RequestQueue volleyQueue = null;
    private String myURLAPIALUNOS = "http://192.168.1.1/advanced/web"; //Por aqui o IP da maquina
    private String tokenAPI = "AMSI-TOKEN"; //Adicionar o token aqui

    private ProfessorListener professorListener;
    private AlunoListener alunoListener;
    private RecadoListener recadoListener;
    private TpcListener tpcListener;
    private TesteListener testeListener;
    private TurmaListener turmaListener;

    private AlumioSingleton(Context context) {
        alunos = new ArrayList<>();
        professors = new ArrayList<>();
        recados = new ArrayList<>();
        tpcs = new ArrayList<>();
        alumioBDHelper = new AlumioBDHelper(context);
        generatefakedata();
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

    private void generatefakedata()
    {
     addAlunoDB(new Aluno(1,"daniel",123312));
     addAlunoDB(new Aluno(2,"daniel",123312));
     addAlunoDB(new Aluno(3,"daniel",123312));
     addAlunoDB(new Aluno(4,"daniel",123312));
     addAlunoDB(new Aluno(5,"daniel",123312));
     addAlunoDB(new Aluno(6,"daniel",123312));
     addAlunoDB(new Aluno(7,"daniel",123312));

    }

    public void setAlunoListener(AlunoListener alunoListener) { this.alunoListener = alunoListener; }

    public void setProfessorListener(ProfessorListener professorListener) { this.professorListener = professorListener;}

    public void setRecadoListener(RecadoListener recadoListener){ this.recadoListener = recadoListener; }

    public void setTpcListener(TpcListener tpcListener) { this.tpcListener = tpcListener; }

    public void setTesteListener(TesteListener testeListener) { this.testeListener = testeListener; }

    public void setTurmaListener(TurmaListener turmaListener) {this.turmaListener = turmaListener; }

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

    public long addAlunoDB (Aluno aluno)
    {
        // add to DB
         return alumioBDHelper.addAlunoToDB(aluno);
    }

    public void addRecadoDB (Recado recado)
    {
        alumioBDHelper.addRecadoToDB(recado);
    }

    public void addTesteDB (Teste teste)
    {
        alumioBDHelper.addTesteToDB(teste);
    }

    public void addTpcDB (Tpc tpc)
    {
        alumioBDHelper.addTpcToDB(tpc);
    }
    public void addTurmaDB(Turma turma)
    {
        alumioBDHelper.addTurmaToDB(turma);
    }

    public void removeAlunoDB(long alunoId)
    {
        if(alumioBDHelper.deleteAlunoDB(alunoId))
        {
            Aluno aluno = getAlunoById(alunoId);
            alunos.remove(aluno);
        }
    }

    public void removeRecadoDB(long recadoId)
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

    public void editAlunoDB(Aluno aluno){
        if (!alunos.contains(aluno))
        {
            return;
        }

        Aluno auxAluno = getAlunoById(aluno.getId());
        auxAluno.setNome(aluno.getNome());
        auxAluno.setNumeroDeEstudante(aluno.getNumeroDeEstudante());

        alumioBDHelper.updateAlunoDB(auxAluno);
    }

    public void editRecadoDB(Recado recado){
        if (!recados.contains(recado))
        {
            return;
        }

        Recado auxRecado = getRecadoById(recado.getId());
        auxRecado.setDescricao(recado.getDescricao());
        auxRecado.setAssinado(recado.getAssinado());

        alumioBDHelper.updateRecadoDB(auxRecado);
    }

    //TODO: Acabar a parte da API

    public void getAllAlunosAPI(final Context context,boolean isConnected)
    {
        if(!isConnected)
        {
            //no access ->get books from DB
            alunos = alumioBDHelper.getAllAlunosDB();
            if (alunoListener != null){
                alunoListener.onRefreshAlunoList(alunos);
            }
            else {
                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, myURLAPIALUNOS, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        alunos = AlunoJsonParser.parserJsonAlunos(response, context);
                        System.out.println("--> Resposta:" + alunos);
                        //TODO: FAzer o metodo addAlunosDB
                        addAlunosDB(alunos);

                        if (alunoListener != null) {
                            alunoListener.onRefreshAlunoList(alunos);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("--> Error Get AllAlunosAPI "+ error.getMessage());
                    }
                });

                volleyQueue.add(request);
            }
        }
    }

    private void addAlunosDB(ArrayList<Aluno> alunos) {

    }


}
