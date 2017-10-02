package com.attendance.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Coolalien on 3/11/2017.
 */

public abstract class BaseFragment extends Fragment {

    /**
     * Abstract method
     * @return
     */
    protected abstract int layoutId();
    protected abstract void ui(View rootview);
    protected abstract void function();
    protected abstract Fragment setfragment();
    protected abstract int setContainerId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(layoutId(), container, false);
        ui(rootview);
        function();
        return rootview;
    }



    /**
     * Fragment Load
     */
    public void FrgamentLoader(){
        getFragmentManager().beginTransaction().replace(setContainerId(), setfragment()).addToBackStack(null).commit();
    }

}
