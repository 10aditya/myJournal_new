package com.obtestatus.myjournal;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    SharedPreferences mPrefs;
    String un;
    final String pin_key = "0";
    static String username;
    String pin;
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
        String pinS = mPrefs.getString(pin_key, "");
        if (!welcomeScreenShown) {
            // here you can launch another activity if you like
            // the code below will display a popup

            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main4Activity.this);
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);

            final EditText input = new EditText(this);
            input.setHint("Enter Username");
            layout.addView(input);

            final EditText passwordBox = new EditText(this);
            passwordBox.setHint("Enter 4 Number PIN to secure your personal data");
            passwordBox.setInputType(InputType.TYPE_CLASS_NUMBER);
            passwordBox.setMaxLines(1);
            passwordBox.setMinWidth(4);
            passwordBox.setMaxWidth(4);
            layout.addView(passwordBox);

            final TextView textView = new TextView(this);
            textView.setText("Note : You cannot recover your PIN. So you must remember it and note down or else you will lose your data.");
            textView.setTextSize(12);
            layout.addView(textView);
            alertDialog.setView(layout);

            // alertDialog.setTitle("Enter Username");
            //final EditText input = new EditText(Main4Activity.this);
            //LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            //      LinearLayout.LayoutParams.MATCH_PARENT);
            //input.setLayoutParams(lp);
            //alertDialog.setView(input);
            alertDialog.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    username = input.getText().toString();
                    pin = passwordBox.getText().toString();
                    dialog.dismiss();
                    //preferences = getSharedPreferences("myPref", MODE_PRIVATE);
                    //username = preferences.getString(user_name, " ");
                    SharedPreferences.Editor editor = mPrefs.edit();
                    editor.putString(user_name, username);
                    editor.putString(pin_key, pin);
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
            pin = preferences.getString(pin_key, "");
            final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(Main4Activity.this);

            LinearLayout layout2 = new LinearLayout(this);
            layout2.setOrientation(LinearLayout.VERTICAL);

            final EditText passwordBox2 = new EditText(this);
            passwordBox2.setHint("Enter your PIN");
            passwordBox2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
            passwordBox2.setMaxLines(1);
            passwordBox2.setMinWidth(4);
            passwordBox2.setMaxWidth(4);
            layout2.addView(passwordBox2);

            alertDialog2.setView(layout2);

            alertDialog2.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String pin2 = passwordBox2.getText().toString();
                    if (pin2.equals(pin)) {
                        dialog.dismiss();
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(Main4Activity.this, Main2Activity.class));
                                finish();
                            }
                        }, 1620);
                    } else {
                        Toast.makeText(Main4Activity.this, "Wrong PIN", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }
            });

            alertDialog2.show();

        }
    }
}