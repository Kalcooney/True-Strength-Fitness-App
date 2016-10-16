package com.example.kaleb.truestrength;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String week = "Week 1";
        String day = "Day 1";
        long id = 4;
        dbHandler = new MyDBHandler(this, null, null, 1);
        text = (TextView) findViewById(R.id.text);
        String timer = Long.toString(dbHandler.getRestTime(id));
        text.setText(timer);

    }
}
