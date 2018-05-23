package com.example.kimdaehan.database_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class check_item extends AppCompatActivity
{
    SQLiteDatabase database;
    DB_hand dbMgr;
    private ListView mListViewLayout			= null;
    private ListArrayAdapter mListArrayAdapter	= null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dbMgr = new DB_hand(this);
        setContentView(R.layout.item_select);

        ArrayList<ContactData> cDataList = new ArrayList<ContactData>();
        getContactDBData(cDataList);

        mListArrayAdapter = new ListArrayAdapter(this,
                R.id.list_item,
                cDataList);
        mListViewLayout = (ListView)
                this.findViewById(R.id.listView);
        mListViewLayout.setAdapter(mListArrayAdapter);
    }

    private void getContactDBData(ArrayList<ContactData> aCDataList)
    {
        database = dbMgr.dbOpen();
        Cursor results = database.rawQuery("SELECT * FROM db_table_test  ORDER BY reg_id DESC", null);
        dbMgr.selectAll(results, aCDataList);
        dbMgr.dbClose(database);
    }
}

