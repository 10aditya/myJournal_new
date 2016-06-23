package com.obtestatus.myjournal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.obtestatus.myjournal.data.Constants;
import com.obtestatus.myjournal.data.DBHelper;
import com.obtestatus.myjournal.data.MyDB;

import java.util.Calendar;


public class Main2Activity extends AppCompatActivity {

    static ListView myEntries2;
    MyDB db;
    FrameLayout myframe;
    TextView usern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = new MyDB(this);
        myEntries2 = (ListView) findViewById(R.id.my_List_View);
        usern = (TextView) findViewById(R.id.username);
        FloatingActionButton add_button = (FloatingActionButton) findViewById(R.id.addbutton);
        usern.setTextColor(getResources().getColor(R.color.fontc));
        usern.setTextSize(20);
        usern.setText("Hi " + Main4Activity.username.toString() + "!");

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
                finish();
            }
        });

        setRemainder();
        displayEntries();
        myEntries2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                i.putExtra("Clicked_item", position);
                startActivity(i);

            }
        });




}
    public void setRemainder(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 16);
        calendar.set(Calendar.MINUTE, 14);
        calendar.set(Calendar.SECOND, 00);

        Intent notificationMessage = new Intent(Main2Activity.this, NotificationHelper.class);

        PendingIntent pi = PendingIntent.getBroadcast(this, 0, notificationMessage, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 20*1000, AlarmManager.INTERVAL_DAY, pi);


    }


    public void displayEntries() {

        //myframe = (FrameLayout) findViewById(R.id.entry_frame);
        DBHelper dbhelper = new DBHelper(Main2Activity.this);
        Cursor cursor = db.getEntries();
        Cursor cursor2 = db.getMood();

        String[] from = new String[]{
                Constants.TITLE_NAME,
                Constants.DATE_NAME
        };

        int[] to = new int[]{
                R.id.entry_title, R.id.entry_date
        };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(Main2Activity.this,
                R.layout.row_activity, cursor, from, to, 0);

        myEntries2.setAdapter(adapter);
        myEntries2.setEmptyView(findViewById(R.id.emptyTextView));
        /*// looping through all rows and adding to list
        if (cursor2.moveToFirst()) {
            do {
                myframe.setBackgroundResource(Integer.parseInt(set_color(cursor2.getString(0))));
            } while (cursor2.moveToNext());
        }*/

    }

    public static String set_color(String xxx) {

        String zz;
        switch (xxx) {
            case "HAPPY": {
                zz = String.valueOf(R.color.m_c5);
                break;
            }
            case "SAD": {
                zz = String.valueOf((R.color.m_c3));
            break;
        }
            case "ANGRY": {
                zz = String.valueOf((R.color.m_c2));
                break;
            }
            case "ROMANTIC": {
                zz = String.valueOf((R.color.m_c24));
                break;
            }
            case "BLISSED": {
                zz = String.valueOf((R.color.m_c4));
                break;
            }
            case "EXCITED": {
                zz = String.valueOf((R.color.m_c10));
                break;
            }
            case "ALONE": {
                zz = String.valueOf((R.color.m_c20));
                break;
            }
            case "STRESSED": {
                zz = String.valueOf((R.color.m_c13));
                break;
            }
            case "SHOCKED": {
                zz = String.valueOf((R.color.m_c15));
                break;
            }
            case "APOLOGETIC": {
                zz = String.valueOf((R.color.m_c6));
                break;
            }
            case "GUILTY": {
                zz = String.valueOf((R.color.m_c17));
                break;
            }
            case "SATISFIED": {
                zz = String.valueOf((R.color.m_c20));
                break;
            }
            case "CRAZY": {
                zz = String.valueOf((R.color.m_c22));
                break;
            }
            case "BORED": {
                zz = String.valueOf((R.color.m_c23));
                break;
            }
            default: {
                zz = String.valueOf((R.color.colorAccent));
                break;
            }

        }

        return zz;
    }
}
