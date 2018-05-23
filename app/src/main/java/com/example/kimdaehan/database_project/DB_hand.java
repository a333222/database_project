package com.example.kimdaehan.database_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DB_hand
{
    private final String DB_NAME		= "db_table_test";
    private final int DB_VERSION	= 1;
    private int n =0;
    private Context mContext			= null;
    private OpenHelper mOpener		= null;
    private SQLiteDatabase mDbController	= null;

    private class OpenHelper extends SQLiteOpenHelper
    {
        public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
        {
            super(context, name, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase aDb)
        {
            aDb.execSQL("CREATE TABLE db_table_test " +
                    "(reg_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "name TEXT, " +
                    "make TEXT, " +
                    "buy TEXT , " +
                    "open TEXT, " +
                    "store TEXT, " +
                    "num TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)
        {
        }
    }

    public DB_hand(Context aContext)
    {
        this.mContext = aContext;
        this.mOpener = new OpenHelper(mContext, DB_NAME,
                null, DB_VERSION);
    }

    public SQLiteDatabase dbOpen()
    {
        return this.mDbController = mOpener.getWritableDatabase();
    }

    public void dbClose(SQLiteDatabase database)
    {
        database.close();
    }



    public void insertName(SQLiteDatabase db, String name,String made,String buy,String open,String store,String num)
    {
        db.beginTransaction();
        try
        {
            String sql = "INSERT INTO " + DB_NAME
                    + " VALUES( '"+ (n++) + "','" + name + "', '" + made + "', '" + buy + "', '" + open + "', '" + store +"', '" + num + "');";
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            db.endTransaction();
        }
    }

    /*
    public void deleteData(String aSql, ContactData aCData)
    {
        String[] sqlData = {aCData.getPhoneNumber()};

        this.mDbController.execSQL(aSql, sqlData);
    }*/

    public void selectAll(Cursor results, ArrayList<ContactData> aCDataList)
    {
        //Cursor results = db.rawQuery(aSql, null);
        results.moveToFirst();

        while(!results.isAfterLast())
        {
            ContactData cData = new ContactData(
                    results.getString(1),
                    results.getString(2),
                    results.getString(3),
                    results.getString(4),
                    results.getString(5),
                    results.getString(6));
            aCDataList.add(cData);
            results.moveToNext();
        }
        results.close();
    }
}
