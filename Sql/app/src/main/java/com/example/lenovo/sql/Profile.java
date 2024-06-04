package com.example.lenovo.sql;

/**
 * Created by LENOVO on 25-07-2016.
 */
public class Profile {
    private long mId;
    private String mname;
    private String mgender;
    public  long getId(){
        return mId;
    }
    public void setId(long id){
        mId=id;
    }
    public String getName(){
        return mname;
    }
    public String getGender(){
        return mgender;
    }
    public void setName(String name){
        mname=name;
    }
    public void setGender(String gender){
        mgender=gender;
    }
}
