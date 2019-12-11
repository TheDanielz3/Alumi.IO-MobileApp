package com.example.alumiio.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlumioBDHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "AlumioDB";
    private static final String TABLE_ALUNO = "aluno";
    private static final String TABLE_TPC = "tpc";
    private static final String TABLE_RECADO = "recado";
    private static final String TABLE_TESTE = "teste";
    private static final int DB_VERSION = 1;

    private static final String ALUNO_ID = "id";
    private static final String TPC_ID = "id";
    private static final String RECADO_ID = "id";
    private static final String TESTE_ID = "id";

    private static final String ALUNO_NOME = "nome";
    private static final String ALUNO_NUM = "numero_estudante";

    private static final String TPC_DESCRICAO = "descricao";

    private static final String RECADO_DESCRICAO = "descricao";
    private static final String RECADO_ASSINADO = "assinado";

    private static final String TESTE_DATA = "data";
    private static final String TESTE_DISCIPLINA = "disciplina";
    private static final String TESTE_HORA = "hora";
    private static final String TESTE_TURMA = "turma";

    private final SQLiteDatabase database;

    public AlumioBDHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        this.database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating table Aluno
        String createAlunoTable = "CREATE TABLE " + TABLE_ALUNO + "" +
                "("
                + ALUNO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ALUNO_NUM + " INTEGER NOT NULL, "
                + ALUNO_NOME + " TEXT NOT NULL "
                + ");";

        db.execSQL(createAlunoTable);
        System.out.println("-->  DB: Table created Aluno");



        //Creating table TPC
        String createTpcTable = "CREATE TABLE " + TABLE_TPC + "" +
                "("
                + TPC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TPC_DESCRICAO + "TEXT NOT NULL"
                + ");";

        db.execSQL(createTpcTable);
        System.out.println("-->  DB: Table created Tpc");



        //Creating table Recado
        String createRecadoTable = "CREATE TABLE " + TABLE_RECADO + "" +
                "("
                + RECADO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RECADO_DESCRICAO + " TEXT NOT NULL,"
                + RECADO_ASSINADO + " INTEGER NOT NULL "
                + ");";

        db.execSQL(createRecadoTable);
        System.out.println("-->  DB: Table created Recado");



        //Creating table Teste
        //TODO: Acabar isto
        String createTesteTable ="CREATE TABLE " + TABLE_TESTE + "" +
                "("
                + TESTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TESTE_DISCIPLINA + "INTEGER NOT NUll"
                + ");";
        db.execSQL(createTesteTable);
        System.out.println("-->  DB: Table created Teste");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
