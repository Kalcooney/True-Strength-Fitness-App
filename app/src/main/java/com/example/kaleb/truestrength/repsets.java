package com.example.kaleb.truestrength;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class repsets extends AppCompatActivity {

    private AlertDialog alert;
    Spinner weight, reps;
    String weightResult, repsResult;
    MyDBHandler dbHandler;
    private SQLiteDatabase db;
    String Name, daydb, weekdb, exerciseName;
    int day;
    int pk;
    TextView restText;
    private CountDownTimer  restCountDownTimer;
    private long startTime = 30 * 1000;
    private final long interval = 1 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_repsets);
        TextView exName = (TextView) findViewById(R.id.exnameText);
        TextView nextEx = (TextView) findViewById(R.id.nextexText);

        SharedPreferences listItem = getSharedPreferences("ID", Context.MODE_PRIVATE);
        SharedPreferences.Editor IDEditor = listItem.edit();
        pk = listItem.getInt("Primary Key", 0);
        dbHandler = new MyDBHandler(this, null, null, 1);

        //daydb = getIntent().getExtras().getString("dayname");
        //weekdb = getIntent().getExtras().getString("dayname");
        //exerciseName = dbHandler.getExName(daydb, weekdb);
        //exName.setText(exerciseName);
        exName.setText(dbHandler.getExerciseNumber(pk).toString() + " " + dbHandler.getExerciseName(pk).toString()); //this shows the exercise name as the day name.  I can't work out how to use this to get the exercisename!
        nextEx.setText("Next: " + dbHandler.getExerciseName(pk + 1));

        weight = (Spinner) findViewById(R.id.weightSpinner);
        reps = (Spinner) findViewById(R.id.repsSpinner);
        weightResult = weight.getSelectedItem().toString();
        repsResult = reps.getSelectedItem().toString();

        weight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#eeff00"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                weightResult = parent.getItemAtPosition(position).toString();
                //.makeText(Record.this, typeResult, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        } );

        reps.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#eeff00"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                repsResult = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        } );
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

    public void backClicked(View view){
        Intent exerciseList = new Intent(this, exerciseList.class);
        startActivity(exerciseList);
        finish();
    }

    public void extraClicked(View view){
        Intent extra = new Intent(this, otherOptionsMenu.class);
        startActivity(extra);
        finish();
    }

    public void myExerciseClicked(View view){
        Intent myExercise = new Intent(this, firstList.class);
        startActivity(myExercise);
        finish();
    }

    public void myProfileClicked(View view){
        Intent myProfile = new Intent(this, ProfileScreen.class);
        startActivity(myProfile);
        finish();
    }

    public void trueStrengthClicked(View view){
        Intent trueStrength = new Intent(this, TrueStrength.class);
        startActivity(trueStrength);
        finish();
    }
}