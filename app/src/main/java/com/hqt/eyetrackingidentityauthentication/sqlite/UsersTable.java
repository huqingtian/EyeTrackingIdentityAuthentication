package com.hqt.eyetrackingidentityauthentication.sqlite;

import android.provider.BaseColumns;

public class UsersTable implements BaseColumns {
    public static final String TABLE_NAME = "users";      //表名称
    public static final String COLUMN_NAME_USERNAME = "username";
    public static final String COLUMN_NAME_PASSWORD = "password";
    public static final String COLUMN_NAME_LOGINED = "logined";
    public static final String COLUMN_NAME_ETPWD = "etpwd";
    public static final String COLUMN_NAME_ETTAG = "ettag";
    public UsersTable(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UsersTable() {
    }
    public String username;
    public String password;
    public String logined = "0";
    public String etpwd = "";
    public String ettag = "1";
}
