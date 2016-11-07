package com.example.kaleb.truestrength;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaRecorder;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.view.View;
import android.widget.FrameLayout;
import android.view.LayoutInflater;
import android.content.Context;

import android.content.Intent;
import android.widget.ImageButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class myExerciseActivity extends AppCompatActivity implements View.OnClickListener {

    View timerView, start;
    Button startTimer, timerButton;
    ImageButton howToButton;
    Context context;
    TextView timerText, nextexercise, restText;
    private AlertDialog alert;

    private CountDownTimer countDownTimer, restCountDownTimer;
    private long startTime = 30 * 1000;
    private final long interval = 1 * 1000;
    private boolean timerHasStarted = false;
    //Public TextView = timerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        timerButton = (Button) findViewById(R.id.timerButton);
        howToButton = (ImageButton) findViewById(R.id.howToButton);
        timerText = (TextView) this.findViewById(R.id.timerText);
        //restText = (TextView) timer.findViewById(R.id.restCountdown)

        timerText.setText( "00:" + String.valueOf(startTime / 1000) );
        timerButton.setOnClickListener(this);
        nextexercise = (TextView) findViewById(R.id.nextexText);
        countDownTimer = new MyCountDownTimer(startTime, interval);


    }

    @Override
    public void onClick(View v) {
        if (!timerHasStarted) {
            countDownTimer.start();
            timerHasStarted = true;
            timerButton.setText("RESTART");
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
            //startTime = 30 * 1000;
            timerText.setText( "00:" + String.valueOf(startTime / 1000));
            timerButton.setText("START");
        }
    }
    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            timerText.setText("Time's up!");
            nextexercise.setTextColor(Color.parseColor("#FF0000"));
        }

        @Override

        public void onTick(long millisUntilFinished) {
            timerText.setText("" + millisUntilFinished / 1000);
        }

    }

   /* public void howTo(View view){
        howToButton();
    } */

    public void howTo(View view){
        LayoutInflater li = LayoutInflater.from(this);
        final View promptsView = li.inflate(R.layout.howto, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // alertDialogBuilder.dismiss();
                    }
                });

        alert = alertDialogBuilder.create();
        alert.show();
    }

    public void nextExercise(View view){
        LayoutInflater li = LayoutInflater.from(this);
        final View promptsView = li.inflate(R.layout.activity_timer, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        restText = (TextView) promptsView.findViewById(R.id.restCountdown);
        restText.setText( "00:" + String.valueOf(startTime / 1000) );
        restCountDownTimer = new RestMyCountDownTimer(startTime, interval);
        restCountDownTimer.start();
        countDownTimer.cancel();
        timerHasStarted = false;

        alertDialogBuilder
                .setCancelable(false)

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // alertDialogBuilder.dismiss();
                    }
                });

        alert = alertDialogBuilder.create();
        alert.show();
        Button ok = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        ok.setBackgroundColor(Color.parseColor("#000000"));
        ok.setTextColor(Color.parseColor("#ffffff"));
    }

    public class RestMyCountDownTimer extends CountDownTimer {
        public RestMyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {

        }

        @Override

        public void onTick(long millisUntilFinished) {
            restText.setText("" + millisUntilFinished / 1000);
        }

    }
}
