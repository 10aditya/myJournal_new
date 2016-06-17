package com.obtestatus.myjournal.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aditya on 16/06/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
// create table query - SQLite
    private static final String CREATE_TABLE = "create table " +
            Constants.TABLE_NAME + " (" +
            Constants.KEY_ID + " integer primary key autoincrement, " +
            Constants.TITLE_NAME + " text not null, " +
            Constants.HIGHLIGHT_NAME + " text not null, " +
            Constants.MOOD + " text not null, " +
            Constants.DATE_NAME + " text not null) ";

    public DBHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exists " + Constants.TABLE_NAME);
        onCreate(db);
    }
}
