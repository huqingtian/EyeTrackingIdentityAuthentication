package com.hqt.eyetrackingidentityauthentication.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class SqliteImplementer {
    private ETDBHelper etdbHelper;
    public SqliteImplementer(ETDBHelper etdbHelper){
        this.etdbHelper = etdbHelper;
    }
    //增加数据
    public void saveData(UsersTable entry){
        SQLiteDatabase db = etdbHelper.getWritableDatabase();
        ContentValues user = new ContentValues();
        user.put(UsersTable.COLUMN_NAME_USERNAME, entry.username);
        user.put(UsersTable.COLUMN_NAME_PASSWORD, entry.password);
        user.put(UsersTable.COLUMN_NAME_ETTAG, entry.ettag);
        db.insert(UsersTable.TABLE_NAME, null, user);
    }

    public UsersTable getUser(String username){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        String[] projection = {UsersTable.COLUMN_NAME_USERNAME, UsersTable.COLUMN_NAME_PASSWORD, UsersTable.COLUMN_NAME_LOGINED, UsersTable.COLUMN_NAME_ETPWD, UsersTable.COLUMN_NAME_ETTAG, UsersTable.COLUMN_NAME_INDPWD, UsersTable.COLUMN_NAME_DIRPWD, UsersTable.COLUMN_NAME_GESPWD};
        String selection = UsersTable.COLUMN_NAME_USERNAME + " = ?";
        String[] selectionArgs = { username };
        Cursor cursor = db.query(UsersTable.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        UsersTable user = new UsersTable();
        while(cursor.moveToNext()) {
            user.username = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_USERNAME));
            user.password = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_PASSWORD));
            user.logined = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_LOGINED));
            user.etpwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_ETPWD));
            user.ettag = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_ETTAG));
            user.indpwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_INDPWD));
            user.dirpwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_DIRPWD));
            user.gespwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_GESPWD));
        }
        cursor.close();
        return user;
    }
    public List<UsersTable> getAllUsers(){
        List<UsersTable> users = new ArrayList<>();
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        String[] projection = {UsersTable.COLUMN_NAME_USERNAME, UsersTable.COLUMN_NAME_PASSWORD, UsersTable.COLUMN_NAME_LOGINED, UsersTable.COLUMN_NAME_ETPWD, UsersTable.COLUMN_NAME_ETTAG, UsersTable.COLUMN_NAME_INDPWD, UsersTable.COLUMN_NAME_DIRPWD, UsersTable.COLUMN_NAME_GESPWD};
        Cursor cursor = db.query(UsersTable.TABLE_NAME, projection, null, new String[]{}, null, null, null);
        while(cursor.moveToNext()) {
            UsersTable user = new UsersTable();
            user.username = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_USERNAME));
            user.password = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_PASSWORD));
            user.logined = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_LOGINED));
            user.etpwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_ETPWD));
            user.ettag = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_ETTAG));
            user.indpwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_INDPWD));
            user.dirpwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_DIRPWD));
            user.gespwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_GESPWD));
            users.add(user);
        }
        cursor.close();
        return users;
    }
    public void changeETPwd(String username, String new_pwd){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        UsersTable user = getUser(username);
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_NAME_USERNAME, user.username);
        cv.put(UsersTable.COLUMN_NAME_PASSWORD, user.password);
        cv.put(UsersTable.COLUMN_NAME_LOGINED, user.logined);
        cv.put(UsersTable.COLUMN_NAME_ETPWD, new_pwd);
        cv.put(UsersTable.COLUMN_NAME_ETTAG, user.ettag);
        cv.put(UsersTable.COLUMN_NAME_INDPWD, user.indpwd);
        cv.put(UsersTable.COLUMN_NAME_DIRPWD, user.dirpwd);
        cv.put(UsersTable.COLUMN_NAME_GESPWD, user.gespwd);
        db.update(UsersTable.TABLE_NAME, cv, "username = ?", new String[]{username});
    }
    public void changeUserLoginTag(String username, String login_tag){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        UsersTable user = getUser(username);
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_NAME_USERNAME, user.username);
        cv.put(UsersTable.COLUMN_NAME_PASSWORD, user.password);
        cv.put(UsersTable.COLUMN_NAME_LOGINED, login_tag);
        cv.put(UsersTable.COLUMN_NAME_ETPWD, user.etpwd);
        cv.put(UsersTable.COLUMN_NAME_ETTAG, user.ettag);
        cv.put(UsersTable.COLUMN_NAME_INDPWD, user.indpwd);
        cv.put(UsersTable.COLUMN_NAME_DIRPWD, user.dirpwd);
        cv.put(UsersTable.COLUMN_NAME_GESPWD, user.gespwd);
        db.update(UsersTable.TABLE_NAME, cv, "username = ?", new String[]{username});
    }
    public UsersTable getLoginedUser(){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        String[] projection = {UsersTable.COLUMN_NAME_USERNAME, UsersTable.COLUMN_NAME_PASSWORD, UsersTable.COLUMN_NAME_LOGINED, UsersTable.COLUMN_NAME_ETPWD, UsersTable.COLUMN_NAME_ETTAG, UsersTable.COLUMN_NAME_INDPWD, UsersTable.COLUMN_NAME_DIRPWD, UsersTable.COLUMN_NAME_GESPWD};
        String selection = UsersTable.COLUMN_NAME_LOGINED + " = ?";
        String[] selectionArgs = { "1" };
        Cursor cursor = db.query(UsersTable.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        UsersTable user = new UsersTable();
        while(cursor.moveToNext()) {
            user.username = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_USERNAME));
            user.password = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_PASSWORD));
            user.logined = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_LOGINED));
            user.etpwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_ETPWD));
            user.ettag = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_ETTAG));
            user.indpwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_INDPWD));
            user.dirpwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_DIRPWD));
            user.gespwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_GESPWD));
        }
        cursor.close();
        return user;
    }
    public void changeLoginPwd(String username, String password){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        UsersTable user = getUser(username);
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_NAME_USERNAME, user.username);
        cv.put(UsersTable.COLUMN_NAME_PASSWORD, password);
        cv.put(UsersTable.COLUMN_NAME_LOGINED, user.logined);
        cv.put(UsersTable.COLUMN_NAME_ETPWD, user.etpwd);
        cv.put(UsersTable.COLUMN_NAME_ETTAG, user.ettag);
        cv.put(UsersTable.COLUMN_NAME_INDPWD, user.indpwd);
        cv.put(UsersTable.COLUMN_NAME_DIRPWD, user.dirpwd);
        cv.put(UsersTable.COLUMN_NAME_GESPWD, user.gespwd);
        db.update(UsersTable.TABLE_NAME, cv, "username = ?", new String[]{username});
    }
    public void changeEtTag(String username, String tag){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        UsersTable user = getUser(username);
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_NAME_USERNAME, user.username);
        cv.put(UsersTable.COLUMN_NAME_PASSWORD, user.password);
        cv.put(UsersTable.COLUMN_NAME_LOGINED, user.logined);
        cv.put(UsersTable.COLUMN_NAME_ETPWD, user.etpwd);
        cv.put(UsersTable.COLUMN_NAME_ETTAG, tag);
        cv.put(UsersTable.COLUMN_NAME_INDPWD, user.indpwd);
        cv.put(UsersTable.COLUMN_NAME_DIRPWD, user.dirpwd);
        cv.put(UsersTable.COLUMN_NAME_GESPWD, user.gespwd);
        db.update(UsersTable.TABLE_NAME, cv, "username = ?", new String[]{username});
    }
    public void changeIndPwd(String username, String pwd){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        UsersTable user = getUser(username);
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_NAME_USERNAME, user.username);
        cv.put(UsersTable.COLUMN_NAME_PASSWORD, user.password);
        cv.put(UsersTable.COLUMN_NAME_LOGINED, user.logined);
        cv.put(UsersTable.COLUMN_NAME_ETPWD, user.etpwd);
        cv.put(UsersTable.COLUMN_NAME_ETTAG, user.ettag);
        cv.put(UsersTable.COLUMN_NAME_INDPWD, pwd);
        cv.put(UsersTable.COLUMN_NAME_DIRPWD, user.dirpwd);
        cv.put(UsersTable.COLUMN_NAME_GESPWD, user.gespwd);
        db.update(UsersTable.TABLE_NAME, cv, "username = ?", new String[]{username});
    }
    public String getIndPwd(String username){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        String[] projection = {UsersTable.COLUMN_NAME_INDPWD};
        String selection = UsersTable.COLUMN_NAME_USERNAME + " = ?";
        String[] selectionArgs = { username };
        Cursor cursor = db.query(UsersTable.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        String pwd = "";
        while(cursor.moveToNext()) {
            pwd = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_INDPWD));
        }
        cursor.close();
        return pwd;
    }
    public void changeDirPwd(String username, String pwd){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        UsersTable user = getUser(username);
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_NAME_USERNAME, user.username);
        cv.put(UsersTable.COLUMN_NAME_PASSWORD, user.password);
        cv.put(UsersTable.COLUMN_NAME_LOGINED, user.logined);
        cv.put(UsersTable.COLUMN_NAME_ETPWD, user.etpwd);
        cv.put(UsersTable.COLUMN_NAME_ETTAG, user.ettag);
        cv.put(UsersTable.COLUMN_NAME_INDPWD, user.indpwd);
        cv.put(UsersTable.COLUMN_NAME_DIRPWD, pwd);
        cv.put(UsersTable.COLUMN_NAME_GESPWD, user.gespwd);
        db.update(UsersTable.TABLE_NAME, cv, "username = ?", new String[]{username});
    }
    public void changeGesPwd(String username, String pwd){
        SQLiteDatabase db = etdbHelper.getReadableDatabase();
        UsersTable user = getUser(username);
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_NAME_USERNAME, user.username);
        cv.put(UsersTable.COLUMN_NAME_PASSWORD, user.password);
        cv.put(UsersTable.COLUMN_NAME_LOGINED, user.logined);
        cv.put(UsersTable.COLUMN_NAME_ETPWD, user.etpwd);
        cv.put(UsersTable.COLUMN_NAME_ETTAG, user.ettag);
        cv.put(UsersTable.COLUMN_NAME_INDPWD, user.indpwd);
        cv.put(UsersTable.COLUMN_NAME_DIRPWD, user.dirpwd);
        cv.put(UsersTable.COLUMN_NAME_GESPWD, pwd);
        db.update(UsersTable.TABLE_NAME, cv, "username = ?", new String[]{username});
    }
}
