package com.example.kaleb.truestrength;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class otherOptionsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_other_options_menu);
    }

    //onClick that takes user to the My Profile screen
    public void myProfileClicked(View view){
        Intent myProfile = new Intent(this, ProfileScreen.class);
        startActivity(myProfile);
        finish();
    }

    //onClick that takes user to the My Exercise screen
    public void myExerciseClicked(View view){
        Intent myExercise = new Intent(this, firstList.class);
        startActivity(myExercise);
        finish();
    }

    //onClick that takes user to the True Strength screen
    public void trueStrengthClicked(View view){
        Intent trueStrength = new Intent(this, TrueStrength.class);
        startActivity(trueStrength);
        finish();
    }


    //onClick to take user to preferences screen
    public void preferencesClicked(View view){
        /* Intent preferences = new Intent(this, preferences.class);
        startActivity(preferences);
        finish(); */
    }

    //onClick to take user to the help screen
    public void helpClicked(View view){
        Intent help = new Intent(this, HelpActivity.class);
        startActivity(help);
        finish();
    }

    //onClick to take user to the about screen
    public void aboutClicked(View view){
        Intent about = new Intent(this, AboutActivity.class);
        startActivity(about);
        finish();
    }

    //onClick to take user to the Contact True Strength screen
    public void contactClicked(View view){
        /* Intent contact = new Intent(this, contact.class);
        startActivity(contact);
        finish(); */
    }
}
