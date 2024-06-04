package com.example.lenovo.savedata.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by LENOVO on 17-07-2016.
 */
public class ProjectsDatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Projects.db";


    public ProjectsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void createProject(String projectName,int rowCounterAmount,int rowsAmount){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues projectValues=new ContentValues();
        projectValues.put(ProjectContract.ProjectEntry.COLOUMN_NAME_TITLE, projectName);
        long projectid;
        projectid=db.insert(ProjectContract.TABLE_NAME, null, projectValues);
        for(int i=0; i<rowCounterAmount; i++){
            ContentValues rowCounterValues=new ContentValues();
            rowCounterValues.put(RowCounterContract.RowCounterEntry.COLOUMN_NAME_PROJECT_ID, projectid);
            rowCounterValues.put(RowCounterContract.RowCounterEntry.COLOUMN_NAME_FINAL_AMOUNT, rowsAmount);
            db.insert(RowCounterContract.TABLE_NAME, null, rowCounterValues);
        }

    }
    public void deleteRowCounter(RowCounter rowCounter){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(RowCounterContract.TABLE_NAME, RowCounterContract.RowCounterEntry._ID+"=?",new String[]{String.valueOf(rowCounter.getId())});
    }
    public Project getProject(long projectId){
        SQLiteDatabase db=getReadableDatabase();
        Cursor projCursor=db.query(ProjectContract.TABLE_NAME,null,ProjectContract.ProjectEntry._ID+"=?",new String[]{String.valueOf(projectId)},null,null,null);
        projCursor.moveToNext();
        Project project=new Project();
        project.setId(projCursor.getLong(projCursor.getColumnIndex(ProjectContract.ProjectEntry._ID)));
        project.setName(projCursor.getString(projCursor.getColumnIndex(ProjectContract.ProjectEntry.COLOUMN_NAME_TITLE)));
        project.setRowCounters(getRowCounters(projectId));
        projCursor.close();
        return (project);
    }
    public ArrayList<Project> getProjects(){
        ArrayList<Project> projects=new ArrayList<Project>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor projCursor=db.query(ProjectContract.TABLE_NAME, null, null,null,null,null,null);
        while (projCursor.moveToNext()){
            Project project= new Project();
            long projectid=projCursor.getLong(projCursor.getColumnIndex(ProjectContract.ProjectEntry._ID));
            project.setId(projCursor.getLong(projCursor.getColumnIndex(ProjectContract.ProjectEntry._ID)));
            project.setName(projCursor.getString(projCursor.getColumnIndex(ProjectContract.ProjectEntry.COLOUMN_NAME_TITLE)));
            project.setRowCounters(getRowCounters(projectid));
            projects.add(project);
        }
        projCursor.close();
        return (projects);
    }
    private ArrayList<RowCounter> getRowCounters(long projectid){
        ArrayList<RowCounter> rowCounters=new ArrayList<RowCounter>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor countCursor=db.query(RowCounterContract.TABLE_NAME, null,RowCounterContract.RowCounterEntry.COLOUMN_NAME_PROJECT_ID+"=?",new String[]{String.valueOf(projectid)},null,null, RowCounterContract.RowCounterEntry._ID);
        while (countCursor.moveToNext()){
            RowCounter rowCounter= new RowCounter();
            rowCounter.setId(countCursor.getLong(countCursor.getColumnIndex(RowCounterContract.RowCounterEntry._ID)));
            long currentAmount=countCursor.getLong(countCursor.getColumnIndex(RowCounterContract.RowCounterEntry.COLOUMN_NAME_CURRENT_AMOUNT));
            long finalAmount=countCursor.getLong(countCursor.getColumnIndex(RowCounterContract.RowCounterEntry.COLOUMN_NAME_FINAL_AMOUNT));
            rowCounter.setCurrentAmount(currentAmount);
            rowCounter.setFinalAmount(finalAmount);
            rowCounters.add(rowCounter);
        }
        countCursor.close();
        return (rowCounters);
    }
    private void initializeExampleData(SQLiteDatabase db) {
        long projectid;
        ContentValues firstProjectvalues=new ContentValues();
        firstProjectvalues.put(ProjectContract.ProjectEntry.COLOUMN_NAME_TITLE, "Flashy Scarf");
        projectid=db.insert(ProjectContract.TABLE_NAME, null, firstProjectvalues);
        ContentValues firstProjectCountervalues=new ContentValues();
        firstProjectCountervalues.put(RowCounterContract.RowCounterEntry.COLOUMN_NAME_PROJECT_ID, projectid);
        firstProjectCountervalues.put(RowCounterContract.RowCounterEntry.COLOUMN_NAME_FINAL_AMOUNT, 120);
        db.insert(RowCounterContract.TABLE_NAME, null, firstProjectCountervalues);
        ContentValues secondProjectvalues=new ContentValues();
        secondProjectvalues.put(ProjectContract.ProjectEntry.COLOUMN_NAME_TITLE, "Simple Socks");
        projectid=db.insert(ProjectContract.TABLE_NAME, null, secondProjectvalues);
        ContentValues secondProjectCountervalues=new ContentValues();
        secondProjectCountervalues.put(RowCounterContract.RowCounterEntry.COLOUMN_NAME_PROJECT_ID, projectid);
        secondProjectCountervalues.put(RowCounterContract.RowCounterEntry.COLOUMN_NAME_FINAL_AMOUNT, 80);
        db.insert(RowCounterContract.TABLE_NAME, null, secondProjectCountervalues);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(ProjectContract.SQL_CREATE_TABLE);
        db.execSQL(RowCounterContract.SQL_CREATE_TABLE);
        initializeExampleData(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(ProjectsDatabaseHelper.class.getSimpleName(),"Upgrading database from version "+oldVersion+" to "+newVersion);
    }
    public void updateRowCounterCurrentAmount(RowCounter rowCounter){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues currentAmountValue=new ContentValues();
        currentAmountValue.put(RowCounterContract.RowCounterEntry.COLOUMN_NAME_CURRENT_AMOUNT, rowCounter.getCurrentAmount());
        db.update(RowCounterContract.TABLE_NAME, currentAmountValue, RowCounterContract.RowCounterEntry._ID+"=?",new String[]{String.valueOf(rowCounter.getId())});
    }

}

