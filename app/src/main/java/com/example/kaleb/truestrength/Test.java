package com.example.kaleb.truestrength;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Test extends AppCompatActivity {

    TextView testText;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        TextView name = (TextView) findViewById(R.id.name);
        TextView dob = (TextView) findViewById(R.id.dob);
        TextView gender = (TextView) findViewById(R.id.gender);
        TextView height = (TextView) findViewById(R.id.height);
        TextView weight = (TextView) findViewById(R.id.weight);

        name.setText(userInfo.getString("username", ""));
        dob.setText(userInfo.getString("DOB", ""));
        gender.setText(userInfo.getString("Gender", ""));
        height.setText(userInfo.getString("Height", ""));
        weight.setText(userInfo.getString("Weight", ""));
    }
}
