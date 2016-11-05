package com.example.kaleb.truestrength;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ProfileScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_profile_screen);

        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        TextView name = (TextView) findViewById(R.id.name);
        TextView dob = (TextView) findViewById(R.id.dob);
        TextView gender = (TextView) findViewById(R.id.gender);
        TextView height = (TextView) findViewById(R.id.height);
        TextView weight = (TextView) findViewById(R.id.weight);

        name.setText("Name: \t" + userInfo.getString("username", ""));
        dob.setText("DOB: \t" + userInfo.getString("DOB", ""));
        gender.setText("Gender: \t" + userInfo.getString("Gender", ""));
        height.setText("Height: \t" + userInfo.getString("Height", ""));
        weight.setText("Weight: \t" + userInfo.getString("Weight", ""));
    }

    //onClick method that takes user to the My Exercise Screen
    public void myExerciseClicked(View view){
        Intent firstList = new Intent(this, firstList.class);
        startActivity(firstList);
    }

    //onClick method that takes user to the True Strength page
    public void trueStrengthClicked(View view){
        Intent trueStrength = new Intent(this, TrueStrength.class);
        startActivity(trueStrength);
    }
}
