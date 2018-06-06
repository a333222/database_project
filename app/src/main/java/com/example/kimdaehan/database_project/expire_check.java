package com.example.kimdaehan.database_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class expire_check extends AppCompatActivity
{
    SQLiteDatabase database;
    DB_hand dbMgr;
    private ListView mListViewLayout			= null;
    private ListArrayAdapter2 mListArrayAdapter	= null;
    //주석
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dbMgr = new DB_hand(this);
        setContentView(R.layout.item_select);

        ArrayList<ContactData2> cDataList = new ArrayList<ContactData2>();
        getContactDBData(cDataList);

        mListArrayAdapter = new ListArrayAdapter2(this,
                R.id.list_item,
                cDataList);
        mListViewLayout = (ListView)
                this.findViewById(R.id.listView);
        mListViewLayout.setAdapter(mListArrayAdapter);
    }

    private void getContactDBData(ArrayList<ContactData2> aCDataList)
    {
        database = dbMgr.dbOpen();
        dbMgr.insert(database,"소고기","","");
        dbMgr.insert(database,"돼지고지","","");
        dbMgr.insert(database,"양파","","");
        dbMgr.insert(database,"파","","");
        dbMgr.insert(database,"마늘","","");
        dbMgr.insert(database,"당근","","");
        dbMgr.insert(database,"우유","","");
        dbMgr.insert(database,"회","","");
        dbMgr.insert(database,"오이","","");
        dbMgr.insert(database,"바나나","","");
        Cursor results = database.rawQuery("SELECT * FROM expire_db", null);
        dbMgr.select(results, aCDataList);
        dbMgr.dbClose(database);
    }
}

