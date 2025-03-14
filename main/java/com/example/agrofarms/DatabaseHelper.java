package com.example.agrofarms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String user_db="user";
//    public static final String email = ""


    public static final String cart_db="cart";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table alluser(email text primary key, username text, password text,contact text(10))");

        String createTable = "CREATE TABLE " +user_db+" (email text primary key, username text, password text,contact text(10))";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists "+user_db);
        onCreate(db);

    }
    public Boolean insertdata(String email,String username,String password,String contact ){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues= new ContentValues();
        contentvalues.put("email",email);
        contentvalues.put("username",username);
        contentvalues.put("password",password);
        contentvalues.put("contact",contact);
        long result= db.insert("user",null,contentvalues);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

    public Boolean checkemail(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkpassword(String username, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from user where username = ? and password = ?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

}

