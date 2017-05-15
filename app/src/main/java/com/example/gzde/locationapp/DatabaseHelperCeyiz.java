package com.example.gzde.locationapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperCeyiz extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "CEYIZ";

    public static final String _ID = "_id";
    public static final String NAME = "name";


    static final String DB_NAME = "DUGUN_CEYIZ.DB";


    static final int DB_VERSION = 1;

    public static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY, "
            + NAME + " TEXT " +  ")";

    public DatabaseHelperCeyiz(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}