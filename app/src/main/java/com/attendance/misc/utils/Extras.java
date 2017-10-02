package com.attendance.misc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.attendance.misc.utils.Constants.ATDATA;
import static com.attendance.misc.utils.Constants.COUNTER;
import static com.attendance.misc.utils.Constants.COUNTER2;
import static com.attendance.misc.utils.Constants.DATETIME;
import static com.attendance.misc.utils.Constants.DIV;
import static com.attendance.misc.utils.Constants.ENDDATE;
import static com.attendance.misc.utils.Constants.FILTERAT;
import static com.attendance.misc.utils.Constants.INOUROUT;
import static com.attendance.misc.utils.Constants.ROLLNO;
import static com.attendance.misc.utils.Constants.STARTDATE;
import static com.attendance.misc.utils.Constants.STATUS;
import static com.attendance.misc.utils.Constants.UNSAVEDAT;
import static com.attendance.misc.utils.Constants.USERNAME;

/**
 * Created by coolalien on 17,March,2017
 */

public class Extras {

    public Context context;

    private SharedPreferences userSession;
    private SharedPreferences.Editor userSessionEdit;
    private SharedPreferences sharedPreferences;

    /**
     * Constructor
     * @param context
     */
    public Extras (Context context){
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        userSession = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        userSessionEdit = userSession.edit();
    }



    /**
     * Return sharedpref
     * @return
     */
    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }


    //////////////////// LOGIN SESSION //////////////////////

    /**
     * Enable userlogin Session
     * @param username
     */
    public void setuserLogginSession(String username, Boolean torf) {
        userSessionEdit.putBoolean(INOUROUT, torf);
        userSessionEdit.putString(USERNAME, username);
        userSessionEdit.commit();
    }

    /**
     * Is User Logged or not
     * @return
     */
    public boolean isLogged(){
        return userSession.getBoolean(INOUROUT, false);
    }


    /**
     * Username
     * @return
     */
    public String getUserName(){
        return userSession.getString(USERNAME, null);
    }

    public SharedPreferences.Editor getUserSessionEdit() {
        return userSessionEdit;
    }



    /////////////////////// Attendance date between save ///////////////

    /**
     * Set start date
     * @param startDate
     */
    public void setStartDate(String startDate){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STARTDATE, startDate);
        editor.apply();
    }

    /**
     * Return start date
     * @return
     */
    public String getStartDate(){
        return sharedPreferences.getString(STARTDATE, null);
    }


    /**
     * Set end date
     * @param endDate
     */
    public void setEndDate(String endDate){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ENDDATE, endDate);
        editor.apply();
    }

    /**
     * Return end date
     * @return
     */
    public String getEndDate(){
        return sharedPreferences.getString(ENDDATE, null);
    }

    /////////////////////// Attendance Work ////////////////////////

    /**
     * Save checked Attendance data
     * @param list
     */
    public void saveatData(List<Integer> list) {
        String s = "";
        for (Integer i : list) {
            s += i + ",";
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ATDATA, s);
        editor.commit();
    }

    /**
     * Return checked Attendance data
     * @return
     */
    public ArrayList<Integer> getatData() {
        String s = sharedPreferences.getString(ATDATA, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }

    /**
     * Save unchecked Attendance data
     * @param list
     */
    public void unsaveatData(List<Integer> list) {
        String s = "";
        for (Integer i : list) {
            s += i + ",";
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(UNSAVEDAT, s);
        editor.commit();
    }

    /**
     * Return unchecked Attendance data
     * @return
     */
    public ArrayList<Integer> getunsaveData() {
        String s = sharedPreferences.getString(UNSAVEDAT, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }


    /**
     * Save filter Attendance data
     * @param list
     */
    public void filterData(List<Integer> list) {
        String s = "";
        for (Integer i : list) {
            s += i + ",";
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FILTERAT, s);
        editor.commit();
    }

    /**
     * Return filter Attendance data
     * @return
     */
    public ArrayList<Integer> getfilterData() {
        String s = sharedPreferences.getString(FILTERAT, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }

    /////////////// Counter record ///////////////

    /**
     * Save onclick int value for attendance
     * @param value
     */
    public void saveCounter(int value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER, value);
        editor.apply();
    }

    /**
     * Return counter value
     * @return
     */
    public int getCounter(){
        return sharedPreferences.getInt(COUNTER, 0);
    }

    /**
     * Save Second Counter
     * @param value
     */
    public void saveCounterSecond(int value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER2, value);
        editor.apply();
    }

    /**
     * Return counter second value
     * @return
     */
    public int getCounterSecond(){
        return sharedPreferences.getInt(COUNTER2, 0);
    }

    //////////////// Div Record /////////////

    /**
     * Set Div
     * @param value
     */
    public void setDiv(String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DIV, value);
        editor.apply();
    }


    /**
     * Return div
     * @return
     */
    public String getDiv(){
        return sharedPreferences.getString(DIV, null);
    }


    ////////////////// Attendance Status Record ////////////////


    /**
     * Set Status
     * @param value
     */
    public void setStatus(String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STATUS, value);
        editor.apply();
    }


    /**
     * Return div
     * @return
     */
    public String getStatus(){
        return sharedPreferences.getString(STATUS, null);
    }


    /////////////////// Rollno save //////////////////////

    /**
     * Set rollno
     * @param rollno
     */
    public void setrollNo(int rollno){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(ROLLNO, rollno);
        editor.apply();
    }

    /**
     * get rollno
     * @return
     */
    public int getrollNo(){
        return sharedPreferences.getInt(ROLLNO, 0);
    }

    ////////////// Save attendance Date & time ///////////////////

    /**
     * Save date and time
     * @param dtime
     */
    public void saveDTime(String dtime){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DATETIME, dtime);
        editor.apply();
    }

    public String getDTime(){
        return sharedPreferences.getString(DATETIME, null);
    }


    //////////////// table track //////////////


    public void saveTableData(String tabledata){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("TableData", tabledata);
        editor.apply();
    }

    public String getTableData(){
        return sharedPreferences.getString("TableData", null);
    }
}

