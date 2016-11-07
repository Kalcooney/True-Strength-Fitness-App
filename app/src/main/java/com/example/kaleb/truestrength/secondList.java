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

public class secondList extends AppCompatActivity {

    MyDBHandler dbHandler;
    private SQLiteDatabase db;
    String id;
    int day;
    //long name;
    //String dayresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_second_list);
        dbHandler = new MyDBHandler (this, null, null, 1);

        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor userInfoEditor = userInfo.edit();

        SharedPreferences listItem = getSharedPreferences("ID", Context.MODE_PRIVATE);
        SharedPreferences.Editor IDEditor = listItem.edit();

        ListView myList = (ListView) findViewById(R.id.dayList);
        TextView dayresult = (TextView) findViewById(R.id.dayText);
        TextView weekresult = (TextView) findViewById(R.id.weekText);
        TextView titleText = (TextView) findViewById(R.id.titleText);

        id = getIntent().getExtras().getString("id");
        day = Integer.parseInt(id);

        titleText.setText("Welcome " + userInfo.getString("username", ""));
        weekresult.setText(dbHandler.getWeek(day));
        populateListView();


    }

    private void populateListView() {
// populate EditText fields with data from Cursor
        Cursor cursor = dbHandler.getAllDay();
        //next 2 rows take data from the database and places them in the list view
        final String fromFiledNames[] = new String[]{MyDBHandler.COLUMN_DAY}; //this array will be used in list view
        int[] toViewIDs = new int[]{R.id.dayText};
        SimpleCursorAdapter myCursorAdapter;
        //next line uses the customlayout that we set up inputs the data
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.customlistday, cursor, fromFiledNames, toViewIDs, 0);
        ListView myList = (ListView) findViewById(R.id.dayList);
        myList.setAdapter(myCursorAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() { //listens to the click
                                          @Override
                                          public void onItemClick(AdapterView<?> myList, View view, int position, long id) {
                                              Cursor cursor = (Cursor) myList.getItemAtPosition(position);
                                              Intent myintent = new Intent(view.getContext(), exerciseList.class);
                                              myintent.putExtra("position", String.valueOf(position));
                                              myintent.putExtra("id", String.valueOf(id));

                                              //shared preferences to get the pk
                                              SharedPreferences listItem = getSharedPreferences("ID", Context.MODE_PRIVATE);
                                              SharedPreferences.Editor IDEditor = listItem.edit();
                                              SharedPreferences getWeek = getSharedPreferences("Week", Context.MODE_PRIVATE);
                                              SharedPreferences.Editor getWeekEditor = getWeek.edit();
                                              int positionID = 1;
                                              int posID = (int) (long) id;

                                              int currentWeek = getWeek.getInt("Week", 0);
                                              if(currentWeek == 1 && posID == 1){
                                                  positionID = 1;
                                                  IDEditor.putInt("Primary Key", positionID);
                                                  IDEditor.commit();

                                              }
                                              if(currentWeek == 1 && posID == 2){
                                                  positionID = 14;
                                              }
                                              if(currentWeek == 1 && posID == 3) {
                                                  positionID = 28;
                                              }
                                              if(currentWeek == 1 && posID == 4){
                                                  positionID = 39;
                                              }
                                              if(currentWeek == 1 && posID == 5){
                                                  positionID = 52;
                                              }
                                              if(currentWeek == 1 && posID == 6){
                                                  positionID = 67;
                                              }
                                              IDEditor.putInt("Primary Key", positionID);
                                              IDEditor.commit();

                                              //shared preferences to get the day for querying
                                              SharedPreferences weekDay = getSharedPreferences("weekDay", Context.MODE_PRIVATE);
                                              SharedPreferences.Editor weekDayEditor = weekDay.edit();

                                              int pos = position + 1;
                                              if(pos == 1){
                                                  weekDayEditor.putString("Day", "Day 1");
                                                  weekDayEditor.commit();
                                              }
                                              if(pos == 2){
                                                  weekDayEditor.putString("Day", "Day 2");
                                                  weekDayEditor.commit();
                                              }
                                              if(pos == 3){
                                                  weekDayEditor.putString("Day", "Day 3");
                                                  weekDayEditor.commit();
                                              }


                                              // myintent.putExtra("date", String.valueOf(id));
                                              startActivity(myintent);
                                          }
                                      }
        );

    }

    public void goBack(View view){
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
}