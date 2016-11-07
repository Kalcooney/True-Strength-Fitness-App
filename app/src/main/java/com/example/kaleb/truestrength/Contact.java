package com.example.kaleb.truestrength;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void webButtonClicked(View view){
        String url = "https://www.facebook.com/TrueStrengthNZ/";
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse(url));
        startActivity(webIntent);
    }

    //opens up email client when button is clicked
    public void emailButtonClicked(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "mike@true-strength-online.com", null));
        startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));
    }
}
