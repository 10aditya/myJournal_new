package com.obtestatus.myjournal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by Aditya on 16/06/2016.
 */
public class MyDB {

    private SQLiteDatabase db;
    public DBHelper dbhelper;

    public MyDB() {
        //empty constructor
    }

    public MyDB(Context context) {
        dbhelper = new DBHelper(context);
    }

    public void open() {
        db = dbhelper.getWritableDatabase();

    }

    public void close() {
        db.close();
    }

    //inserting new entry

    public long insertEntry(Entries entries) {
        ContentValues cv = new ContentValues();
        cv.put(Constants.TITLE_NAME, entries.getTitle());
        cv.put(Constants.MOOD, entries.getMood());
        cv.put(Constants.DATE_NAME, entries.getDate());
        cv.put(Constants.HIGHLIGHT_NAME, entries.getHighlights());
        return (db.insert(Constants.TABLE_NAME, null, cv));
    }

    // Getting single Entries
    Entries getEntry(int id) {
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME, new String[]{Constants.KEY_ID, Constants.TITLE_NAME, Constants.MOOD, Constants.DATE_NAME, Constants.HIGHLIGHT_NAME}, Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Entries entry = new Entries(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        // return Entry
        return entry;
    }

    //getting all entries
    public Cursor getEntries() {
        return dbhelper.getReadableDatabase().query(Constants.TABLE_NAME, null, null, null, null, null, null);
    }

    public Cursor getMood() {
        return dbhelper.getReadableDatabase().query(Constants.TABLE_NAME, new String[]{Constants.MOOD}, null, null, null, null, null);
    }

 /*   // Getting All Entriess
    public List<Entries> getAllEntriess() {
        List<Entries> entriesList = new ArrayList<Entries>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Constants.TABLE_NAME;

        SQLiteDatabase db = dbhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Entries entry = new Entries();
                entry.setID(Integer.parseInt(cursor.getString(0)));
                entry.setTitle(cursor.getString(1));
                entry.setMood(cursor.getString(2));
                entry.setDate(cursor.getString(3));
                entry.setHighlights(cursor.getString(4));
                // Adding contact to list
                entriesList.add(entry);
            } while (cursor.moveToNext());
        }

        // return contact list
        return entriesList;
    }
*/

    // Deleting single entry
    public void deleteEntry(Entries entry) {
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.delete(Constants.TABLE_NAME, Constants.KEY_ID + " = ?",
                new String[]{String.valueOf(entry.getID())});

    }

    // Updating single entry
    public int updateEntry(Entries entry) {
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(Constants.TITLE_NAME, entry.getTitle());
        cv.put(Constants.MOOD, entry.getMood());
        cv.put(Constants.DATE_NAME, entry.getDate());
        cv.put(Constants.HIGHLIGHT_NAME, entry.getHighlights());

        // updating row
        return db.update(Constants.TABLE_NAME, cv, Constants.KEY_ID + " = ?",
                new String[]{String.valueOf(entry.getID())});
    }

    // Getting entries Count
    public int getEntriesCount() {
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;

    }

}
