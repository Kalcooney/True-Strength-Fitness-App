package com.example.kaleb.truestrength;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.id;

public class MyDBHandler extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 9; //current version of the database
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
                COLUMN_REST_TIME + " INTEGER " + ");";

        //Create the User Data table
        String udQuery = "CREATE TABLE " + TABLE_USER_DATA + "(" +
                COLUMN_UD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EX_ID + " INTEGER , " +
                COLUMN_WEIGHT + " INTEGER, " +
                COLUMN_NUM_REPS + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_EX_ID + ") REFERENCES " + TABLE_EXERCISES + "(" +
                COLUMN_EXERCISE_ID + "));";

        sqLiteDatabase.execSQL(exQuery);
        sqLiteDatabase.execSQL(udQuery);
        //sqLiteDatabase.execSQL(insertInitialData());
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
        //week one, day two
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY  + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:1a\", \"Foam Roll\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:2\", \"Standing Overhead Press\", \"Shoulders Arms Workout\", 120000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:3\", \"DB Shoulder Press\", \"Shoulders/Arms Workout\", 120000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:4a\", \"Lateral Raise\", \"Shoulders/Arms Workout\", 30000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:5a\", \"Rear Delt Fly\", \"Shoulders/Arms Workout\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:5b\", \"Face Pulls\", \"Shoulders/Arms Workout\", 30000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:6a\", \"BB Curl\", \"Shoulders/Arms Workout\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:6b\", \"Dips\", \"Shoulders/Arms Workout\", 60000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:7a\", \"DB Curl\", \"Shoulders/Arms Workout\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:7b\", \"Rope Pushdown\", \"Shoulders/Arms Workout\", 60000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:8a\", \"Hammer Curl\", \"Shoulders/Arms Workout\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 2\", \"Ex:8b\", \"Triceps Pushdown\", \"Shoulders/Arms Workout\", 45000);");
        //week one, day three
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY  + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:1a\", \"Foam Roll\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:2\", \"Squats\", \"Legs Workout\", 120000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:3\", \"Sumo Deadlift\", \"Legs Workout\", 120000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:4\", \"Leg Press\", \"Legs Workout\", 600000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:5a\", \"DB SL Deadlift\", \"Legs Workout\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:5b\", \"Walking Lunges\", \"Legs Workout\", 60000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:6a\", \"Hamstring Curl\", \"Legs Workout\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:6b\", \"Leg Extension\", \"Legs Workout\", 30000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + " , " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:7\", \"Standing Calf Raise\", \"Legs Workout\", 30000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 3\", \"Ex:8\", \"Seated Calf Raise\", \"Legs Workout\");");
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

    public long getRestTime(long id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT " + COLUMN_REST_TIME + " FROM " + TABLE_EXERCISES + " WHERE " + COLUMN_EXERCISE_ID + " = " + id;

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        long restTime = c.getLong(6);
        sqLiteDatabase.close();
        return restTime;
    }
}