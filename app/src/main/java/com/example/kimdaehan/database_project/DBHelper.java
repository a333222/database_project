package com.example.kimdaehan.database_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       // db.execSQL("Create TABLE member (User_ID PRIMARY KEY, USER_Password) ;");

        String sql  = "create table member (User_id PRIMARY KEY,password text,email text , name text,gender text);" ;

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String create_at , String userId , String userPwd){
        SQLiteDatabase db = getWritableDatabase() ;

        db.execSQL("insert into member values("+userId+","+userPwd+")");


        db.close();


    }


    public String getResult(){
        SQLiteDatabase db = getReadableDatabase() ;
        String result = "" ;

        Cursor cursor = db.rawQuery("select * from user",null
        ) ;

        while (cursor.moveToNext()){

            result +=cursor.getString(0)+":"
                     +cursor.getString(1)+'\n' ;

        }

        return result ;
    }
}

