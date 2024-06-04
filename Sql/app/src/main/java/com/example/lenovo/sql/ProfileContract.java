package com.example.lenovo.sql;

import android.provider.BaseColumns;

/**
 * Created by LENOVO on 25-07-2016.
 */
public final class ProfileContract {
    public static final String TABLE_NAME="profile";
    public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ( "+
            ProfileColoumns._ID+ " INTEGER PRIMARY KEY  AUTOINCREMENT, "+
            ProfileColoumns.COLOUMN_NAME + " TEXT, "+
            ProfileColoumns.COLOUMN_GENDER+ " TEXT );";



public static abstract class ProfileColoumns implements BaseColumns{
    public static final String COLOUMN_NAME="username";
    public static final String COLOUMN_GENDER="gender";
}
}
