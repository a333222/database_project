package com.example.kimdaehan.database_project;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    DBManager dbmgr ;
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


        RadioGroup radioGroupGender = (RadioGroup)findViewById(R.id.genderGroup) ;
        String memberGender ="여자" ;
        if(radioGroupGender.getCheckedRadioButtonId() ==R.id.genderMan){
            memberGender ="남자" ;
        }

        dbmgr = new DBManager(this) ;
        // (id text,password text,email text , name text,gender text)
        try {
            SQLiteDatabase sqLiteDatabase = dbmgr.getWritableDatabase();
            StringBuffer sql = new StringBuffer( ) ;
            sql.append("insert into customers Values(") ;
            sql.append("'"+userId+"'");
            sql.append("'"+userPwd+"'");
            sql.append("'"+userEmail+"'");
            sql.append("'"+userName+"'");
            sql.append("'"+memberGender+"'");
            sqLiteDatabase.execSQL(sql.toString());
        }catch (SQLException e){

        }finally {
            dbmgr.close();
        }

        Intent intent =new Intent(this,LoginActivity.class) ;


        startActivity(intent) ;

        finish();


    }





}