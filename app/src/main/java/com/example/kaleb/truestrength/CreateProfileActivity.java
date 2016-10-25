package com.example.kaleb.truestrength;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class CreateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        SharedPreferences profileToggle = getSharedPreferences("profileToggle", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = profileToggle.edit();

        /*if(profileToggle.getBoolean("firstTimeLaunched", true)){
            clearPreferences();
            Intent profileScreen = new Intent(this, ProfileScreen.class);
            startActivity(profileScreen);

        }
        else{
            setContentView(R.layout.activity_main);
            editor.putBoolean("firstTimeLaunched", false);
            editor.apply();
    }*/
        setContentView(R.layout.activity_main);
    }

    public void saveClicked(View view){
        //Check whether app has been launched before to toggle Create Your Profile on or off.
        SharedPreferences profileToggle = getSharedPreferences("profileToggle", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = profileToggle.edit();
        editor.putBoolean("firstTimeLaunched", true);
        editor.apply();
        Intent profileScreen = new Intent(this, ProfileScreen.class);
        startActivity(profileScreen);
    }

    public void clearPreferences(){
        SharedPreferences profileToggle = getSharedPreferences("profileToggle", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = profileToggle.edit();
        editor.clear();
        editor.clear();
    }
}
