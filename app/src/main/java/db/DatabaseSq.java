package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class DatabaseSq extends SQLiteOpenHelper
{
    public static final String DatabaseName="Sport.db";
    public DatabaseSq(Context con)
    {
        super(con, DatabaseName, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE User(Id INTEGER PRIMARY KEY,Name VARCHAR(50))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }
    public String insert(int i,String n)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Id",i);
        values.put("Name",n);
        long re=db.insert("User",null,values);
        if(re==-1)
        {
            return "erreur";
        }
        else
        {
            return "inserted row";
        }
    }
}
