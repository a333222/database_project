package com.example.kimdaehan.database_project;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends Activity implements View.OnClickListener {
    private DBManager dbMgr ;
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main_login);
       //등록버튼 onClick() 메소드 실행

        Button btnLogin = (Button)findViewById(R.id.loginbutton) ;
        btnLogin.setOnClickListener(this);

        Button btnSignup = (Button)findViewById(R.id.registbutton) ;
        btnSignup.setOnClickListener(this);

    }

    public void onClick(View view){

        LinearLayout layout = (LinearLayout)findViewById(R.id.main_login) ;


        //회원가입 버튼을 클릭할 경우 회원가입 페이지로 이동

        if(view.getId() == R.id.registbutton){
            Intent intent = new Intent(this,RegistActivity.class) ;


            startActivity(intent);

            finish();
        }

        //로그인 버튼을 누른 경우 로그인 시도

        //아이디 가져오기

        EditText edId = (EditText)findViewById(R.id.idText) ;
        String userId= edId.getText().toString() ;



        //비밀번호 가져오기

        EditText edPwd = (editText)findViewById(R.id.textPassword) ;
        String userPwd = edPwd.getText().toString() ;

        try {
            dbMgr = new DBManager(this);

            SQLiteDatabase db =  dbMgr.getReadableDatabase();


            Cursor cursor = db.rawQuery("select id,password from member where id="+userId,null) ;
            while (cursor.moveToNext()) {
                String memberId = cursor.getString(0);
                String memberUser = cursor.getString(1);


                if (edPwd.equals(memberUser) && edId.equals(memberId)) {
                    Intent intent = new Intent(this, check_item.class);
                    startActivity(intent);
                    finish();
                } else {
                    TextView defalutTextView = new TextView(this);
                    defalutTextView.append("아이디 & 비밀번호가 맞지 않습니다.");
                    layout.addView(defalutTextView);
                }
            }

            cursor.close();
            dbMgr.close();
        }catch(SQLException e){
            TextView errorTextView = new TextView(this) ;
            errorTextView.append("db 접속 장애");
            layout.addView(errorTextView);
        }



    }
}
