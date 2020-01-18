package com.example.alumiio.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlumioBDHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "AlumioDB";
    private static final String TABLE_ALUNO = "aluno";
    private static final String TABLE_TPC = "tpc";
    private static final String TABLE_RECADO = "recado";
    private static final String TABLE_TESTE = "teste";
    private static final String TABLE_TURMA = "turma";
    private static final String TABLE_DISCIPLINE_TURMA = "disciplinaturma";
    private static final int DB_VERSION = 1;

    private static final String ALUNO_ID = "id";
    private static final String TPC_ID = "id";
    private static final String RECADO_ID = "id";
    private static final String TESTE_ID = "id";
    private static final String TURMA_ID = "id";
    private static final String DISCIPLINATURMA_ID = "id";

    private static final String ALUNO_NOME = "nome";
    private static final String ALUNO_ID_ENCARREGADO_DE_EDUCACAO = "id_encarregado_de_educacao";
    private static final String ALUNO_ID_TURMA = "id_turma";
    private static final String ALUNO_NUMERO_ESTUDANTE = "numero_estudante";

    private static final String TPC_DESCRICAO = "descricao";
    private static final String TPC_ID_DISCIPLINA_TURMA = "id_disciplina_turma";
    private static final String TPC_ID_PROFESSOR = "id_professor";

    private static final String RECADO_TOPICO = "topico";
    private static final String RECADO_DESCRICAO = "descricao";
    private static final String RECADO_ASSINADO = "assinado";
    private static final String RECADO_DATA_HORA = "data_hora";
    private static final String RECADO_ID_DISCIPLINA_TURMA = "id_disciplina_turma";
    private static final String RECADO_ID_ALUNO = "id_aluno";
    private static final String RECADO_ID_PROFESSOR = "id_professor";

    private static final String TESTE_DESCRICAO = "descricao";
    private static final String TESTE_DATA_HORA = "data_hora";
    private static final String TESTE_ID_DISCIPLINA_TURMA = "id_disciplina_turma";
    private static final String TESTE_ID_PROFESSOR = "id_professor";


    private static final String TURMA_ANO = "ano";
    private static final String TURMA_LETRA = "letra";

    private static final String DISCIPLINATURMA_ID_TURMA = "id_turma";
    private static final String DISCIPLINATURMA_ID_DISCIPLINA = "id_disciplina";
    private static final String DISCIPLINATURMA_ID_PROFESSOR = "id_professor";

    private final SQLiteDatabase database;

    public AlumioBDHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating table Aluno:
        String createAlunoTable = "CREATE TABLE " + TABLE_ALUNO +
                " (" + ALUNO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ALUNO_ID_ENCARREGADO_DE_EDUCACAO + " INTEGER, "
                + ALUNO_ID_TURMA + " INTEGER, "
                + ALUNO_NOME + " TEXT, "
                + ALUNO_NUMERO_ESTUDANTE + " INTEGER "
                + ");";

        db.execSQL(createAlunoTable);
        System.out.println("-->  DB: Table created Aluno");


        //Creating table TPC:
        String createTpcTable = "CREATE TABLE " + TABLE_TPC + " ("
                + TPC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TPC_DESCRICAO + " TEXT NOT NULL, "
                + TPC_ID_DISCIPLINA_TURMA + " INTEGER NOT NULL, "
                + TPC_ID_PROFESSOR + " INTEGER NOT NULL"
                + ");";

        db.execSQL(createTpcTable);
        System.out.println("-->  DB: Table created TPC");


        //TODO: Ver as coisas que faltam
        //Creating table Recado: falta a FK para o aluno
        String createRecadoTable = "CREATE TABLE " + TABLE_RECADO + " ("
                + RECADO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RECADO_TOPICO + " TEXT NOT NULL, "
                + RECADO_DESCRICAO + " TEXT NOT NULL, "
                + RECADO_ASSINADO + " INTEGER NOT NULL, "
                + RECADO_DATA_HORA + " INTEGER NOT NULL, "
                + RECADO_ID_DISCIPLINA_TURMA + " INTEGER NOT NULL, "
                + RECADO_ID_ALUNO + " INTEGER, "
                + RECADO_ID_PROFESSOR + " INTEGER NOT NULL "
                + ");";

        db.execSQL(createRecadoTable);
        System.out.println("-->  DB: Table created Recado");


        //Creating table Teste
        String createTesteTable = "CREATE TABLE " + TABLE_TESTE +
                " (" + TESTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TESTE_DESCRICAO + " TEXT NOT NULL, "
                + TESTE_DATA_HORA + " INTEGER NOT NULL, "
                + TESTE_ID_DISCIPLINA_TURMA + " INTEGER NOT NULL, "
                + TESTE_ID_PROFESSOR + " TEXT NOT NULL "
                + ");";
        db.execSQL(createTesteTable);
        System.out.println("-->  DB: Table created Teste");


        //Creating table Turma
        String createTurmaTable = "CREATE TABLE " + TABLE_TURMA + " ("
                + TURMA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TURMA_ANO + " INTEGER NOT NULL, "
                + TURMA_LETRA + " TEXT NOT NULL "
                + ");";
        db.execSQL(createTurmaTable);
        System.out.println("-->  DB: Table created Turma");


        //Creating table Disciplina_Turma
        String createDisciplinaTurmaTable = "CREATE TABLE " + TABLE_DISCIPLINE_TURMA + " ("
                + DISCIPLINATURMA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DISCIPLINATURMA_ID_DISCIPLINA + " INTEGER NOT NULL, "
                + DISCIPLINATURMA_ID_TURMA + " INTEGER NOT NULL, "
                + DISCIPLINATURMA_ID_PROFESSOR + " INTEGER NOT NULL "
                + ");";
        db.execSQL(createDisciplinaTurmaTable);
        System.out.println("-->  DB: Table created Disciplina_Turma");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TESTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECADO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TPC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALUNO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TURMA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISCIPLINE_TURMA);
        this.onCreate(db);
        System.out.println("-->  DB: On Update Tables");
    }


    //ADDing all stuff

    public long addRecadoToDB(Recado recado) {
        ContentValues values = getValuesRecado(recado); // contentor de valores a manipular

      return this.database.insert(TABLE_RECADO, null, values);
    }

    public long addTpcToDB(Tpc tpc) {

        ContentValues values = getValuesTpc(tpc);

       return this.database.insert(TABLE_TPC, null, values);
    }

    public long addAlunoToDB(Aluno aluno) {

        ContentValues values = getValuesAluno(aluno);

        return this.database.insert(TABLE_ALUNO, null, values);
    }

    public long addTesteToDB(Teste teste) {
        ContentValues values = getValuesTeste(teste);

         return this.database.insert(TABLE_TESTE, null, values);
    }

    public void addTurmaToDB(Turma turma) {
        ContentValues values = getValuesTurma(turma);

        this.database.insert(TABLE_TURMA, null, values);
    }

    public void addDisciplinaTurmaToDB(Disciplina_Turma disciplinaTurma) {
        ContentValues values = getValuesDisciplinaTurma(disciplinaTurma);

        this.database.insert(TABLE_DISCIPLINE_TURMA, null, values);
    }


    //Read
    public ArrayList<Tpc> getALLTpcDB() {
        ArrayList<Tpc> tpcs = new ArrayList<>(); // instanciada por isso nunca null

        //Busca por querry ha base de dados
        Cursor cursor = this.database.query(TABLE_TPC, new String[]{TPC_ID, TPC_DESCRICAO,TPC_ID_DISCIPLINA_TURMA,TPC_ID_PROFESSOR},
                null, null, null, null, null, null);
        if (cursor.moveToFirst()) { //saber se há algum
            do {
                Tpc auxTpc = new Tpc(cursor.getString(1),cursor.getInt(2),cursor.getInt(3));
                //auxTpc.setID(cursor.getLong(0)); // we receive id
                tpcs.add(auxTpc);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return tpcs;
    }

    public ArrayList<Recado> getAllRecadosDB() {
        ArrayList<Recado> recados = new ArrayList<>(); //instaciada por isso que nunca vai returnar null

        //busca por querry ha base de dados
        Cursor cursor = this.database.query(TABLE_RECADO, new String[]{RECADO_ID, RECADO_TOPICO, RECADO_DESCRICAO,RECADO_ASSINADO,RECADO_DATA_HORA,RECADO_ID_DISCIPLINA_TURMA,RECADO_ID_ALUNO,RECADO_ID_PROFESSOR},
                null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Recado auxRecado = new Recado( cursor.getString(1), cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7));
                //auxRecado.setID(cursor.getLong(0)); // we receive id
                recados.add(auxRecado);
            } while (cursor.moveToNext());
        }
        return recados;
    }


    //TODO: ver isto se tem os nomes dos corretos em comparação com a class
    public ArrayList<Teste> getAllTestesDB() {
        ArrayList<Teste> testes = new ArrayList<>();

        //busca por querry ha base de dados
        Cursor cursor = this.database.query(TABLE_TESTE, new String[]{TESTE_ID, TESTE_DESCRICAO, TESTE_DATA_HORA, TESTE_ID_DISCIPLINA_TURMA, TESTE_ID_PROFESSOR},
                null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                //TODO:Acabar isto
                Teste auxTeste = new Teste( cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
                //auxTeste.setID(cursor.getLong(0)); //we receive id
                testes.add(auxTeste);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return testes;
    }


    public ArrayList<Aluno> getAllAlunosDB() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        //busca por querry ha base de dados
        Cursor cursor = this.database.query(TABLE_ALUNO, new String[]{ALUNO_ID, ALUNO_ID_ENCARREGADO_DE_EDUCACAO, ALUNO_ID_TURMA,ALUNO_NOME, ALUNO_NUMERO_ESTUDANTE},
                null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Aluno auxAluno = new Aluno(cursor.getInt(1), cursor.getInt(2),cursor.getString(3),cursor.getInt(4));
                // auxAluno.setId(cursor.getLong(0)); //we receive id
                alunos.add(auxAluno);
            } while (cursor.moveToNext());
        }
        return alunos;
    }

    public ArrayList<Turma> getAllTurmasDB() {

        ArrayList<Turma> turmas = new ArrayList<>();

        Cursor cursor = this.database.query(TABLE_TURMA, new String[]{TURMA_ID, TURMA_ANO, TURMA_LETRA},
                null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Turma auxTurma = new Turma(/*cursor.getInt(0),*/ cursor.getInt(1), cursor.getString(2));
                turmas.add(auxTurma);
            } while (cursor.moveToNext());

        }
        return turmas;
    }

    public ArrayList<Disciplina_Turma> getAllDisciplinaTurmasDB() {

        ArrayList<Disciplina_Turma> disciplinaTurmas = new ArrayList<>();

        Cursor cursor = this.database.query(TABLE_DISCIPLINE_TURMA, new String[]{DISCIPLINATURMA_ID, DISCIPLINATURMA_ID_TURMA, DISCIPLINATURMA_ID_DISCIPLINA, DISCIPLINATURMA_ID_PROFESSOR},
                null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Disciplina_Turma auxDisciplinaTurma = new Disciplina_Turma(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2),cursor.getInt(3));
                disciplinaTurmas.add(auxDisciplinaTurma);
            } while (cursor.moveToNext());

        }


        return disciplinaTurmas;
    }


    // updates

    public boolean updateRecadoDB(Recado recado) {
        ContentValues values = getValuesRecado(recado);

        return
                (this.database.update(TABLE_RECADO, values, "id=?", new String[]{"" + recado.getId()}))
                        > 0;

        // return true;
    }

    public boolean updateTpcDB(Tpc tpc) {
        ContentValues values = getValuesTpc(tpc);

        return
                (this.database.update(TABLE_TPC, values, "id=?", new String[]{"" + tpc.getId()}))
                        > 0;

        // return true;
    }

    public boolean updateTesteDB(Teste teste) {
        ContentValues values = getValuesTeste(teste);

        return
                (this.database.update(TABLE_TESTE, values, "id=?", new String[]{"" + teste.getId()}))
                        > 0;

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

    public boolean updateTurmaDB(Turma turma) {
        ContentValues values = getValuesTurma(turma);

        return
                (this.database.update(TABLE_TURMA, values, "id=?", new String[]{"" + turma.getId()}))
                        > 0;

    }

//    public boolean updateDisciplinaTurmaDB(Disciplina_Turma disciplinaTurma)
//    {
//        ContentValues values = getValuesDisciplinaTurma(disciplinaTurma);
//
//        return
//                (this.database.update(TABLE_DISCIPLINE_TURMA,values,"id=?", new String[]{"" + disciplinaTurma.getId()}))
//                        >0;
//
//    }


    //DELETE

    // delete Recados
    public boolean deleteRecadoDB(long recadoId) {
        return (this.database.delete(TABLE_RECADO, "id=?", new String[]{"" + recadoId})
        ) == 1;
    }

    public void deleteAllRecadosDB() {
        this.database.delete(TABLE_RECADO, null, null);
    }


    //deleteTpcs
    public boolean deleteTpcDB(long tpcId) {
        return (this.database.delete(TABLE_TPC, "id=?", new String[]{"" + tpcId})
        ) == 1;
    }

    public void deleteAllTpcDB() {
        this.database.delete(TABLE_TPC, null, null);
    }


    //delete testes
    public boolean deleteTesteDB(long testeId) {
        return (this.database.delete(TABLE_TESTE, "id=?", new String[]{"" + testeId})
        ) == 1;
    }

    public void deleteAllTestesDB() {
        this.database.delete(TABLE_TESTE, null, null);
    }

    //delete Alunos
    public boolean deleteAlunoDB(long alunoId) {
        return (this.database.delete(TABLE_ALUNO, "id=?", new String[]{"" + alunoId})
        ) == 1;
    }

    //Delete Disciplina_Turma
    public boolean deleteDisciplinaTurmaDB(long disciplinaTurmaID) {
        return
                (this.database.delete(TABLE_DISCIPLINE_TURMA, "id=?", new String[]{"" + disciplinaTurmaID})) == 1;

    }

    public void deleteAllAlunosDB() {
        this.database.delete(TABLE_ALUNO, null, null);
    }


    private ContentValues getValuesRecado(Recado recado) {
        ContentValues values = new ContentValues();
        //values.put(RECADO_ID, recado.getId());
        values.put(RECADO_TOPICO, recado.getTopico());
        values.put(RECADO_DESCRICAO, recado.getDescricao());
        values.put(RECADO_ASSINADO, recado.getAssinado());
        values.put(RECADO_DATA_HORA, recado.getData_hora());
        values.put(RECADO_ID_DISCIPLINA_TURMA, recado.getId_disciplina_turma());
        values.put(RECADO_ID_PROFESSOR, recado.getId_professor());
        return values;
    }

    private ContentValues getValuesTpc(Tpc tpc) {
        ContentValues values = new ContentValues();
        //values.put(TPC_ID, tpc.getId());
        values.put(TPC_DESCRICAO, tpc.getDescricao());
        values.put(TPC_ID_DISCIPLINA_TURMA, tpc.getId_disciplina_turma());
        values.put(TPC_ID_PROFESSOR, tpc.getId_professor());
        return values;
    }

    private ContentValues getValuesAluno(Aluno aluno) {
        ContentValues values = new ContentValues();
        //values.put(ALUNO_ID, aluno.getId());
        values.put(ALUNO_ID_ENCARREGADO_DE_EDUCACAO, aluno.getId_encarregado_de_educacao());
        values.put(ALUNO_ID_TURMA, aluno.getId_turma());
        values.put(ALUNO_NOME, aluno.getNome());
        values.put(ALUNO_NUMERO_ESTUDANTE, aluno.getNumeroDeEstudante());
        return values;
    }

    //TODO: VERIFICAR ISTO
    private ContentValues getValuesTeste(Teste teste) {
        ContentValues values = new ContentValues();
        //values.put(TESTE_ID , teste.getId());
        values.put(TESTE_DESCRICAO, teste.getDescricao());
        values.put(TESTE_DATA_HORA, teste.getData_hora());
        values.put(TESTE_ID_DISCIPLINA_TURMA, teste.getId_disciplina_turma());
        values.put(TESTE_ID_PROFESSOR, teste.getId_professor());
        return values;
    }

    private ContentValues getValuesTurma(Turma turma) {
        ContentValues values = new ContentValues();
        //values.put(TURMA_ID,turma.getId());
        values.put(TURMA_ANO, turma.getAno());
        values.put(TURMA_LETRA, turma.getLetra());
        return values;
    }

    private ContentValues getValuesDisciplinaTurma(Disciplina_Turma disciplinaTurma) {
        ContentValues values = new ContentValues();
        //values.put(DISCIPLINATURMA_ID,disciplinaTurma.getId());
        values.put(DISCIPLINATURMA_ID_DISCIPLINA, disciplinaTurma.getId_disciplina());
        values.put(DISCIPLINATURMA_ID_TURMA, disciplinaTurma.getId_turma());
        values.put(DISCIPLINATURMA_ID_PROFESSOR, disciplinaTurma.getId_professor());
        return values;
    }


}
