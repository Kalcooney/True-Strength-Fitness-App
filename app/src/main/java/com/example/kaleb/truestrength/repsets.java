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

import org.w3c.dom.Text;


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
    TextView timerTitle;
    private CountDownTimer  restCountDownTimer;
    //private long startTime = 30 * 1000;
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
        TextView titleText = (TextView) findViewById(R.id.titleText);

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
        titleText.setText(dbHandler.getExerciseType(pk));

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
        long startTime = dbHandler.getRestTime(pk);
        timerTitle = (TextView) promptsView.findViewById(R.id.timerTitle);
        restText = (TextView) promptsView.findViewById(R.id.restCountdown);
        timerTitle.setText(String.valueOf(startTime / 1000) + " " + "SECONDS REST!");
        restText.setText( "00:" + String.valueOf(startTime / 1000) );
        restCountDownTimer = new RestMyCountDownTimer(startTime, interval);
        restCountDownTimer.start();



        alertDialogBuilder
                .setCancelable(false)

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // alertDialogBuilder.dismiss();
                        SharedPreferences listItem = getSharedPreferences("ID", Context.MODE_PRIVATE);
                        SharedPreferences.Editor IDEditor = listItem.edit();
                        int currentKey = listItem.getInt("Primary Key", 0);

                        User_Data userData = new User_Data(repsResult, weightResult, currentKey);
                        dbHandler.addUserItem(userData);
                        //end of day cheeks (week1)
                        switch(currentKey){
                            //if end of Day 1
                            case(13):
                                Intent summary = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary);
                                finish();
                                break;
                            case(27):
                                Intent summary2 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary2);
                                finish();
                                break;
                            case(38):
                                Intent summary3 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary3);
                                finish();
                                break;
                            case(51):
                                Intent summary4 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary4);
                                finish();
                                break;
                            case(66):
                                Intent summary5 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary5);
                                finish();
                                break;
                            case(77):
                                Intent summary6 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary6);
                                finish();
                                break;
                            //end of day (week2)
                            case(90):
                                Intent summary7 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary7);
                                finish();
                                break;
                            case(104):
                                Intent summary8 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary8);
                                finish();
                                break;
                            case(115):
                                Intent summary9 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary9);
                                finish();
                                break;
                            case(128):
                                Intent summary10 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary10);
                                finish();
                                break;
                            case(143):
                                Intent summary11 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary11);
                                finish();
                                break;
                            case(154):
                                Intent summary12 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary12);
                                finish();
                                break;
                            //end of day (week3)
                            case(165):
                                Intent summary13 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary13);
                                finish();
                                break;
                            case(181):
                                Intent summary14 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary14);
                                finish();
                                break;
                            case(193):
                                Intent summary15 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary15);
                                finish();
                                break;
                            case(205):
                                Intent summary16 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary16);
                                finish();
                                break;
                            case(221):
                                Intent summary17 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary17);
                                finish();
                                break;
                            case(233):
                                Intent summary18 = new Intent(repsets.this, DaySummary1.class);
                                startActivity(summary18);
                                finish();
                                break;
                            default:
                                currentKey += 1;
                                IDEditor.putInt("Primary Key", currentKey);
                                IDEditor.commit();
                                Intent repset = new Intent(repsets.this, repsets.class);
                                finish();
                                startActivity(repset);
                                break;
                        }
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