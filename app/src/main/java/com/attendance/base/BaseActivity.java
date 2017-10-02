package com.attendance.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Coolalien on 3/11/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * abstract methods
     * @return
     */
    protected abstract int layoutID();
    protected abstract void ui();
    protected abstract void function();
    protected abstract Fragment setfragment();
    protected abstract int setContainerId();

    /**
     * onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layoutID());
        ui();
        function();
    }

    /**
     * Fragment Load
     */
    public void FrgamentLoader(){
        getSupportFragmentManager().beginTransaction().replace(setContainerId(), setfragment()).commit();
    }

}
