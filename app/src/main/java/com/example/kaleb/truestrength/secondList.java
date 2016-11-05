package com.example.kaleb.truestrength;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.activity_second_list);
        dbHandler = new MyDBHandler (this, null, null, 1);

        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor userInfoEditor = userInfo.edit();

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
        Cursor cursor = dbHandler.getAllRows();
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
                                              // myintent.putExtra("date", String.valueOf(id));
                                              startActivity(myintent);
                                          }
                                      }
        );

    }

    public void goBack(){
        finish();
    }
}