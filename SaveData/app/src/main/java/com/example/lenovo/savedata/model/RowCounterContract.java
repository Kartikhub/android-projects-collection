package com.example.lenovo.savedata.model;

import android.provider.BaseColumns;

/**
 * Created by LENOVO on 16-07-2016.
 */
public final class RowCounterContract {
    public static final String TABLE_NAME="row_counter";
    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + RowCounterContract.TABLE_NAME +
            " ( " +RowCounterContract.RowCounterEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            RowCounterEntry.COLOUMN_NAME_PROJECT_ID+" INTEGER, "+
            RowCounterEntry.COLOUMN_NAME_CURRENT_AMOUNT+ " INTEGER DEFAULT 0, "+
   RowCounterEntry.COLOUMN_NAME_FINAL_AMOUNT+ " INTEGER, "+ "FOREIGN KEY ( "+ RowCounterEntry.COLOUMN_NAME_PROJECT_ID+" ) "+ "REFERENCES projects( "+ ProjectContract.ProjectEntry._ID+" ));";

    public static abstract class RowCounterEntry implements BaseColumns{
        public static final String COLOUMN_NAME_PROJECT_ID="project_id";
        public static final String COLOUMN_NAME_FINAL_AMOUNT="final_amount";
        public static final String COLOUMN_NAME_CURRENT_AMOUNT="current_amount";




    }



}
