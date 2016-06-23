package com.obtestatus.myjournal;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Main4Activity extends AppCompatActivity {

    SharedPreferences mPrefs;
    String un;
    int flag = 0;
    static String username;
    EditText eT;
    final String welcomeScreenShownPref = "welcomeScreenShown";
    final String user_name = "username";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(Main4Activity.this);
        un = "";


        // second argument is the default to use if the preference can't be found
        Boolean welcomeScreenShown = mPrefs.getBoolean(welcomeScreenShownPref, false);
        String u_n = mPrefs.getString(user_name, " ");
        if (!welcomeScreenShown) {
            // here you can launch another activity if you like
            // the code below will display a popup

            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main4Activity.this);
            alertDialog.setTitle("Enter Username");
            final EditText input = new EditText(Main4Activity.this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            input.setLayoutParams(lp);
            alertDialog.setView(input);
            alertDialog.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    username = input.getText().toString();
                    dialog.dismiss();
                    //preferences = getSharedPreferences("myPref", MODE_PRIVATE);
                    //username = preferences.getString(user_name, " ");
                    SharedPreferences.Editor editor = mPrefs.edit();
                    editor.putString(user_name, username);
                    editor.putBoolean(welcomeScreenShownPref, true);
                    editor.commit();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(Main4Activity.this, Main2Activity.class));
                            finish();
                        }
                    }, 1620);

                }
            });

            alertDialog.show();


        } else {

            preferences = PreferenceManager.getDefaultSharedPreferences(this);
            username = preferences.getString(user_name, "");
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(Main4Activity.this, Main2Activity.class));
                    finish();
                }
            }, 1620);

        }

    }
}
