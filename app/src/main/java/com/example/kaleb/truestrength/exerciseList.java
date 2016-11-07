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
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class exerciseList extends AppCompatActivity {

    MyDBHandler dbHandler;
    private SQLiteDatabase db;
    String id, result, fromFiledNames, daydb, weekdb;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_exercise_list);

        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor userInfoEditor = userInfo.edit();

        dbHandler = new MyDBHandler(this, null, null, 1);

        ListView myList = (ListView) findViewById(R.id.exerciseList);
        TextView dayresult = (TextView) findViewById(R.id.dayText);
        TextView weekresult = (TextView) findViewById(R.id.weekTextex);
        TextView titleText = (TextView) findViewById(R.id.titleText);

        id = getIntent().getExtras().getString("id");
        day = Integer.parseInt(id);
        weekdb = dbHandler.getWeek(day);
        daydb = dbHandler.getDay(day);
        weekresult.setText(weekdb);
        dayresult.setText(daydb);
        titleText.setText("Welcome " + userInfo.getString("username", ""));
        //dayresult.setText(dbHandler.getDay(day));
        populateListView();
    }

    private void populateListView() {
        // populate EditText fields with data from Cursor
        Cursor cursor = dbHandler.getAllRows();
        //next 2 rows take data from the database and places them in the list view
        String fromFiledNames[] = new String[]{MyDBHandler.COLUMN_EXERCISE_NUMBER, MyDBHandler.COLUMN_EXERCISE_NAME}; //this array will be used in list view
        int[] toViewIDs = new int[]{R.id.exerciseNumber, R.id.exerciseText};
        SimpleCursorAdapter myCursorAdapter;
        //next line uses the customlayout that we set up inputs the data
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.customlistexercise, cursor, fromFiledNames, toViewIDs, 0);
        ListView myList = (ListView) findViewById(R.id.exerciseList);
        myList.setAdapter(myCursorAdapter);
    }

    public void goBack(View view){
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
