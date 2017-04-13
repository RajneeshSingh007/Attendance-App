package com.attendance.ui.fragments;

import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.attendance.R;
import com.attendance.base.BaseFragment;
import com.attendance.misc.widgets.VerticalTextView;

/**
 * Created by coolalien on 17,March,2017
 */

public class CommonFragment extends BaseFragment {

    private VerticalTextView Login, LoginTitle;
    private LinearLayout showSignup, showLogin;

    /**
     * Instance of this class
     * @return
     */

    public static CommonFragment getInstance(){
        return new CommonFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.loginprocess_view;
    }

    @Override
    protected void ui(View rootview) {
        Login = (VerticalTextView) rootview.findViewById(R.id.Login);
        LoginTitle = (VerticalTextView) rootview.findViewById(R.id.LoginText);
        showSignup = (LinearLayout) rootview.findViewById(R.id.showsignup);
        showLogin = (LinearLayout) rootview.findViewById(R.id.showSignin);
    }

    @Override
    protected void function() {
        showSigninForm();
    }

    @Override
    protected Fragment setfragment() {
        return null;
    }

    @Override
    protected int setContainerId() {
        return 0;
    }

    /**
    /**
     * signin show
     */
    private void showSigninForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) showLogin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.85f;
        showLogin.requestLayout();


        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) showSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.15f;
        showSignup.requestLayout();

        Animation translate= AnimationUtils.loadAnimation(getContext(),R.anim.translate_left_to_right);
        showLogin.startAnimation(translate);

        LoginTitle.setVisibility(View.VISIBLE);
        Login.setVisibility(View.GONE);
        loginFragmentLoader();

    }


    private void loginFragmentLoader(){
        getFragmentManager().beginTransaction().replace(R.id.login_container, LoginFragment.getInstance(true)).commit();
    }

}
