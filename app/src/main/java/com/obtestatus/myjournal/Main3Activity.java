package com.obtestatus.myjournal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.obtestatus.myjournal.data.Constants;
import com.obtestatus.myjournal.data.Entries;
import com.obtestatus.myjournal.data.MyDB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class
Main3Activity extends AppCompatActivity {

    FrameLayout myFrame2;
    RelativeLayout r_l;
    EditText tv1, tv2, tv3, tv4;
    String mood_for_color;
    Button b_edit, b_back;
    Toolbar toolbar;
    MyDB myDB;
    int w;
    int iD, flag = 0;
    ImageView imageView;

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        toolbar = (Toolbar) findViewById(R.id.vieww);
        tv1 = (EditText) findViewById(R.id.editText4);
        tv2 = (EditText) findViewById(R.id.editText6);
        tv3 = (EditText) findViewById(R.id.editText7);
        tv4 = (EditText) findViewById(R.id.editText8);
        myFrame2 = (FrameLayout) findViewById(R.id.frame2);
        myFrame2 = (FrameLayout) findViewById(R.id.frame2);
        r_l = (RelativeLayout) findViewById(R.id.relativeLayout4);
        b_edit = (Button) findViewById(R.id.button18);
        b_back = (Button) findViewById(R.id.button17);
        imageView = (ImageView) findViewById(R.id.image);
        myDB = new MyDB(this);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        w = dm.heightPixels;
        position = getIntent().getIntExtra("Clicked_item", 0);
        SimpleCursorAdapter adapter = (SimpleCursorAdapter) Main2Activity.myEntries2.getAdapter();
        Cursor myCursor = adapter.getCursor();
        toolbar.setPadding(0, 0, 30, 0);
        setSupportActionBar(toolbar);
        imageView.setLayoutParams(new Toolbar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int)(w*(0.085))));
        myCursor.moveToPosition(position);

        tv1.setText(myCursor.getString(myCursor.getColumnIndexOrThrow(Constants.TITLE_NAME)));
        tv2.setText(myCursor.getString(myCursor.getColumnIndexOrThrow(Constants.MOOD)));
        tv3.setText(myCursor.getString(myCursor.getColumnIndexOrThrow(Constants.DATE_NAME)));
        tv4.setText(myCursor.getString(myCursor.getColumnIndexOrThrow(Constants.HIGHLIGHT_NAME)));
        iD = Integer.parseInt(myCursor.getString(myCursor.getColumnIndexOrThrow(Constants.KEY_ID)));

        mood_for_color = tv2.getText().toString();

        set_colors(mood_for_color);

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));
                finish();
            }
        });

        b_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (b_edit.getText().toString().equals("EDIT")) {
                    tv1.setInputType(InputType.TYPE_CLASS_TEXT);
                    tv2.setInputType(InputType.TYPE_CLASS_TEXT);
                    tv4.setInputType(InputType.TYPE_CLASS_TEXT);
                    tv4.setSingleLine(false);
                    b_edit.setText("SAVE");
                }

                if (b_edit.getText().toString().equals("SAVE")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                    Date date = new Date();
                    myDB.open();
                    myDB.updateEntry(new Entries(iD, tv1.getText().toString(), tv2.getText().toString(), sdf.format(date), tv4.getText().toString()));
                    myDB.close();
                    if(flag==1)
                    Toast.makeText(Main3Activity.this, "Entry Updated...", Toast.LENGTH_LONG).show();
                }

                flag = 1;

            }

        }
        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.share_entry) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, "-> Few words which describes my whole day : \n\n" + tv1.getText() +
            "\n\n-> Mood : " + tv2.getText() + "\n\n-> Date : " + tv3.getText() + "\n\n-> Some of highlights of the day : \n\n" + tv4.getText());
            intent.setType("text/plain");
            startActivity(intent);
            return true;
        } else if (id == R.id.delete_entry) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DELETE);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            Date date = new Date();
            myDB.open();
            myDB.deleteEntry(new Entries(iD, tv1.getText().toString(), tv2.getText().toString(), sdf.format(date), tv4.getText().toString()));
            myDB.close();
            Toast.makeText(Main3Activity.this, "Entry Deleted...", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Main3Activity.this, Main2Activity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void set_colors(String xxx) {

        switch (xxx) {
            case "HAPPY": {
                myFrame2.setBackgroundResource(R.color.m_c5);
                r_l.setBackgroundResource(R.color.m_c1);
                break;
            }
            case "SAD": {
                myFrame2.setBackgroundResource(R.color.m_c3);
                r_l.setBackgroundResource(R.color.m_c2);
                break;
            }
            case "ANGRY": {
                myFrame2.setBackgroundResource(R.color.m_c2);
                r_l.setBackgroundResource(R.color.m_c3);
                break;
            }
            case "ROMANTIC": {
                myFrame2.setBackgroundResource(R.color.m_c24);
                r_l.setBackgroundResource(R.color.colorAccent);
                break;
            }
            case "BLISSED": {
                myFrame2.setBackgroundResource(R.color.m_c4);
                r_l.setBackgroundResource(R.color.m_c6);
                break;
            }
            case "EXCITED": {
                myFrame2.setBackgroundResource(R.color.m_c10);
                r_l.setBackgroundResource(R.color.m_c9);
                break;
            }
            case "ALONE": {
                myFrame2.setBackgroundResource(R.color.m_c20);
                r_l.setBackgroundResource(R.color.m_c11);
                break;
            }
            case "STRESSED": {
                myFrame2.setBackgroundResource(R.color.m_c13);
                r_l.setBackgroundResource(R.color.m_c12);
                break;
            }
            case "SHOCKED": {
                myFrame2.setBackgroundResource(R.color.m_c15);
                r_l.setBackgroundResource(R.color.m_c14);
                break;
            }
            case "APOLOGETIC": {
                myFrame2.setBackgroundResource(R.color.m_c6);
                r_l.setBackgroundResource(R.color.m_c16);
                break;
            }
            case "GUILTY": {
                myFrame2.setBackgroundResource(R.color.m_c17);
                r_l.setBackgroundResource(R.color.m_c18);
                break;
            }
            case "SATISFIED": {
                myFrame2.setBackgroundResource(R.color.m_c20);
                r_l.setBackgroundResource(R.color.m_c19);
                break;
            }
            case "CRAZY": {
                myFrame2.setBackgroundResource(R.color.m_c22);
                r_l.setBackgroundResource(R.color.m_c21);
                break;
            }
            case "BORED": {
                myFrame2.setBackgroundResource(R.color.m_c23);
                r_l.setBackgroundResource(R.color.m_c11);
                break;
            }
            default: {
                myFrame2.setBackgroundResource(R.color.colorAccent);
                r_l.setBackgroundResource(R.color.m_c24);
                break;
            }

        }
    }
}
