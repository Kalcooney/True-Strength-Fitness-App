package com.example.kaleb.truestrength;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_help);

        //reference the webview
        WebView browser = (WebView) findViewById(R.id.webView);
        WebSettings settings = browser.getSettings();
        settings.setJavaScriptEnabled(true); //make sure javascript is enabled
        browser.loadUrl("file:///android_asset/help.html"); //load the help screen as a html file stored within app.
    }

    //onClick that takes user to the My Profile tab
    public void myProfileClicked(View view){
        Intent myProfile = new Intent(this, ProfileScreen.class);
        startActivity(myProfile);
        finish();
    }

    //onClick that takes user to the My Exercise Tab
    public void myExerciseClicked(View view){

    }

    //onClick that takes user to the True Strength Tab
    public void trueStrengthClicked(View view){
        Intent trueStrength = new Intent(this, TrueStrength.class);
        startActivity(trueStrength);
        finish();
    }
}
