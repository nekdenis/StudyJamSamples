package com.studyjam.dbsamples.data.db.simplecursor.table;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.studyjam.dbsamples.data.db.simplecursor.SQLiteHelper;

public class CoreObjectTable {
    public static final String TABLE_CORE_OBJECT = "coreObject";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_URL = "url";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_CORE_OBJECT + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME+ " text not null, "
            + COLUMN_URL + " text not null);";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }


    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data"
        );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CORE_OBJECT);
        onCreate(db);
    }
}
