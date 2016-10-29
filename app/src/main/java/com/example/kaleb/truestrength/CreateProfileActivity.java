package com.example.kaleb.truestrength;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateProfileActivity extends AppCompatActivity {

    EditText nameInput;
    EditText dobInput;
    EditText genderInput;
    EditText heightInput;
    EditText weightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hides the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Shared Preferences for storing user data
        SharedPreferences profileToggle = getSharedPreferences("profileToggle", Context.MODE_PRIVATE);
        SharedPreferences.Editor profileToggleEditor = profileToggle.edit();
        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor userInfoEditor = userInfo.edit();

        if(profileToggle.getBoolean("firstTimeLaunched", true)){
            clearPreferences();
            Intent profileScreen = new Intent(this, ProfileScreen.class);
            startActivity(profileScreen);

        }
        else{
            setContentView(R.layout.activity_main);
            profileToggleEditor.putBoolean("firstTimeLaunched", false);
            profileToggleEditor.apply();
        }
        setContentView(R.layout.activity_main);

        //reference text views
        nameInput = (EditText) findViewById(R.id.nameInput);
        dobInput = (EditText) findViewById(R.id.dobInput);
        genderInput = (EditText) findViewById(R.id.genderInput);
        heightInput = (EditText) findViewById(R.id.heightInput);
        weightInput = (EditText) findViewById(R.id.weightInput);
    }

    public void saveClicked(View view){
        //Check whether app has been launched before to toggle Create Your Profile on or off.
        SharedPreferences profileToggle = getSharedPreferences("profileToggle", Context.MODE_PRIVATE);
        SharedPreferences.Editor profileToggleEditor = profileToggle.edit();
        profileToggleEditor.putBoolean("firstTimeLaunched", true);
        profileToggleEditor.apply();
        //store userinfo into Shared Preferences
        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor userInfoEditor = userInfo.edit();
        userInfoEditor.putString("username", nameInput.getText().toString());
        userInfoEditor.putString("DOB", dobInput.getText().toString());
        userInfoEditor.putString("Gender", genderInput.getText().toString());
        userInfoEditor.putString("Height", heightInput.getText().toString());
        userInfoEditor.putString("Weight", weightInput.getText().toString());
        userInfoEditor.apply();
        Intent profileScreen = new Intent(this, ProfileScreen.class);
        startActivity(profileScreen);
    }

    //create a new calendar object and set it to a DatePicker
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            myCalendar.set(Calendar.YEAR, i);
            myCalendar.set(Calendar.MONTH, i1);
            myCalendar.set(Calendar.DAY_OF_MONTH, i2);
            updateLabel();
        }
    };

    //onClick for when DOB field is clicked
    public void dobClicked(View view){
        new DatePickerDialog(CreateProfileActivity.this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH
        ), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    //formats the date text
    private void updateLabel(){
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        dobInput.setText(sdf.format(myCalendar.getTime()));
    }

    public void clearPreferences(){
        SharedPreferences profileToggle = getSharedPreferences("profileToggle", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = profileToggle.edit();
        editor.clear();
        editor.clear();
    }
}
