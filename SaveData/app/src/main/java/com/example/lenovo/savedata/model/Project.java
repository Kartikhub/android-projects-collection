package com.example.lenovo.savedata.model;

import java.util.ArrayList;

/**
 * Created by LENOVO on 17-07-2016.
 */
public class Project {
    private long mId;
    private String mName;
    private ArrayList<RowCounter> mRowCounters=new ArrayList<RowCounter>();

    public long getId(){

        return mId;
    }
    public void setId(long id)
    {
        mId=id;
    }
    public String getName(){

        return mName;
    }
    public  void setName(String name){
        mName=name;
    }
    public ArrayList<RowCounter> getRowCounters(){

        return (mRowCounters);
    }
    public  void setRowCounters(ArrayList <RowCounter> rowCounters){
        mRowCounters=rowCounters;
    }
}

