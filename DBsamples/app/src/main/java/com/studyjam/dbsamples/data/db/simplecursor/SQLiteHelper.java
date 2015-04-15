package com.studyjam.dbsamples.data.db.simplecursor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.studyjam.dbsamples.data.db.simplecursor.table.CoreObjectTable;

public class SQLiteHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "cursor_research.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CoreObjectTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        CoreObjectTable.onUpgrade(db, oldVersion, newVersion);
    }
}