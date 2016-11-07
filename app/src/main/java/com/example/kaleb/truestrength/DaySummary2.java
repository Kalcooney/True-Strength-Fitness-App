package com.example.kaleb.truestrength;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class DaySummary2 extends AppCompatActivity {

    MyDBHandler dbHandler;
    private SQLiteDatabase db;
    String id, result, fromFiledNames, daydb, weekdb;
    int day;
    String currentWeek;
    String currentDay;
    int pk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_day_summary2);

        //shared preferences to display username
        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor userInfoEditor = userInfo.edit();

        dbHandler = new MyDBHandler(this, null, null, 1);

        ListView myList = (ListView) findViewById(R.id.exerciseList);
        TextView dayresult = (TextView) findViewById(R.id.dayText);
        TextView weekresult = (TextView) findViewById(R.id.weekTextex);
        TextView titleText = (TextView) findViewById(R.id.titleText);
        TextView exName = (TextView) findViewById(R.id.exName);
        TextView repText = (TextView) findViewById(R.id.repText);
        TextView weightText = (TextView) findViewById(R.id.weightText);

        //id = getIntent().getExtras().getString("id");
        //day = Integer.parseInt(id);

        //shared preferences to get the current week and day
        SharedPreferences weekDay = getSharedPreferences("weekDay", Context.MODE_PRIVATE);
        SharedPreferences.Editor weekDayEditor = weekDay.edit();

        SharedPreferences exData = getSharedPreferences("exData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = exData.edit();

        pk = exData.getInt("exDataKey", 0);
        exName.setText(dbHandler.getExerciseNumber(pk) + " " + dbHandler.getExerciseName(pk));
        repText.setText("Reps done: " + dbHandler.getReps(pk));
        weightText.setText("Weight lifted: " + dbHandler.getWeight(pk));

        weekresult.setText( weekDay.getString("Week", ""));
        dayresult.setText(weekDay.getString("Day", ""));
        titleText.setText("Summary");
        //dayresult.setText(dbHandler.getDay(day));
    }


    public void goBack(View view) {
        Intent daysummary1 = new Intent(this, DaySummary1.class);
        startActivity(daysummary1);
        finish();
    }

    public void startClicked(View view){
        Intent repsets = new Intent(this, repsets.class);
        startActivity(repsets);
        finish();
    }

    //onClick that takes user to the options screen
    public void extraClicked(View view){
        Intent extra = new Intent(this, otherOptionsMenu.class);
        startActivity(extra);
        finish();
    }

    //onClick that takes user to the My Profile screen
    public void myProfileClicked(View view){
        Intent myProfile = new Intent(this, ProfileScreen.class);
        startActivity(myProfile);
        finish();
    }

    //onClick that takes user to the True Strength screen
    public void trueStrengthClicked(View view){
        Intent trueStrength = new Intent(this, TrueStrength.class);
        startActivity(trueStrength);
        finish();
    }

    //onClick that takes user to the My Exercise screen
    public void myExerciseClicked(View view){
        Intent myExercise = new Intent(this, firstList.class);
        startActivity(myExercise);
        finish();
    }
}