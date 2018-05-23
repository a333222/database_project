package com.example.kimdaehan.database_project;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class hand_write extends AppCompatActivity implements View.OnClickListener
{
    SQLiteDatabase database;
    DB_hand dbMgr;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dbMgr = new DB_hand(this);
        setContentView(R.layout.activity_hand_write);

        Button addButton = (Button)
                this.findViewById(R.id.button_hand_db);
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int result = 0;
        switch(v.getId())
        {
            case R.id.button_hand_db:
                insertDB();
                break;
            default:
                break;
        }
    }


    private int insertDB()
    {
        int result 		= 0;
        String DB_NAME		= "db_table_test";
        String name		= null;
        String make		= null;
        String buy		= null;
        String open		= null;
        String store	= null;
        String num		= null;

        EditText nameEdit = (EditText)
                this.findViewById(R.id.edit_item_name);
        name = nameEdit.getEditableText().toString();

        EditText makeEdit = (EditText)
                this.findViewById(R.id.edit_made);
        make = makeEdit.getEditableText().toString();

        EditText buyEdit = (EditText)
                this.findViewById(R.id.edit_buy);
        buy = buyEdit.getEditableText().toString();

        EditText openEdit = (EditText)
                this.findViewById(R.id.edit_open);
        open = openEdit.getEditableText().toString();

        EditText storeEdit = (EditText)
                this.findViewById(R.id.edit_store);
        store = storeEdit.getEditableText().toString();

        EditText numEdit = (EditText)
                this.findViewById(R.id.edit_num);
        num = numEdit.getEditableText().toString();

        ContactData cData = new ContactData(name,
                make,
                buy,
                open,
                store,
                num);


        database = dbMgr.dbOpen();
        dbMgr.insertName(database, name, make, buy, open, store, num);
        dbMgr.dbClose(database);

        return result;
    }
}