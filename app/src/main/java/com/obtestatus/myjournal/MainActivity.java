package com.obtestatus.myjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.obtestatus.myjournal.data.MyDB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static RelativeLayout yy;
    static EditText xx, title, date, highlight;
    static FrameLayout myFrame;
    MyDB myDB;
    Button b_cancel, b_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xx = (EditText) findViewById(R.id.editText2);

        xx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Pop.class));

            }
        });

        myFrame = (FrameLayout) findViewById(R.id.frame);
        yy = (RelativeLayout) findViewById(R.id.relativeLayout);
        title = (EditText) findViewById(R.id.editText1);
        highlight = (EditText) findViewById(R.id.editText3);
        date = (EditText) findViewById(R.id.editText5);
        b_cancel = (Button) findViewById(R.id.button15);
        b_save = (Button) findViewById(R.id.button16);
        myDB = new MyDB(this);

        b_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Main2Activity.class));

            }
        });

        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveToDB();

            }
        });

    }

    public void saveToDB(){
        myDB.open();
        String entryTitle = title.getText().toString();
        String entryDate = date.getText().toString();
        String entryMood = xx.getText().toString();
        String entryHighlight = highlight.getText().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
        Date date = new Date();

        myDB.insertEntry(entryTitle,entryMood, entryDate, entryHighlight);
        myDB.close();


        Log.d("Database Updated", entryTitle + " added to db" );
    }
}
