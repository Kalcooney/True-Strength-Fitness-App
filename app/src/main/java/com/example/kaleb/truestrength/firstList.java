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

import org.w3c.dom.Text;

public class firstList extends AppCompatActivity {

    MyDBHandler dbHandler;
    private SQLiteDatabase db;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_first_list);
        dbHandler = new MyDBHandler(this, null, null, 1);
        populateListView();
        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor userInfoEditor = userInfo.edit();
        TextView titleText = (TextView) findViewById(R.id.titleText);
        titleText.setText("Welcome " + userInfo.getString("username", ""));
    }

    private void populateListView() {
        Cursor cursor = dbHandler.getAllRows();
        final String fromFiledNames[] = new String[]{MyDBHandler.COLUMN_WEEK}; //this array will be used in list view
        int[] toViewIDs = new int[]{R.id.weekText};
        SimpleCursorAdapter myCursorAdapter;
        //next line uses the customlayout that we set up inputs the data
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.customlist, cursor, fromFiledNames, toViewIDs, 0);
        ListView myList = (ListView) findViewById(R.id.weekList);
        myList.setAdapter(myCursorAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() { //listens to the click
                                          @Override
                                          public void onItemClick(AdapterView<?> myList, View view, int position, long id) {
                                              Cursor cursor = (Cursor) myList.getItemAtPosition(position);
                                              Intent myintent = new Intent(view.getContext(), secondList.class);
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