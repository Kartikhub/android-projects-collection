package com.example.lenovo.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 25-07-2016.
 */
public class SqlFirstHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="First.db";
    public static final int DATABASE_VERSION=1;
    public SqlFirstHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void createProfile(String userName, String gender){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues profilevalues=new ContentValues();
        profilevalues.put(ProfileContract.ProfileColoumns.COLOUMN_NAME, userName);
        profilevalues.put(ProfileContract.ProfileColoumns.COLOUMN_GENDER, gender);
        db.insert(ProfileContract.TABLE_NAME, null, profilevalues);
        db.close();
    }
    public Profile getProfile(long id){
        SQLiteDatabase db=getReadableDatabase();
        Cursor profcursor=db.query(ProfileContract.TABLE_NAME,null, ProfileContract.ProfileColoumns._ID+"=?", new String[]{String.valueOf(id)},null,null,null);
    profcursor.moveToNext();
        Profile profile=new Profile();
        profile.setId(profcursor.getLong(profcursor.getColumnIndex(ProfileContract.ProfileColoumns._ID)));
        profile.setName(profcursor.getString(profcursor.getColumnIndex(ProfileContract.ProfileColoumns.COLOUMN_NAME)));
        profile.setGender(profcursor.getString(profcursor.getColumnIndex(ProfileContract.ProfileColoumns.COLOUMN_GENDER)));
        profcursor.close();
        return profile;

    }
    public Profile getProfile(String profstr){
        SQLiteDatabase db=getReadableDatabase();
        Cursor profcursor=db.query(ProfileContract.TABLE_NAME,null, ProfileContract.ProfileColoumns.COLOUMN_NAME+"=?", new String[]{String.valueOf(profstr)},null,null,null);
        profcursor.moveToNext();
        Profile profile=new Profile();
        profile.setId(profcursor.getLong(profcursor.getColumnIndex(ProfileContract.ProfileColoumns._ID)));
        profile.setName(profcursor.getString(profcursor.getColumnIndex(ProfileContract.ProfileColoumns.COLOUMN_NAME)));
        profile.setGender(profcursor.getString(profcursor.getColumnIndex(ProfileContract.ProfileColoumns.COLOUMN_GENDER)));
        profcursor.close();
        return profile;

    }
    public ArrayList<Profile> getprofiles(){
        ArrayList<Profile> profiles= new ArrayList<Profile>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor profscursor=db.query(ProfileContract.TABLE_NAME,null, null, null , null, null, null);
        while (profscursor.moveToNext()){
             Profile profile= new Profile();
            profile.setId(profscursor.getLong(profscursor.getColumnIndex(ProfileContract.ProfileColoumns._ID)));
            profile.setName(profscursor.getString(profscursor.getColumnIndex(ProfileContract.ProfileColoumns.COLOUMN_NAME)));
            profile.setGender(profscursor.getString(profscursor.getColumnIndex(ProfileContract.ProfileColoumns.COLOUMN_GENDER)));
             profiles.add(profile);
        }
        profscursor.close();
        return profiles;

    }
public void updateProfile(Profile profile){
    SQLiteDatabase db=getWritableDatabase();
   ContentValues updatevalues=new ContentValues();
    updatevalues.put(ProfileContract.ProfileColoumns.COLOUMN_NAME, profile.getName());
    updatevalues.put(ProfileContract.ProfileColoumns.COLOUMN_GENDER, profile.getGender());
    db.update(ProfileContract.TABLE_NAME,updatevalues, ProfileContract.ProfileColoumns._ID+"=?", new String[]{String.valueOf(profile.getId())});
db.close();
}
    public void deleteprofile(Profile profile){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(ProfileContract.TABLE_NAME, ProfileContract.ProfileColoumns._ID+"=?", new String[]{String.valueOf(profile.getId())});
        db.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(ProfileContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(SqlFirstHelper.class.getSimpleName(), "Upgrading database from version "+oldVersion+" to "+newVersion);
    }
}
