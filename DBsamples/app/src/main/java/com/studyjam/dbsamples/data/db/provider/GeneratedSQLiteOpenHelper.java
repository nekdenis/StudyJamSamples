package com.studyjam.dbsamples.data.db.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.studyjam.dbsamples.BuildConfig;
import com.studyjam.dbsamples.data.db.provider.company.CompanyColumns;
import com.studyjam.dbsamples.data.db.provider.person.PersonColumns;

public class GeneratedSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = GeneratedSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "generated.db";
    private static final int DATABASE_VERSION = 1;
    private static GeneratedSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final GeneratedSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_COMPANY = "CREATE TABLE IF NOT EXISTS "
            + CompanyColumns.TABLE_NAME + " ( "
            + CompanyColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CompanyColumns.NAME + " TEXT NOT NULL, "
            + CompanyColumns.ADDRESS + " TEXT "
            + " );";

    public static final String SQL_CREATE_INDEX_COMPANY_NAME = "CREATE INDEX IDX_COMPANY_NAME "
            + " ON " + CompanyColumns.TABLE_NAME + " ( " + CompanyColumns.NAME + " );";

    public static final String SQL_CREATE_TABLE_PERSON = "CREATE TABLE IF NOT EXISTS "
            + PersonColumns.TABLE_NAME + " ( "
            + PersonColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PersonColumns.FIRST_NAME + " TEXT NOT NULL, "
            + PersonColumns.LAST_NAME + " TEXT NOT NULL, "
            + PersonColumns.AGE + " INTEGER NOT NULL, "
            + PersonColumns.BIRTH_DATE + " INTEGER, "
            + PersonColumns.HAS_BLUE_EYES + " INTEGER NOT NULL DEFAULT 0, "
            + PersonColumns.HEIGHT + " REAL, "
            + PersonColumns.GENDER + " INTEGER NOT NULL, "
            + PersonColumns.COUNTRY_CODE + " TEXT NOT NULL, "
            + PersonColumns.COMPANY_ID + " INTEGER NOT NULL "
            + ", CONSTRAINT fk_company_id FOREIGN KEY (" + PersonColumns.COMPANY_ID + ") REFERENCES company (_id) ON DELETE CASCADE"
            + ", CONSTRAINT unique_name UNIQUE (first_name, last_name) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_INDEX_PERSON_LAST_NAME = "CREATE INDEX IDX_PERSON_LAST_NAME "
            + " ON " + PersonColumns.TABLE_NAME + " ( " + PersonColumns.LAST_NAME + " );";

    // @formatter:on

    public static GeneratedSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static GeneratedSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static GeneratedSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new GeneratedSQLiteOpenHelper(context);
    }

    private GeneratedSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new GeneratedSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static GeneratedSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new GeneratedSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private GeneratedSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new GeneratedSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_COMPANY);
        db.execSQL(SQL_CREATE_INDEX_COMPANY_NAME);
        db.execSQL(SQL_CREATE_TABLE_PERSON);
        db.execSQL(SQL_CREATE_INDEX_PERSON_LAST_NAME);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
