package com.example.kaleb.truestrength;

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

        long id = 4;
        dbHandler = new MyDBHandler(this, null, null, 1);
        testText = (TextView) findViewById(R.id.testText);
        testText.setText(dbHandler.getExerciseNumber(id) + " " + dbHandler.getExerciseName(id) + " " + Long.toString(dbHandler.getRestTime(id)));

    }
}
