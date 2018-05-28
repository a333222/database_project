package com.example.kimdaehan.database_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button_expire :
                //Intent intent1 = new Intent(getApplicationContext(),MyTwo.class)
                //startActivity(intent1);
                break;
            case R.id.button_barcode : //바코드
                Intent intent2 = new Intent(getApplicationContext(), barcode.class);
                startActivity(intent2);
                break;
            case R.id.button_hand : //수기입력
                Intent intent3 = new Intent(getApplicationContext(),hand_write.class);
                startActivity(intent3);
                break;
            case R.id.button_check : //확인
                Intent intent4 = new Intent(getApplicationContext(),check_item.class);
                startActivity(intent4);
                break;
            case R.id.button_delete : //확인
                Intent intent5 = new Intent(getApplicationContext(),delete_item_db.class);
                startActivity(intent5);
                break;
        }
    }
}
