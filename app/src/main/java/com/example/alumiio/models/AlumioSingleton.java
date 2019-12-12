package com.example.alumiio.models;

import android.content.Context;

import com.example.alumiio.listeners.ProfessorListener;

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


    //Acesso API
//    private static RequestQueue volleyQueue = null;
//    private String myURLAPILIVROS = "http://amsi.dei.estg.ipleiria.pt/api/livros";
//    private String tokenAPI = "AMSI-TOKEN";

    private ProfessorListener professorListener;

    private AlumioSingleton(Context context) {
        alunos = new ArrayList<>();
        professors = new ArrayList<>();
        recados = new ArrayList<>();
        tpcs = new ArrayList<>();
        alumioBDHelper = new AlumioBDHelper(context);
        //generateFakeData();
    }
    public void setProfessorListener(ProfessorListener ProfessorListener) {
        this.professorListener = ProfessorListener;
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


}
