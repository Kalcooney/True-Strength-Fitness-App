package com.example.kaleb.truestrength;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class exerciseList extends AppCompatActivity {

    MyDBHandler dbHandler;
    private SQLiteDatabase db;
    String id;
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

        dbHandler = new MyDBHandler(this, null, null, 1);

        ListView myList = (ListView) findViewById(R.id.exerciseList);
        TextView dayresult = (TextView) findViewById(R.id.dayText);
        TextView weekresult = (TextView) findViewById(R.id.weekTextex);

        id = getIntent().getExtras().getString("id");
        day = Integer.parseInt(id);

        weekresult.setText(dbHandler.getWeek(day));
        dayresult.setText(dbHandler.getDay(day));
        populateListView();
    }

    private void populateListView() {
// populate EditText fields with data from Cursor
        Cursor cursor = dbHandler.getAllRows();
        //next 2 rows take data from the database and places them in the list view
        final String fromFiledNames[] = new String[]{ MyDBHandler.COLUMN_EXERCISE_NAME}; //this array will be used in list view
        int[] toViewIDs = new int[]{R.id.exerciseText};
        SimpleCursorAdapter myCursorAdapter;
        //next line uses the customlayout that we set up inputs the data
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.customlistexercise, cursor, fromFiledNames, toViewIDs, 0);
        ListView myList = (ListView) findViewById(R.id.exerciseList);
        myList.setAdapter(myCursorAdapter);
    }

    public void goBack(){
        finish();
    }
}
