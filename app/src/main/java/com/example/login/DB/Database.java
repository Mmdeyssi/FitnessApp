package com.example.login.DB;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final String DBname = "fitnes1";

    public Database(Context con){
        super(con,DBname,null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE test1 (fullname TEXT,email TEXT PRIMARY KEY ,phone INTEGER , password TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS test1");
        onCreate(db);
    }
    public String insert_data(String fname,String email,int phone,String password ){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("fullname",fname);
        values.put("email",email);
        values.put("phone",phone);
        values.put("password",password);

        long R = database.insert("test1", null, values);

        if (R==-1)
            return "insertion error";
        else
            return "inserted row";
    }
    public ArrayList<users> get_data()
    {
        ArrayList<users> data = new ArrayList<users>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM test1",null);
        c.moveToFirst();
        while(c.isAfterLast()==false)
        {
            data.add(new users(c.getString(0),
                    c.getString(1),

                    c.getInt(2),
                    c.getString(3)));
            c.moveToNext();

        }

        return data;
    }

    public void update(String fname,String email,String password,int phone){
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put("fname",fname);
        val.put("email",email);
        val.put("pass",password);
        val.put("ph",phone);
        sq.update("test1",val,"email=?",new String[]{email});


    }
    public void delete(String email)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        sq.delete("test1","email=?",new String[]{email});
    }



}

