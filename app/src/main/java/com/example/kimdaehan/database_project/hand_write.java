package com.example.kimdaehan.database_project;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Database_hand.DB_hand;


public class hand_write extends AppCompatActivity {

    Button btn_add;
    EditText et_name;
    EditText et_made;
    EditText et_buy;
    EditText et_open;
    EditText et_store;
    EditText et_num;

    StringBuffer sb;
    int version = 1;

    DB_hand helper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_write);
        setUp();
    }

    private void setUp()
    {
        btn_add = (Button)findViewById(R.id.button_hand_db);
        et_name = (EditText)findViewById(R.id.edit_item_name);
        et_made = (EditText)findViewById(R.id.edit_made);
        et_buy= (EditText)findViewById(R.id.edit_buy);
        et_open = (EditText)findViewById(R.id.edit_open);
        et_store = (EditText)findViewById(R.id.edit_num);
        et_num = (EditText)findViewById(R.id.edit_store);

        btn_add.setOnClickListener(myListener);

        helper = new DB_hand(hand_write.this, DB_hand.tableName, null, version);
        database = helper.getWritableDatabase();
        sb = new StringBuffer();
    }


    View.OnClickListener myListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.button_hand_db :
                    sb.setLength(0);
                    helper.insertName(database,(et_name.getText().toString())
                            ,(et_made.getText().toString())
                            ,(et_buy.getText().toString())
                            ,(et_open.getText().toString())
                            ,(et_store.getText().toString())
                            ,(et_num.getText().toString()));
                    //nameList(); //뿌려주는 역활
                    break;
            }
        }
    };
}