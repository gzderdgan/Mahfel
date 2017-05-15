package com.example.gzde.locationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManagerCeyiz {

    private DatabaseHelperCeyiz dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManagerCeyiz(Context c) {
        context = c;
    }

    public DBManagerCeyiz open() throws SQLException {
        dbHelper = new DatabaseHelperCeyiz(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String n) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelperCeyiz.NAME, n);
        database.insert(DatabaseHelperCeyiz.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelperCeyiz._ID, DatabaseHelperCeyiz.NAME };
        Cursor cursor = database.query(DatabaseHelperCeyiz.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperCeyiz.NAME, name);
        int i = database.update(DatabaseHelperCeyiz.TABLE_NAME, contentValues, DatabaseHelperCeyiz._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelperCeyiz.TABLE_NAME, DatabaseHelperCeyiz._ID + "=" + _id, null);
    }

}
