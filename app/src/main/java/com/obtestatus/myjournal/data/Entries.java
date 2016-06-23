package com.obtestatus.myjournal.data;

/**
 * Created by Aditya on 18/06/2016.
 */
public class Entries {

    //private variables
    int _id;
    String _title;
    String _date, _mood, _highlights;

    // Empty constructor
    public Entries(){

    }
    // constructor
    public Entries(int id, String title, String mood, String date, String highlights){
        this._id = id;
        this._title = title;
        this._mood = mood;
        this._date = date;
        this._highlights = highlights;
    }

    // constructor
    public Entries(String title, String mood, String date, String highlights){
        this._title = title;
        this._mood = mood;
        this._date = date;
        this._highlights = highlights;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting title
    public String getTitle(){
        return this._title;
    }

    // setting title
    public void setTitle(String title){
        this._title = title;
    }

    // getting mood
    public String getMood(){
        return this._mood;
    }

    // setting mood
    public void setMood(String mood){
        this._mood = mood;
    }

    // getting date
    public String getDate(){
        return this._date;
    }

    // setting date
    public void setDate(String date){
        this._date = date;
    }

    // getting highlights
    public String getHighlights(){
        return this._highlights;
    }

    // setting highlights
    public void setHighlights(String highlights){
        this._highlights = highlights;
    }

}
