package com.obtestatus.myjournal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Aditya on 16/06/2016.
 */
public class MyDB {

    private SQLiteDatabase db;
    private DBHelper dbhelper;

    public MyDB(Context context){
        dbhelper = new DBHelper(context);
    }

    public void open(){
        db = dbhelper.getWritableDatabase();

    }

    public void close(){
        db.close();
    }

    public long insertEntry(String title, String mood, String date, String highlite){
        ContentValues cv = new ContentValues();
        cv.put(Constants.TITLE_NAME, title);
        cv.put(Constants.MOOD, mood);
        cv.put(Constants.DATE_NAME, date);
        cv.put(Constants.HIGHLIGHT_NAME, highlite);
        return(db.insert(Constants.TABLE_NAME, null, cv));
    }
}
