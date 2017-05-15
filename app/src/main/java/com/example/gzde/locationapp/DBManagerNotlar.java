package com.example.gzde.locationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManagerNotlar {

    private DatabaseHelperNotlar dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManagerNotlar(Context c) {
        context = c;
    }

    public DBManagerNotlar open() throws SQLException {
        dbHelper = new DatabaseHelperNotlar(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String n) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelperNotlar.NAME, n);
        database.insert(DatabaseHelperNotlar.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelperNotlar._ID, DatabaseHelperNotlar.NAME };
        Cursor cursor = database.query(DatabaseHelperNotlar.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperNotlar.NAME, name);
        int i = database.update(DatabaseHelperNotlar.TABLE_NAME, contentValues, DatabaseHelperNotlar._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelperNotlar.TABLE_NAME, DatabaseHelperNotlar._ID + "=" + _id, null);
    }

}
