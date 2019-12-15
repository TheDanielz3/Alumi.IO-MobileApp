package com.example.alumiio.models;

import android.content.Context;

import com.example.alumiio.listeners.AlunoListener;
import com.example.alumiio.listeners.ProfessorListener;
import com.example.alumiio.listeners.RecadoListener;
import com.example.alumiio.listeners.TesteListener;
import com.example.alumiio.listeners.TpcListener;

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


    //Acesso API
//    private static RequestQueue volleyQueue = null;
//    private String myURLAPILIVROS = "http://amsi.dei.estg.ipleiria.pt/api/livros";
//    private String tokenAPI = "AMSI-TOKEN";

    private ProfessorListener professorListener;
    private AlunoListener alunoListener;
    private RecadoListener recadoListener;
    private TpcListener tpcListener;
    private TesteListener testeListener;

    private AlumioSingleton(Context context) {
        alunos = new ArrayList<>();
        professors = new ArrayList<>();
        recados = new ArrayList<>();
        tpcs = new ArrayList<>();
        alumioBDHelper = new AlumioBDHelper(context);
        //generateFakeData();
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

    public void addAlunoDB (Aluno aluno)
    {
        // add to DB
        alumioBDHelper.addAlunoToDB(aluno);
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
}
