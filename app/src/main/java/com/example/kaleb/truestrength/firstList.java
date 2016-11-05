package com.example.kaleb.truestrength;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class firstList extends AppCompatActivity {

    MyDBHandler dbHandler;
    private SQLiteDatabase db;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_list);
        dbHandler = new MyDBHandler(this, null, null, 1);
        populateListView();
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