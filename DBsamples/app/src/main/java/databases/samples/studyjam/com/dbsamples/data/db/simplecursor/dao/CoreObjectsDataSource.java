package databases.samples.studyjam.com.dbsamples.data.db.simplecursor.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import databases.samples.studyjam.com.dbsamples.data.db.simplecursor.SQLiteHelper;
import databases.samples.studyjam.com.dbsamples.data.db.simplecursor.dto.CoreObject;
import databases.samples.studyjam.com.dbsamples.data.db.simplecursor.table.CoreObjectTable;

public class CoreObjectsDataSource {

    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {CoreObjectTable.COLUMN_ID,
            CoreObjectTable.COLUMN_NAME, CoreObjectTable.COLUMN_URL};

    public CoreObjectsDataSource(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    /**
     * Do not forget to close!
     * @throws android.database.SQLException
     */


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //DO SOMETHING

    public void close() {
        dbHelper.close();
    }


    // ------Cursor methods methods--------//

    /**
     *
     * @return cursor with all rows of CoreObject table
     */
    public Cursor getCursorForAll() {
        return database.query(CoreObjectTable.TABLE_CORE_OBJECT,
                allColumns, null, null, null, null, null);
    }

    /**
     *
     * creation of CoreObject and geting it as object
     *
     * @param name
     * @param url
     * @return
     */
    public CoreObject createCoreObject(String name, String url) {
        ContentValues values = new ContentValues();
        values.put(CoreObjectTable.COLUMN_NAME, name);
        values.put(CoreObjectTable.COLUMN_URL, url);
        long insertId = database.insert(CoreObjectTable.TABLE_CORE_OBJECT, null,
                values);
        Cursor cursor = database.query(CoreObjectTable.TABLE_CORE_OBJECT,
                allColumns, CoreObjectTable.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        CoreObject newCoreObject = cursorToCoreObject(cursor);
        cursor.close();
        return newCoreObject;
    }

    /**
     * batch insertion
     *
     * based on:
     * http://www.outofwhatbox.com/blog/2010/12/android-using-databaseutils-inserthelper-for-faster-insertions-into-sqlite-database/
     *
     *
     */
    public void insertCoreObjects(List<CoreObject> coreObjectList) {
        database.beginTransaction();
        DatabaseUtils.InsertHelper ih = new DatabaseUtils.InsertHelper(database, CoreObjectTable.TABLE_CORE_OBJECT);
        final int nameColumn = ih.getColumnIndex(CoreObjectTable.COLUMN_NAME);
        final int urlColumn = ih.getColumnIndex(CoreObjectTable.COLUMN_URL);
        try {
            for (CoreObject coreObject : coreObjectList) {
                ih.prepareForInsert();
                ih.bind(nameColumn, coreObject.getName());
                ih.bind(urlColumn, coreObject.getUrl());
                ih.execute();
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            ih.close();
        }
    }



    public void deleteCoreObject(CoreObject coreObject) {
        long id = coreObject.getId();
        deleteCoreObject(id);
    }

    public void deleteCoreObject(long id) {
        database.delete(CoreObjectTable.TABLE_CORE_OBJECT, CoreObjectTable.COLUMN_ID
                + " = " + id, null);
    }

    /**
     *
     * Deletion of whole table
     */
    public void deleteAllCoreObjects() {
        database.delete(CoreObjectTable.TABLE_CORE_OBJECT, null, null);
    }

    public List<CoreObject> getAllCoreObjects() {
        List<CoreObject> comments = new ArrayList<CoreObject>();

        Cursor cursor = database.query(CoreObjectTable.TABLE_CORE_OBJECT,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CoreObject comment = cursorToCoreObject(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return comments;
    }

    private static CoreObject cursorToCoreObject(Cursor cursor) {
        CoreObject coreObject = new CoreObject();
        coreObject.setName(cursor.getString(0));
        coreObject.setUrl(cursor.getString(1));
        return coreObject;
    }
}