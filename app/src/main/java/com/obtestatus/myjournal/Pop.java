package com.obtestatus.myjournal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

/**
 * Created by Aditya on 16/06/2016.
 */
public class Pop extends Activity {

    FrameLayout layout_MainMenu;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.pop_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int hieght = dm.heightPixels;

        getWindow().setLayout((int) (width * (.6)), (int) (hieght * (.4)));

        /*layout_MainMenu = (FrameLayout) findViewById( R.id.mainmenu);
        layout_MainMenu.getForeground().setAlpha(320);*/

        /*PopupWindow popup = new PopupWindow();
        popup.setBackgroundDrawable(null);
        popup.showAsDropDown(null);

        View container = (View) popup.getContentView().getParent();
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
        p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        p.dimAmount = 0.3f;
        wm.updateViewLayout(container, p);*/


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
        Button b15 = (Button) findViewById(R.id.button19);


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
                MainActivity.myFrame.setBackgroundResource(R.color.m_c20);
                MainActivity.yy.setBackgroundResource(R.color.m_c11);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood7);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c13);
                MainActivity.yy.setBackgroundResource(R.color.m_c12);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood8);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c15);
                MainActivity.yy.setBackgroundResource(R.color.m_c14);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood9);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c6);
                MainActivity.yy.setBackgroundResource(R.color.m_c16);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood10);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c17);
                MainActivity.yy.setBackgroundResource(R.color.m_c18);
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood11);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c20);
                MainActivity.yy.setBackgroundResource(R.color.m_c19);
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood12);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c22);
                MainActivity.yy.setBackgroundResource(R.color.m_c21);
            }
        });

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood13);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c23);
                MainActivity.yy.setBackgroundResource(R.color.m_c11);
            }
        });

        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText("");
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.colorAccent);
                MainActivity.yy.setBackgroundResource(R.color.m_c24);
            }
        });

        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                MainActivity.xx.setText(R.string.mood14);
                MainActivity.xx.setTextColor(getResources().getColor(R.color.fontc));
                MainActivity.myFrame.setBackgroundResource(R.color.m_c24);
                MainActivity.yy.setBackgroundResource(R.color.colorAccent);
            }
        });
    }
}
