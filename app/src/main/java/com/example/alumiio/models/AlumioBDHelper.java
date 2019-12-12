package com.example.alumiio.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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
    private static final String TESTE_DESCRICAO = "descricao";

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
        String createTesteTable ="CREATE TABLE " + TABLE_TESTE + "" +
                "("
                + TESTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TESTE_DESCRICAO + "TEXT NOT NULL,"
                + TESTE_DISCIPLINA + "INTEGER NOT NUll,"
                + TESTE_DATA + "INTEGER NOT NULL,"
                + TESTE_HORA + "INTEGER NOT NULL,"
                + TESTE_TURMA + "INTEGER NOT NULL"
                + ");";
        db.execSQL(createTesteTable);
        System.out.println("-->  DB: Table created Teste");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TESTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECADO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TPC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALUNO);
        this.onCreate(db);
    }


    //ADDing all stuff

    public void addRecadoToDB(Recado recado)
    {
        ContentValues values = getValuesRecado(recado); // contentor de valores a manipular

        this.database.insert(TABLE_RECADO, null, values);
    }

    public void addTpcToDB(Tpc tpc)
    {
        ContentValues values = getValuesTpc(tpc);

        this.database.insert(TABLE_TPC, null,values);
    }

    public void addAlunoToDB(Aluno aluno)
    {
        ContentValues values = getValuesAluno(aluno);

        this.database.insert(TABLE_ALUNO,null,values);
    }

    public void addTesteToDB(Teste teste)
    {
        ContentValues values = getValuesTeste(teste);

        this.database.insert(TABLE_TESTE,null,values);
    }


    //Read
    public ArrayList<Tpc> getALLTpcDB()
    {
        ArrayList<Tpc> tpcs = new ArrayList<>(); // instanciada por isso nunca null

        //Busca por querry ha base de dados
        Cursor cursor = this.database.query(TABLE_TPC, new String[]{TPC_ID,TPC_DESCRICAO},
                null, null, null, null, null, null);
        if (cursor.moveToFirst()) { //saber se há algum
            do {
                Tpc auxTpc = new Tpc(cursor.getLong(0),cursor.getString(1));
                //auxTpc.setID(cursor.getLong(0)); // we receive id
                tpcs.add(auxTpc);
            } while (cursor.moveToNext());
        }
        return tpcs;
    }

    public ArrayList<Recado> getAllRecadosDB()
    {
        ArrayList<Recado> recados = new ArrayList<>(); //instaciada por isso que nunca vai returnar null

        //busca por querry ha base de dados
        Cursor cursor = this.database.query(TABLE_RECADO, new String[]{RECADO_ID,RECADO_DESCRICAO,RECADO_ASSINADO},
                null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                Recado auxRecado = new Recado(cursor.getLong(0),cursor.getString(1),cursor.getInt(2));
                //auxRecado.setID(cursor.getLong(0)); // we receive id
                recados.add(auxRecado);
            }while (cursor.moveToNext());
        }
        return recados;
    }


    //TODO: ver isto se tem os nomes dos corretos em comparação com a class
    public ArrayList<Teste> getAllTestesDB()
    {
        ArrayList<Teste> testes = new ArrayList<>();

        //busca por querry ha base de dados
        Cursor cursor = this.database.query(TABLE_TESTE, new String[]{TESTE_ID,TESTE_DESCRICAO,TESTE_HORA,TESTE_DATA,TESTE_TURMA,TESTE_DISCIPLINA},
                null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                //TODO:Acabar isto
                Teste auxTeste = new Teste(cursor.getLong(0),cursor.getInt(1),cursor.getInt(2),cursor.getString(3),cursor.getInt(4),
                        cursor.getInt(5));
                //auxTeste.setID(cursor.getLong(0)); //we receive id
                testes.add(auxTeste);
            } while (cursor.moveToNext());
        }
        return testes;
    }


    public ArrayList<Aluno> getAllAlunosDB()
    {
        ArrayList<Aluno> alunos = new ArrayList<>();
        //busca por querry ha base de dados
        Cursor cursor = this.database.query(TABLE_ALUNO, new String[]{ALUNO_ID,ALUNO_NOME,ALUNO_NUM},
                null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                Aluno auxAluno = new Aluno(cursor.getLong(0),cursor.getString(1),cursor.getInt(2));
                //auxTeste.setID(cursor.getLong(0)); //we receive id
                alunos.add(auxAluno);
            } while (cursor.moveToNext());
        }
        return alunos;
    }

    // updates

    public boolean updateRecadoDB(Recado recado)
    {
        ContentValues values = getValuesRecado(recado);

        return
                (this.database.update(TABLE_RECADO,values, "id=?", new String[]{ "" + recado.getId()}))
                        >0 ;

        // return true;
    }

    public boolean updateTpcDB(Tpc tpc)
    {
        ContentValues values = getValuesTpc(tpc);

        return
                (this.database.update(TABLE_TPC,values, "id=?", new String[]{ "" + tpc.getId()}))
                        >0 ;

        // return true;
    }

    public boolean updateTesteDB(Teste teste)
    {
        ContentValues values = getValuesTeste(teste);

        return
                (this.database.update(TABLE_TESTE,values, "id=?", new String[]{ "" + teste.getId()}))
                        >0 ;

        // return true;
    }

    public boolean updateAlunoDB(Aluno aluno)
    {
        ContentValues values = getValuesAluno(aluno);

        return
                (this.database.update(TABLE_ALUNO,values, "id=?", new String[]{ "" + aluno.getId()}))
                        >0 ;

        // return true;
    }

    private ContentValues getValuesRecado(Recado recado) {
        ContentValues values = new ContentValues();
        values.put(RECADO_DESCRICAO, recado.getDescricao());
        values.put(RECADO_ASSINADO, recado.getAssinado());
        return values;
    }

    private ContentValues getValuesTpc(Tpc tpc){
        ContentValues values = new ContentValues();
        values.put(TPC_DESCRICAO, tpc.getDescricao());
        return  values;
    }

    private ContentValues getValuesAluno(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put(ALUNO_NOME,aluno.getNome());
        values.put(ALUNO_NUM,aluno.getNumeroDeEstudante());
        return values;
    }


    //TODO: VERIFICAR ISTO
    private ContentValues getValuesTeste(Teste teste){
        ContentValues values = new ContentValues();
        values.put(TESTE_DATA,teste.getData());
        values.put(TESTE_HORA,teste.getHora());
        values.put(TESTE_DESCRICAO, teste.getDescricao());
        values.put(TESTE_DISCIPLINA,teste.getDisciplina());
        values.put(TESTE_TURMA,teste.getTurma());
        return values;
    }

}
