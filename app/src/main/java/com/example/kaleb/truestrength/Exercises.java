package com.example.kaleb.truestrength;

/**
 * Created by kaleb on 15/10/2016.
 */
public class Exercises {
    private int _exId; //this is the attribute for the unique identified
    private String _week; //this is the attribute for the Week
    private String _day; //this is the attribute for the Day
    private String _exNum; //this is the attribute for the Exercise Number
    private String _exName; //this is the attribute for the Exercise Name
    private String _exType; //this is the attribute for the Exercise Type
    private int _restTime; //this is the attribute for the Rest Time of the exercise

    //Empty constructor so we can have empty values
    public Exercises(){

    }

    //Constructor
    public Exercises(String day, String week, String exType, String exName, String exNum, int restTime) {
        this._day = day;
        this._week = week;
        this._exType = exType;
        this._exName = exName;
        this._exNum = exNum;
        this._restTime = restTime;
    }

    //get method for the Exericse Number
    public String get_exNum() {
        return _exNum;
    }

    //set method for the Exercise Number
    public void set_exNum(String _exNum) {
        this._exNum = _exNum;
    }

    //get method for the Day
    public String get_day() {
        return _day;
    }

    //set method for the Day
    public void set_day(String _day) {
        this._day = _day;
    }

    //get method for the Week
    public String get_week() {
        return _week;
    }

    //set method for the Week
    public void set_week(String _week) {
        this._week = _week;
    }

    //get method for the Exercise Type
    public String get_exType() {
        return _exType;
    }

    //set method for the Exercise Type
    public void set_exType(String _exType) {
        this._exType = _exType;
    }

    //get method for the Exercise Name
    public String get_exName() {
        return _exName;
    }

    //set method for the Exericse Name
    public void set_exName(String _exName) {
        this._exName = _exName;
    }

    //get method for the Exercise ID
    public int get_exId() {
        return _exId;
    }

    //set method for the Exercise ID
    public void set_exId(int _exId) {
        this._exId = _exId;
    }
}
