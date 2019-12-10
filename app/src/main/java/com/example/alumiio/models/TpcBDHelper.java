package com.example.alumiio.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TpcBDHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "AlumioDB";
    private static final String TABLE_NAME = "recado";
    private static final int DB_VERSION = 1;

    //   private static final String BOOK_ID = "id";
    //   private static final String BOOK_TITLE = "title";
    //   private static final String BOOK_AUTHOR = "author";
    //   private static final String BOOK_SERIE = "serie";
    //   private static final String BOOK_YEAR = "year";
    //   private static final String BOOK_COVER = "cover";

    private final SQLiteDatabase database;

    public TpcBDHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        this.database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
