package com.hqt.eyetrackingidentityauthentication.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ETDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "eyetrack.db";
    public static final int DATABASE_VERSION = 3;
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UsersTable.TABLE_NAME + " (" +
                    UsersTable._ID + " INTEGER PRIMARY KEY," +
                    UsersTable.COLUMN_NAME_USERNAME + " TEXT," +
                    UsersTable.COLUMN_NAME_PASSWORD + " TEXT," +
                    UsersTable.COLUMN_NAME_LOGINED + " TEXT," +
                    UsersTable.COLUMN_NAME_ETPWD + " TEXT," +
                    UsersTable.COLUMN_NAME_ETTAG + " TEXT," +
                    UsersTable.COLUMN_NAME_INDPWD + " TEXT," +
                    UsersTable.COLUMN_NAME_DIRPWD + " TEXT," +
                    UsersTable.COLUMN_NAME_GESPWD + " TEXT)";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UsersTable.TABLE_NAME;
    public ETDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
