package com.example.kimdaehan.database_project;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBManager extends SQLiteOpenHelper {

    //db를 생성 (이미 생성된 경우에 생성하지 않음
    public DBManager(Context context){
        super(context,"memberDB",null,1);

    }

    public void onCreate(SQLiteDatabase db){

        //테이블 생성 (이미 생성한 경우 생성되지 않음




        String sql  = "create table member (id text,password text,email text , name text,gender text);" ;

        db.execSQL(sql);
    }


    public void onUpgrade(SQLiteDatabase arg, int arg1,int arg2){

    }
}
