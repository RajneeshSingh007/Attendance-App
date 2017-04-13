package com.attendance.ui.fragments;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.attendance.R;
import com.attendance.base.BaseFragment;
import com.attendance.ui.activities.MainActivity;

/**
 * Created by coolalien on 17,March,2017
 */

public class LoginProcess extends BaseFragment {

    private ImageView teacher;

    /**
     * instance of this class
     * @return
     */
    public static LoginProcess getInstance(){
        return new LoginProcess();
    }

    @Override
    protected int layoutId() {
        return R.layout.login_process;
    }

    @Override
    protected void ui(View rootview) {
        teacher = (ImageView) rootview.findViewById(R.id.teacher_login);
    }

    @Override
    protected void function() {
        teacher.setOnClickListener(onClick);
    }

    @Override
    protected Fragment setfragment() {
        return CommonFragment.getInstance();
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }

    @Override
    public void FrgamentLoader() {
        super.FrgamentLoader();
    }

    /**
     * OnClickListener
     */
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.teacher_login:
                    FrgamentLoader();
                    break;

            }
        }
    };
}
