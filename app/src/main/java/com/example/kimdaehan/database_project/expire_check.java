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
        dbMgr.insert(database,"소고기","1. 신선한 고기는 거의 아무런 냄새가 나지 않지만 상한 소고기는 시큼한 냄새가 날 수 있다\n" +
                "\n" +
                "2. 상하면 상할수록 소고기의 육질이 갈라져 있다\n" +
                "\n" +
                "3. 고기의 색깔이 푸른색을 띄거나 갈색을 띄워 본래의 붉은 빛을 잃어버리게 된다\n" +
                "\n","구역, 구토, 설사, 복통, 발열");
        dbMgr.insert(database,"돼지고기","멍이 든 것처럼 회색빛이 돌게 됩니다.상했을 경우 구역질이 날 정도의 심한 냄새","잠복기는 수시간에서 5일까지이며, 보통 2~3일이다. 복통을 동반하지 않는 급성 수양성(물 같은) 설사와 오심, 구토가 나타난다");
        dbMgr.insert(database,"양파"," 만졌을때 물렁하게 느껴진다면 상한 것이니 버리는 것이 좋습니다.","");
        dbMgr.insert(database,"파","겉이 검게 변해있다면 속은 더 심하게 무른 상태라고 볼 수 있으니 버리는 것이 좋습니다.\n" +
                "\n","구역, 구토, 설사, 복통, 발열");
        dbMgr.insert(database,"마늘","마늘 상태가 끈적하다면 상하는 중이니 빨리 섭취하는 것이 좋습니다.\n" +
                "\n","구역, 구토, 설사, 복통, 발열");
        dbMgr.insert(database,"당근","야채를 만졌을때 물렁하게 느껴진다면 상한 것이니 버리는 것이 좋습니다.","구역, 구토, 설사, 복통, 발열");
        dbMgr.insert(database,"우유","신맛","소비기한 45일");
        dbMgr.insert(database,"회","비린내, 흐물거림","2~4일 이내 섭취");
        dbMgr.insert(database,"오이","흐물거림,미끄러움","신문지에 보관");
        dbMgr.insert(database,"바나나","벌레꼬임","상온보관");
        Cursor results = database.rawQuery("SELECT * FROM expire_db", null);
        dbMgr.select(results, aCDataList);
        dbMgr.dbClose(database);
    }
}

