package com.example.kaleb.truestrength;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.id;

public class MyDBHandler extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 40; //current version of the database
    public static final String DATABASE_NAME = "exercises.db"; //the name of the database

    //table and column names for the Exercises Table
    public static final String TABLE_EXERCISES = "Exercises"; //the name of the Exercises Table
    public static final String COLUMN_EXERCISE_ID = "_id"; //column for the Exercise ID
    public static final String COLUMN_WEEK = "Week"; //column for the Week
    public static final String COLUMN_DAY = "Day"; //column for the Day
    public static final String COLUMN_EXERCISE_NUMBER = "exerciseNumber"; //column for the number of the Exercise (e.g Ex 1a)
    public static final String COLUMN_EXERCISE_NAME = "exerciseName"; //column for the exercise name
    public static final String COLUMN_EXERCISE_TYPE = "exerciseType"; //column for the exercise type
    public static final String COLUMN_REST_TIME = "restTime"; //column for the Rest time

    //table and column names for the User Data table
    private static final String TABLE_USER_DATA = "UserData"; // the name of the User Data table
    private static final String COLUMN_UD_ID = "udID"; //column for the User Data id
    private static final String COLUMN_EX_ID = "exID"; //column for the Exercise ID (Foreign Key)
    private static final String COLUMN_WEIGHT = "Weight"; //column for the Weight lifted
    private static final String COLUMN_NUM_REPS = "numReps"; //column for the Number of Reps done.

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create the Exercises table
        String exQuery = "CREATE TABLE " + TABLE_EXERCISES + "(" +
                COLUMN_EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WEEK + " TEXT, " +
                COLUMN_DAY + " TEXT, " +
                COLUMN_EXERCISE_NUMBER + " TEXT, " +
                COLUMN_EXERCISE_NAME + " TEXT, " +
                COLUMN_EXERCISE_TYPE + " TEXT, " +
                COLUMN_REST_TIME + " TEXT " + ");";

        //Create the User Data table
        String udQuery = "CREATE TABLE " + TABLE_USER_DATA + "(" +
                COLUMN_UD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EX_ID + " INTEGER , " +
                COLUMN_WEIGHT + " TEXT, " +
                COLUMN_NUM_REPS + " TEXT, " +
                "FOREIGN KEY(" + COLUMN_EX_ID + ") REFERENCES " + TABLE_EXERCISES + "(" +
                COLUMN_EXERCISE_ID + "));";

        sqLiteDatabase.execSQL(exQuery);
        sqLiteDatabase.execSQL(udQuery);
        //sqLiteDatabase.execSQL(insertInitialData());
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:2\", \"Bench Press\", \"Strength\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:3\", \"Pendlay Row\", \"Strength\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:4a\", \"Incline DB Press\", \"Conditioning\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:4b\", \"Cable Pull Overs\", \"Conditioning\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:5a\", \"Chest Press\", \"Conditioning\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:5b\", \"Lat Pulldown\", \"Conditioning\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:6a\", \"Cable Cross Over\", \"Conditioning\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:6b\", \"T-Bar Row\", \"Conditioning\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:7a\", \"Cook-Willis Press\", \"Conditioning\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:7b\", \"Pull ups\", \"Conditioning\", \"30000\");");
        //week one, day two
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:2\", \"Standing Overhead Press\", \"Shoulders Arms Workout\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:3\", \"DB Shoulder Press\", \"Shoulders/Arms Workout\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:4a\", \"Lateral Raise\", \"Shoulders/Arms Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:5a\", \"Rear Delt Fly\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:5b\", \"Face Pulls\", \"Shoulders/Arms Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:6a\", \"BB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:6b\", \"Dips\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:7a\", \"DB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:7b\", \"Rope Pushdown\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:8a\", \"Hammer Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:8b\", \"Triceps Pushdown\", \"Shoulders/Arms Workout\", \"45000\");");
        //week one, day three
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:2\", \"Squats\", \"Legs Workout\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:3\", \"Sumo Deadlift\", \"Legs Workout\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:4\", \"Leg Press\", \"Legs Workout\", \"600000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:5a\", \"DB SL Deadlift\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:5b\", \"Walking Lunges\", \"Legs Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:6a\", \"Hamstring Curl\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:6b\", \"Leg Extension\", \"Legs Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:7\", \"Standing Calf Raise\", \"Legs Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:8\", \"Seated Calf Raise\", \"Legs Workout\", \"0\");");
        //week one, day four
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:2\", \"Bench Press\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:3\", \"Pendlay Row\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:4a\", \"Incline DB Press\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:4b\", \"Pull Ups\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:5a\", \"Cable Crossover\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:5b\", \"Chest Dips\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:6a\", \"Lat Pulldown\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:6b\", \"T-Bar Row\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:7a\", \"Cook-Willis Press\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 4\", \"Ex:7b\", \"Pull ups\", \"Chest/Back Workout\", \"30000\");");
        //week one, day five
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:2\", \"DB Shoulder Press\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:3a\", \"Lateral Raise\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:4a\", \"Rear Delt Fly\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:4b\", \"Face Pulls\", \"Chest/Back Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:5a\", \"BB Curl\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:5b\", \"Dips\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:6a\", \"DB Curl\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:6b\", \"Rope Pushdown\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:7a\", \"Hammer Curl\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:7b\", \"Triceps Pushdown\", \"Chest/Back Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:7a\", \"DB Overhead Press\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 5\", \"Ex:7b\", \"BB Curl\", \"Chest/Back Workout\", \"0\");");
        //week one, day six
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:2\", \"Front Squats\", \"Legs workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:3\", \"Back Squat\", \"Legs workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:4\", \"SL Deadlift\", \"Legs workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:5a\", \"Leg Press\", \"Legs workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:5b\", \"Walking Lunges\", \"Legs workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:6a\", \"Hamstring Curl\", \"Legs workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:6b\", \"Leg Extension\", \"Legs workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:7\", \"Standing Calf Raise\", \"Legs workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 6\", \"Ex:8\", \"Seated Calf Raise\", \"Legs workout\", \"30000\");");
        //week two, day one
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:2\", \"Bench Press\", \"Strength\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:3\", \"Pendlay Row\", \"Strength\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:4a\", \"Incline DB Press\", \"Conditioning\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:4b\", \"Cable Pull Overs\", \"Conditioning\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:5a\", \"Chest Press\", \"Conditioning\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:5b\", \"Lat Pulldown\", \"Conditioning\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:6a\", \"Cable Cross Over\", \"Conditioning\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:6b\", \"T-Bar Row\", \"Conditioning\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:7a\", \"Cook-Willis Press\", \"Conditioning\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 1\", \"Ex:7b\", \"Pull ups\", \"Conditioning\", \"30000\");");
        //week two, day two
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:2\", \"Standing Overhead Press\", \"Shoulders/Arms Workout\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:3\", \"DB Shoulder Press\", \"Shoulders/Arms Workout\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:4a\", \"Lateral Raise\", \"Shoulders/Arms Workout\", 30000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:5a\", \"Rear Delt Fly\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " ," + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:5b\", \"Face Pulls\", \"Shoulders/Arms Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:6a\", \"BB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " ," + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:6b\", \"Dips\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:7a\", \"DB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " ," + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:7b\", \"Rope Pushdown\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:8a\", \"Hammer Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 2\", \"Ex:8b\", \"Triceps Pushdown\", \"Shoulders/Arms Workout\", \"45000\");");
        //week two, day three
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " ," + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:2\", \"Squats\", \"Legs Workout\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " ," + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:3\", \"Sumo Deadlift\", \"Legs Workout\", \"120000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + "," + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:4\", \"Leg Press\", \"Legs Workout\", \"600000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:5a\", \"DB SL Deadlift\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " ," + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:5b\", \"Walking Lunges\", \"Legs Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:6a\", \"Hamstring Curl\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " ," + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:6b\", \"Leg Extension\", \"Legs Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " ," + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:7\", \"Standing Calf Raise\", \"Legs Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 3\", \"Ex:8\", \"Seated Calf Raise\", \"Legs Workout\", \"0\");");
        //week two, day four
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:2\", \"Bench Press\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:3\", \"Pendlay Row\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:4a\", \"Incline DB Press\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:4b\", \"Pull Ups\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:5a\", \"Cable Crossover\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:5b\", \"Chest Dips\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:6a\", \"Lat Pulldown\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:6b\", \"T-Bar Row\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:7a\", \"Cook-Willis Press\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 4\", \"Ex:7b\", \"Pull ups\", \"Chest/Back Workout\", \"30000\");");
        //week two, day five
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:2\", \"DB Shoulder Press\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:3a\", \"Lateral Raise\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:4a\", \"Rear Delt Fly\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:4b\", \"Face Pulls\", \"Shoulders/Arms Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:5a\", \"BB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:5b\", \"Dips\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:6a\", \"DB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:6b\", \"Rope Pushdown\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:7a\", \"Hammer Curl\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:7b\", \"Triceps Pushdown\", \"Shoulders/Arms Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:8a\", \"DB Overhead Press\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 5\", \"Ex:8b\", \"BB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        //week two, day six
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:2\", \"Front Squats\", \"Legs workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:3\", \"Back Squat\", \"Legs workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:4\", \"SL Deadlift\", \"Legs workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:5a\", \"Leg Press\", \"Legs workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:5b\", \"Walking Lunges\", \"Legs workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:6a\", \"Hamstring Curl\", \"Legs workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:6b\", \"Leg Extension\", \"Legs workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:7\", \"Standing Calf Raise\", \"Legs workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 2\", \"Day 6\", \"Ex:8\", \"Seated Calf Raise\", \"Legs workout\", \"30000\");");
        //week three, day one
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:2\", \"Bench Press\", \"Chest/Back Workout\", \"450000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:3\", \"Incline DB Press\", \"Chest/Back Workout\", \"600000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:4a\", \"Cable Crossover\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:4b\", \"CG Press\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:5\", \"Pull Ups\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:6\", \"T-Bar Row\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:7a\", \"Seated Row\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 1\", \"Ex:6b\", \"Cable Pullovers\", \"Chest/Back Workout\", \"30000\");");
        //week three day two
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:2\", \"Lateral Raise\", \"Chest/Back Workout\", \"600000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:3a\", \"DB Shoulder Press\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:3b\", \"BB Front Raise\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:4a\", \"Rear Delt Fly\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:4b\", \"Face Pulls\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:5a\", \"BB Curl\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:5b\", \"Dips\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:6a\", \"DB Curl\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:6b\", \"Hammer Curl\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:7a\", \"Rope Pushdown\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:7b\", \"Triceps Pushdown\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:8a\", \"DB Overhead Press\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 2\", \"Ex:8b\", \"BB Curl\", \"Chest/Back Workout\", \"45000\");");
        //week three day three
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:2a\", \"Squats\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:2b\", \"Leg Press\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:2c\", \"Walking Lunges\", \"Legs Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:3a\", \"Box Jumps\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:3b\", \"GHR\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:3c\", \"Split Squat\", \"Legs Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:4a\", \"Hamstring Curl\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:4b\", \"Leg Extension\", \"Legs Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:5\", \"Standing Calf Raise\", \"Legs Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 3\", \"Ex:6\", \"Seated Calf Raise\", \"Legs Workout\", \"30000\");");
        //week three day four
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:2\", \"Bench Press\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:3\", \"Incline DB Press\", \"Chest/Back Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:4a\", \"Cable Crossover\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:4b\", \"CG Press\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:5\", \"Pull Ups\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:6\", \"T-Bar Row\", \"Chest/Back Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:7a\", \"Seated Row\", \"Chest/Back Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 4\", \"Ex:7b\", \"Cable Pullovers\", \"Chest/Back Workout\", \"30000\");");
        //week three day five
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:2\", \"Lateral Raise\", \"Shoulders/Arms Workout\", \"60000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:3a\", \"DB Shoulder Press\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:3b\", \"BB Front Raise\", \"Shoulders/Arms Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:4a\", \"Rear Delt Fly\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:4b\", \"Face Pulls\", \"Shoulders/Arms Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:5a\", \"BB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:5b\", \"Dips\", \"Shoulders/Arms Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:6a\", \"DB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:6b\", \"Hammer Curl\", \"Shoulders/Arms Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:7a\", \"Rope Pushdown\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:7b\", \"Triceps Pushdown\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:8a\", \"DB Overhead Press\", \"Shoulders/Arms Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 5\", \"Ex:8b\", \"BB Curl\", \"Shoulders/Arms Workout\", \"0\");");
        //week three day six
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY  + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:1a\", \"Foam Roll\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:2a\", \"Squats\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:2b\", \"Leg Press\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:2c\", \"Walking Lunges\", \"Legs Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:3a\", \"Box Jumps\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:3b\", \"GHR\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:3c\", \"Split Squat\", \"Legs Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:4a\", \"Hamstring Curl\", \"Legs Workout\", \"0\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:4b\", \"Leg Extension\", \"Legs Workout\", \"45000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:5\", \"Standing Calf Raise\", \"Legs Workout\", \"30000\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 3\", \"Day 6\", \"Ex:6\", \"Seated Calf Raise\", \"Legs Workout\", \"30000\");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_DATA);
        onCreate(sqLiteDatabase);
    }
    public void insert(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY  + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:1a\", \"Foam Roll\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:2\", \"Bench Press\", \"Strength\", 120000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:3\", \"Pendlay Row\", \"Strength\", 120000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:4a\", \"Incline DB Press\", \"Conditioning\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:4b\", \"Cable Pull Overs\", \"Conditioning\", 60000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:5a\", \"Chest Press\", \"Conditioning\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:5b\", \"Lat Pulldown\", \"Conditioning\", 60000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:6a\", \"Cable Cross Over\", \"Conditioning\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:6b\", \"T-Bar Row\", \"Conditioning\", 30000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:7a\", \"Cook-Willis Press\", \"Conditioning\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:7b\", \"Pull ups\", \"Conditioning\", 30000);");
    }

    //add numReps, weight for an exercise
    public void addUserItem(User_Data userData){
        ContentValues values = new ContentValues();
        values.put(COLUMN_EX_ID, userData.get_exID());
        values.put(COLUMN_WEIGHT, userData.get_weight());
        values.put(COLUMN_NUM_REPS, userData.get_numReps());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_USER_DATA, null, values);
        sqLiteDatabase.close();
    }

    //Print out the database as a string
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EXERCISES + " WHERE 1;";

        //Cursor point to a location in your results
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("Week"))!= null){
                dbString += c.getString(c.getColumnIndex("Week"));
                dbString += "\t";
                if(c.getString(c.getColumnIndex("Day")) != null){
                    dbString += c.getString(c.getColumnIndex("Day"));
                    dbString += "\t";
                    if(c.getString(c.getColumnIndex("exerciseNumber")) != null){
                        dbString += c.getString(c.getColumnIndex("exerciseNumber"));
                        dbString += "\t";
                        if(c.getString(c.getColumnIndex("exerciseName")) != null){
                            dbString += c.getString(c.getColumnIndex("exerciseName"));
                            dbString += "\t";
                            if(c.getString(c.getColumnIndex("exerciseType")) != null){
                                dbString += c.getString(c.getColumnIndex("exerciseType"));
                                dbString += "\t";
                                if(c.getString(c.getColumnIndex("restTime")) != null){
                                    dbString += c.getString(c.getColumnIndex("restTime"));
                                }
                            }
                        }
                    }
                }
            }
            dbString += "\n";
            c.moveToNext();
        }
        sqLiteDatabase.close();
        return dbString;
    }

    public Cursor getAllRows(String week, String day){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select rowid _id, * from Exercises WHERE Week = '" + week + "' AND Day = '" + day + "'", null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getAllWeek(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select DISTINCT Week, 1 _id  from Exercises ", null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getAllDay(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select DISTINCT Day, 1 _id  from Exercises ", null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }



  /*  public Cursor getAllWeeks(int id){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select " + COLUMN_WEEK + " from Exercises ", null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    } */

    public String getReps(int id){
        String getReps = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        //String query = "SELECT " + COLUMN_WEEK + " FROM " + TABLE_EXERCISES + " WHERE " + COLUMN_WEEK + " = '" + id + "';";
        String query = "SELECT " + COLUMN_NUM_REPS + " FROM " + TABLE_USER_DATA + " WHERE " + COLUMN_UD_ID + " =" + id + ";";

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("numReps")) != null){
            getReps += c.getString(c.getColumnIndex("numReps"));
        }

        sqLiteDatabase.close();
        return getReps;
    }

    public String getWeight(int id){
        String getWeight = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        //String query = "SELECT " + COLUMN_WEEK + " FROM " + TABLE_EXERCISES + " WHERE " + COLUMN_WEEK + " = '" + id + "';";
        String query = "SELECT " + COLUMN_WEIGHT + " FROM " + TABLE_USER_DATA + " WHERE " + COLUMN_UD_ID + " =" + id + ";";

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("Weight")) != null){
            getWeight += c.getString(c.getColumnIndex("Weight"));
        }

        sqLiteDatabase.close();
        return getWeight;
    }

    //method to get current week
    public String getWeek(int id){
        String week = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        //String query = "SELECT " + COLUMN_WEEK + " FROM " + TABLE_EXERCISES + " WHERE " + COLUMN_WEEK + " = '" + id + "';";
        String query = "SELECT DISTINCT Week FROM " + TABLE_EXERCISES + " WHERE _id =" + id + ";";

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("Week")) != null){
            week += c.getString(c.getColumnIndex("Week"));
        }

        sqLiteDatabase.close();
        return week;
    }

    //method to get current day
    public String getDay(int id){
        String day = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT DISTINCT Day FROM " + TABLE_EXERCISES + " WHERE _id =" + id + ";";
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("Day")) != null){
            day += c.getString(c.getColumnIndex("Day"));
        }
        sqLiteDatabase.close();
        return day;
    }
    //method to get the Exercise Name
    public String getExerciseName(int id){
        String exName = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT " + COLUMN_EXERCISE_NAME + " FROM " + TABLE_EXERCISES + " WHERE " + COLUMN_EXERCISE_ID + " = " + id;

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("exerciseName")) != null){
            exName += c.getString(c.getColumnIndex("exerciseName"));
        }

        sqLiteDatabase.close();
        return exName;
    }

    //method to get the Exercise Name
    public String getExName(int id){
        String exName = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT " + COLUMN_EXERCISE_NAME + " FROM " + TABLE_EXERCISES + " WHERE" + COLUMN_EXERCISE_ID + " = " + id;

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("exerciseName")) != null){
            exName += c.getString(c.getColumnIndex("exerciseName"));
        }

        sqLiteDatabase.close();
        return exName;
    }

    //method to get the Exercise Number
    public String getExerciseNumber(int id){
        String exNum = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT " + COLUMN_EXERCISE_NUMBER + " FROM " + TABLE_EXERCISES + " WHERE " + COLUMN_EXERCISE_ID + " = " + id;

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("exerciseNumber")) != null){
            exNum += c.getString(c.getColumnIndex("exerciseNumber"));
        }

        sqLiteDatabase.close();
        return exNum;
    }

    //method to get the Exercise Number
    public String getExerciseType(int id){
        String exType = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT " + COLUMN_EXERCISE_TYPE + " FROM " + TABLE_EXERCISES + " WHERE " + COLUMN_EXERCISE_ID + " = " + id;

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("exerciseType")) != null){
            exType += c.getString(c.getColumnIndex("exerciseType"));
        }

        sqLiteDatabase.close();
        return exType;
    }

    //method to get the rest time for the exercise and convert to long data type ready for timer
    public long getRestTime(long id){
        String restTime = "";
        long timerTime = 0;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT " + COLUMN_REST_TIME + " FROM " + TABLE_EXERCISES + " WHERE " + COLUMN_EXERCISE_ID + " = " + id;

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("restTime")) != null){
            restTime += c.getString(c.getColumnIndex("restTime"));
        }

        timerTime = Long.parseLong(restTime);

        sqLiteDatabase.close();
        return timerTime;
    }
}