package com.example.kaleb.truestrength;

/**
 * Created by kaleb on 15/10/2016.
 */
public class User_Data {

    private int _udID; //attribute for the unique identifier
    private int _weight; // attribute for the Weight lifted
    private int _numReps; //attribute for the Number of Reps done.

    //Empty constructor so we can have null values
    public User_Data(){

    }

    //Constructor
    public User_Data(int numReps, int weight) {
        this._numReps = numReps;
        this._weight = weight;
    }

    //get method for Number of Reps
    public int get_numReps() {
        return _numReps;
    }

    //set method for Number of Reps
    public void set_numReps(int _numReps) {
        this._numReps = _numReps;
    }

    //get method for Weight lifted
    public int get_weight() {
        return _weight;
    }

    //set method for Weight lifted
    public void set_weight(int _weight) {
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
}
