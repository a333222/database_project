package Database_hand;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_hand extends SQLiteOpenHelper
{

    public static final String tableName = "hand_write_table";

    public DB_hand(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void createTable(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + tableName+"("
                + "name text,"
                + "made text,"
                + "buy text,"
                + "open text,"
                + "store text,"
                + "num text"
                + ");";
        try
        {
            db.execSQL(sql);
        }
        catch (SQLException e)
        {
        }
    }

    public void insertName(SQLiteDatabase db, String name,String made,String buy,String open,String store,String num)
    {
        db.beginTransaction();
        try
        {
            String sql = "INSERT INTO " + tableName
                    + " VALUES('" + name + "' '" + made + "' '" + buy + "' '" + open + "' '" + store +"' '" + num + "');";
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

}