package com.example.kaleb.truestrength;

/**
 * Created by kaleb on 15/10/2016.
 */
public class User_Data {

    private int _udID; //attribute for the unique identifier
    private int _exID; //attribute for the exercise id.
    private String _weight; // attribute for the Weight lifted
    private String _numReps; //attribute for the Number of Reps done.

    //Empty constructor so we can have null values
    public User_Data(){

    }

    //Constructor
    public User_Data(String numReps, String weight, int exID) {
        this._numReps = numReps;
        this._weight = weight;
        this._exID = exID;
    }

    //get method for Number of Reps
    public String get_numReps() {
        return _numReps;
    }

    //set method for Number of Reps
    public void set_numReps(String _numReps) {
        this._numReps = _numReps;
    }

    //get method for Weight lifted
    public String get_weight() {
        return _weight;
    }

    //set method for Weight lifted
    public void set_weight(String _weight) {
        this._weight = _weight;
    }

    //get method for User Data ID
    public int get_udID() {
        return _udID;
    }

    //set method for User Data ID
    public void set_udID(int _udID) {
        this._udID = _udID;
    }

    //get method for the exercise ID
    public int get_exID() {
        return _exID;
    }

    //set method for the exercise ID
    public void set_exID(int _exID) {
        this._exID = _exID;
    }
}
