package com.obtestatus.myjournal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class w_s extends AppCompatActivity {

    SharedPreferences username;
    EditText edtxt;
    final String bool = "user_name";
    final String un = "name_of_user";
    Button o_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        username = PreferenceManager.getDefaultSharedPreferences(w_s.this);
        String u_n = username.getString(un, "null");
        boolean bl = username.getBoolean(bool, false);
        final SharedPreferences.Editor editor = username.edit();
        if (!bl) {

            setContentView(R.layout.activity_w_s);
            o_b = (Button) findViewById(R.id.enter_un);
            edtxt = (EditText) findViewById(R.id.name);
            o_b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edtxt.getText().toString() == "")
                        Toast.makeText(w_s.this, "Please enter a Username!", Toast.LENGTH_SHORT).show();
                    else {
                        editor.putString(un, edtxt.getText().toString());
                        editor.putBoolean(bool, true);
                        editor.commit();
                        startActivity(new Intent(w_s.this, Main2Activity.class));
                    }
                }
            });
        }*/
    }
}
