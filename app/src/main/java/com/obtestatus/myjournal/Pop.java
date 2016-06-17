package com.obtestatus.myjournal;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by Aditya on 16/06/2016.
 */
public class Pop extends Activity{

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        setContentView(R.layout.pop_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int hieght = dm.heightPixels;

        getWindow().setLayout((int)(width*(.6)), (int)(hieght*(.4)));



        Button b1 = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        Button b5 = (Button) findViewById(R.id.button5);
        Button b6 = (Button) findViewById(R.id.button6);
        Button b7 = (Button) findViewById(R.id.button7);
        Button b8 = (Button) findViewById(R.id.button8);
        Button b9 = (Button) findViewById(R.id.button9);
        Button b10 = (Button) findViewById(R.id.button10);
        Button b11 = (Button) findViewById(R.id.button11);
        Button b12 = (Button) findViewById(R.id.button12);
        Button b13 = (Button) findViewById(R.id.button13);
        Button b14 = (Button) findViewById(R.id.button14);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood1);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c5);
                MainActivity.yy.setBackgroundResource(R.color.m_c1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood2);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.yy.setBackgroundResource(R.color.m_c2);
                MainActivity.myFrame.setBackgroundResource(R.color.m_c3);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood3);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c2);
                MainActivity.yy.setBackgroundResource(R.color.m_c3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood4);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c4);
                MainActivity.yy.setBackgroundResource(R.color.m_c6);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood5);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c10);
                MainActivity.yy.setBackgroundResource(R.color.m_c9);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood6);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.colorPrimary);
                MainActivity.yy.setBackgroundResource(R.color.m_c11);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood4);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c4);
                MainActivity.yy.setBackgroundResource(R.color.m_c6);
            }
        });



    }
}
