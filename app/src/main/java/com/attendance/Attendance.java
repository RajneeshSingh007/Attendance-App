package com.attendance;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.attendance.misc.utils.Extras;


/**
 * Created by Coolalien on 3/11/2017.
 */

public class Attendance extends Application {

    private static Attendance istance;
    private Extras pref;

    @Override
    public void onCreate() {
        super.onCreate();
        istance = this;
        AndroidNetworking.initialize(this);
        pref = new Extras(this);
        pref.setrollNo(80);
    }

    /**
     * Instance of this class
     * @return
     */
    public static Attendance getInstance() {
        return istance;
    }

}

