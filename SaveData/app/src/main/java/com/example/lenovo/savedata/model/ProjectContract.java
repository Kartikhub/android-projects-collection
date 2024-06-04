package com.example.lenovo.savedata.model;

import android.provider.BaseColumns;

/**
 * Created by LENOVO on 16-07-2016.
 */
public final class ProjectContract {
    public static final String TABLE_NAME="project";
    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + ProjectContract.TABLE_NAME +
            " ( " +ProjectContract.ProjectEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            ProjectContract.ProjectEntry.COLOUMN_NAME_TITLE+" TEXT );";


    public static abstract class ProjectEntry implements BaseColumns {
        public static final String COLOUMN_NAME_TITLE = "NAME";


    }

    }
