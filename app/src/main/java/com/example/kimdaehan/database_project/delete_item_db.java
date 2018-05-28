package com.example.kimdaehan.database_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class delete_item_db extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    private ListView mListViewLayout			= null;
    private ListArrayAdapter mListArrayAdapter	= null;
    private ArrayList<ContactData> mCDataList	= null;
    SQLiteDatabase database;
    DB_hand dbMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        dbMgr = new DB_hand(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item_db);

        mCDataList = new ArrayList<ContactData>();
        getContactDBData(mCDataList);

        mListArrayAdapter = new ListArrayAdapter(this,
                R.id.list_item,
                mCDataList);
        mListViewLayout = (ListView)
                this.findViewById(R.id.listView);
        mListViewLayout.setAdapter(mListArrayAdapter);
        mListViewLayout.setOnItemClickListener(this);
    }

    private void getContactDBData(ArrayList<ContactData> aCDataList)
    {
        database = dbMgr.dbOpen();
        Cursor results = database.rawQuery("SELECT * FROM db_table_test  ORDER BY reg_id DESC", null);
        dbMgr.selectAll(results, aCDataList);
        dbMgr.dbClose(database);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        database = dbMgr.dbOpen();
        dbMgr.deleteData("DELETE FROM db_table_test " + "WHERE name=?",
                mListArrayAdapter.getItem(position));
        dbMgr.dbClose(database);

        mCDataList.remove(position);

        mListArrayAdapter.notifyDataSetChanged();
    }
}

