package com.example.kimdaehan.database_project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {

    DB_hand dbMgr ;

    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main_login);
       //등록버튼 onClick() 메소드 실행
        Button btnLogin = (Button)findViewById(R.id.login_button) ;
        btnLogin.setOnClickListener(this);
        Button btnSignup = (Button)findViewById(R.id.register_button) ;
        btnSignup.setOnClickListener(this);

    }

    public void onClick(View view){

        LinearLayout layout = (LinearLayout)findViewById(R.id.main_login) ;


        //회원가입 버튼을 클릭할 경우 회원가입 페이지로 이동

        if(view.getId() == R.id.register_button){
            Intent intent = new Intent(this,RegistActivity.class) ;


            startActivity(intent);

            finish();
        }else if(view.getId() == R.id.login_button){
            //로그인 버튼을 누른 경우 로그인 시도

          //  SQLiteDatabase sqLiteDatabase = dbMgr.getWritableDatabase();
            //StringBuffer sql = new StringBuffer( ) ;
            //sql.append("create table memebers (User_id PRIMARY KEY,password text,email text , name text,gender text);") ;
           // sqLiteDatabase.execSQL(sql.toString());
           // Toast.makeText(LoginActivity.this, "권한요청을 거부했습니다.", Toast.LENGTH_SHORT).show();
            //아이디 가져오기

            EditText edId = (EditText)findViewById(R.id.idText) ;
            String userId= edId.getText().toString() ;
            Log.d("dddd",userId);


            //비밀번호 가져오기

            EditText edPwd = (EditText)findViewById(R.id.passwordText) ;
            String userPwd = edPwd.getText().toString() ;
            Log.d("ddddd",userPwd) ;

            try {
                dbMgr = new DB_hand(this);
                SQLiteDatabase db =dbMgr.dbOpen() ;
                Log.d("dddd","dbOPen ok  ") ;

                Cursor cursor = db.rawQuery("select id,password from member where id="+userId+";",null) ;
                Log.d("dddd","cursor ok ") ;
                while (cursor.moveToNext()) {
                    String memberId = cursor.getString(0);
                    Log.d("dddd",cursor.getString(0)) ;
                    Log.d("dddd",memberId) ;



                    String memberPwd = cursor.getString(1);
                    Log.d("dddd",memberPwd) ;



                    if (userPwd.equals(memberPwd) && userId.equals(memberId)) {
                        Intent intent = new Intent(this, select.class);
                        startActivity(intent);
                        finish();
                    } else {
                        TextView defalutTextView = new TextView(this);
                        defalutTextView.append("아이디 & 비밀번호가 맞지 않습니다.");
                        layout.addView(defalutTextView);
                    }
                }

                cursor.close();
                db.close();
            }catch(SQLException e){
                TextView errorTextView = new TextView(this) ;
                errorTextView.append("db 접속 장애");
                layout.addView(errorTextView);
            }
            finish();
        }

    }
}
