package com.example.alumiio.models;

import java.util.ArrayList;

public class AlumioSingleton {

    //Ver isto
    private static final AlumioSingleton ourInstance = new AlumioSingleton();
    public static AlumioSingleton getInstance() {
        return ourInstance;
    }


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

    private AlumioSingleton() {




    }
}
