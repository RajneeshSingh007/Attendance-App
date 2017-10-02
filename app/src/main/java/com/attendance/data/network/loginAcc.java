package com.attendance.data.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.attendance.R;
import com.attendance.misc.utils.Constants;
import com.attendance.misc.utils.Extras;
import com.attendance.ui.fragments.SubjectFragment;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Coolalien on 3/11/2017.
 */

public class loginAcc {

    /**
     * Default constructor
     */
    public loginAcc() {

    }

    /**
     * Login userAccount
     *
     * @param view
     * @param context
     * @param username
     * @param userpass
     * @param inputview
     * @param inputview2
     */
    public static void LoginAccount(final Context contexts, final View view, final Fragment context, final String username, final String userpass, final inputview inputview, final inputview inputview2) {
        final ProgressDialog progressDialog = new ProgressDialog(contexts);
        progressDialog.setProgressStyle(android.R.style.Widget_Material_ProgressBar);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle("Authenication");
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                AndroidNetworking.post(Constants.LOGINURL) //LoginUrl
                        .addBodyParameter("username", username) //passed userName input from EditText
                        .addBodyParameter("password", userpass) //passed password input from EditText
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                inputview.gettext().getText().clear();
                                inputview2.gettext().getText().clear();
                                Extras extras = new Extras(contexts);
                                try {
                                    boolean goterror = response.getBoolean("error");
                                    JSONObject jsonObject = response.optJSONObject("user");
                                    if (!goterror) {
                                        progressDialog.dismiss();
                                        Log.d("Login", "" + response);
                                        Log.d("Logged as", jsonObject.optString("username"));//response from json
                                        Toast.makeText(context.getActivity(), "Logged In", Toast.LENGTH_LONG).show();
                                        String username = jsonObject.optString("username");
                                        extras.setuserLogginSession(username, true);
                                        context.getFragmentManager().beginTransaction().replace(R.id.container, SubjectFragment.getInstance()).commit();
                                    } else {
                                        progressDialog.dismiss();
                                        String errorMsg = response.getString("error_msg");
                                        Snackbar.make(view, errorMsg, Snackbar.LENGTH_LONG).setText(errorMsg).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                Log.d("Login", "Failed");
                                anError.printStackTrace();
                            }
                        });
            }
        }, 500);
        Log.d("Teacher", "LoginPage");

    }
}

