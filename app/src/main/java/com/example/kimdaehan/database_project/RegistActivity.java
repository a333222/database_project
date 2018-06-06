package com.example.kimdaehan.database_project;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    DB_hand dbmgr ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("회원가입");

        //등록버튼 onClick()메소드 실행

        Button btnJoin = (Button)findViewById(R.id.registerbutton) ;
        btnJoin.setOnClickListener(this);

    }


    public void onClick(View view){
        //회원 정보 가져오기
        EditText memberId = (EditText)findViewById(R.id.idText) ;
        EditText memberPwd = (EditText)findViewById(R.id.passwordText) ;
        EditText memberEmail = (EditText)findViewById(R.id.emailText) ;
        EditText memberName = (EditText)findViewById(R.id.nameText) ;


        String userId = memberId.getText().toString() ;
        String userPwd = memberPwd.getText().toString() ;
        String userEmail = memberEmail.getText().toString() ;
        String userName = memberName.getText().toString() ;




        dbmgr = new DB_hand(this) ;
        // (id text,password text,email text , name text,gender text)

        Log.d("dd",userName) ;
        Log.d("dd",userPwd) ;
        dbmgr.register(dbmgr.dbOpen(),userId,userPwd,userEmail,userName);

        dbmgr.dbClose(dbmgr.dbOpen());

        Intent intent =new Intent(this,LoginActivity.class) ;


        startActivity(intent) ;


        finish();


    }





}