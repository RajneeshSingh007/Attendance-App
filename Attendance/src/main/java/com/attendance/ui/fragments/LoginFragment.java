package com.attendance.ui.fragments;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.attendance.R;
import com.attendance.base.BaseFragment;
import com.attendance.data.network.inputview;
import com.attendance.data.network.loginAcc;
import com.attendance.ui.activities.MainActivity;

/**
 * Created by coolalien on 17,March,2017
 */

public class LoginFragment extends BaseFragment {

    private TextInputEditText passwordInput, usernameInput;
    private AppCompatButton login;
    private String username, userpass;
    private static boolean buttonAnim;

    /**
     * Instance of fragment
     * @return
     */
    public static LoginFragment getInstance(boolean buttonAnim){
        setButtonAnim(buttonAnim);
        return new LoginFragment();
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void ui(View rootview) {
        usernameInput = (TextInputEditText) rootview.findViewById(R.id.input_username);
        passwordInput = (TextInputEditText) rootview.findViewById(R.id.input_password);
        login = (AppCompatButton) rootview.findViewById(R.id.btn_login);
    }

    @Override
    protected void function() {
        login.setEnabled(true);
        if (buttonAnim){
            Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.rotate_right_to_left);
            login.setAnimation(animation);
        }
        login.setOnClickListener(onClick);
    }

    @Override
    protected Fragment setfragment() {
        return SubjectFragment.getInstance();
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
     * OnCLickListerner
     */
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            switch (view.getId()){

                case R.id.btn_login:
                    Login(view);
                    break;
            }
        }
    };

    /**
     * Login
     * @param view
     */
    private void Login(View view){
        username = usernameInput.getText().toString().trim();
        userpass = passwordInput.getText().toString().trim();
        if (!username.isEmpty() && !userpass.isEmpty()){
            loginAcc.LoginAccount(getContext(),view, LoginFragment.this, username, userpass, new inputview() {
                @Override
                public TextInputEditText gettext() {
                    return usernameInput;
                }
            }, new inputview() {
                @Override
                public TextInputEditText gettext() {
                    return passwordInput;
                }
            });
        }else{
            if (username.isEmpty()) {
                usernameInput.setError("enter a valid UserName");
            }
            if (userpass.isEmpty() || passwordInput.length() < 4 || passwordInput.length() > 10) {
                passwordInput.setError("enter a valid password");
            }
        }
    }

    public static void setButtonAnim(boolean buttonAnims) {
        buttonAnim = buttonAnims;
    }
}
