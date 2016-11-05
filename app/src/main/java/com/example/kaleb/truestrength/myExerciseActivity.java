package com.example.kaleb.truestrength;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.view.View;
import android.widget.FrameLayout;
import android.view.LayoutInflater;
import android.content.Context;
import android.content.Intent;

public class myExerciseActivity extends AppCompatActivity {

    Chronometer timer;
    View timerView, start;
    Button startTimer;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
    }

    public void startTimer(){
        //timerView = R.layout.timer;
        FrameLayout startFrame = (FrameLayout) findViewById(R.id.starttimerFrame);
        FrameLayout timerFrame = (FrameLayout) findViewById(R.id.timerFrame);
        startFrame.removeAllViews();
        startFrame.addView(timerFrame);
        timer = (Chronometer) findViewById(R.id.timer);
        timer.start();

    }

    public void gotofirstlist(View view){
        Intent I = new Intent(this, firstList.class); //this is the activity that we want to launch when it is clicked.
        startActivity(I); //launches activity
    }


}