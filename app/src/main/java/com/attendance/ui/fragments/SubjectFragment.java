package com.attendance.ui.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.attendance.R;
import com.attendance.base.BaseFragment;
import com.attendance.misc.utils.Extras;
import com.attendance.ui.activities.AboutActivity;
import com.attendance.ui.activities.MainActivity;
import com.attendance.ui.fragments.dataupdate.AttendanceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coolalien on 17,March,2017
 */

public class SubjectFragment extends BaseFragment implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView subjectName,subjectName1,subjectName2,subjectName3,subjectName4,subjectName5;
    private Toolbar toolbar;
    private Extras pref;
    private View navigationHeader;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle barDrawerToggle;
    private TextView userName;

    private AppCompatSpinner appCompatSpinner,appCompatSpinner1,appCompatSpinner2;
    private ArrayAdapter<String> arrayAdapter,arrayAdapter1,arrayAdapter2;
    private List<String> divList;
    private List<String> statusList;
    private List<String> timelist;

    /**
     * Instance of this class
     * @return
     */
    public static SubjectFragment getInstance() {
        return new SubjectFragment();
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_subject;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
        subjectName = (ImageView) rootview.findViewById(R.id.subject_name);
        subjectName1 = (ImageView) rootview.findViewById(R.id.subject_name1);
        subjectName2 = (ImageView) rootview.findViewById(R.id.subject_name2);
        subjectName3 = (ImageView) rootview.findViewById(R.id.subject_name3);
        subjectName4 = (ImageView) rootview.findViewById(R.id.subject_name4);
        subjectName5 = (ImageView) rootview.findViewById(R.id.subject_name5);
        navigationView = (NavigationView) rootview.findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) rootview.findViewById(R.id.drawerLayout);
        navigationHeader = navigationView.inflateHeaderView(R.layout.navigation_headerview);
        userName = (TextView) navigationHeader.findViewById(R.id.userName);
    }

    @Override
    protected void function() {
        toolbar.setTitle("Attendance");
        subjectName.setOnClickListener(onClick);
        subjectName1.setOnClickListener(onClick);
        subjectName2.setOnClickListener(onClick);
        subjectName3.setOnClickListener(onClick);
        subjectName4.setOnClickListener(onClick);
        subjectName5.setOnClickListener(onClick);
        pref = new Extras(getContext());
        MainActivity mainActivity = ((MainActivity) getActivity());
        barDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(barDrawerToggle);
        barDrawerToggle.syncState();
        if (toolbar != null) {
            mainActivity.setSupportActionBar(toolbar);
            if (mainActivity.getSupportActionBar() != null) {
                mainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                mainActivity.getSupportActionBar().setHomeButtonEnabled(true);
                mainActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        }
        navigationView.setNavigationItemSelectedListener(this);
        setHasOptionsMenu(true);
        if (toolbar != null){
            mainActivity.setSupportActionBar(toolbar);
        }
        if (userName != null){
            if (!TextUtils.isEmpty(pref.getUserName())){
                userName.setText(pref.getUserName());
            }
        }
        setHasOptionsMenu(true);
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.subject_name:
                    DialogPicker();
                    pref.saveTableData("attendance");
                    break;

                case R.id.subject_name1:
                    DialogPicker();
                    pref.saveTableData("attendance1");
                    break;

                case R.id.subject_name2:
                    DialogPicker();
                    pref.saveTableData("attendance2");
                    break;

                case R.id.subject_name3:
                    DialogPicker();
                    pref.saveTableData("attendance3");
                    break;

                case R.id.subject_name4:
                    DialogPicker();
                    pref.saveTableData("attendance4");
                    break;

                case R.id.subject_name5:
                    DialogPicker();
                    pref.saveTableData("attendance5");
                    break;
            }
        }
    };

    @Override
    protected Fragment setfragment() {
        return AttendanceFragment.getInstance(pref.getDiv());
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_log, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                pref.getUserSessionEdit().clear();
                pref.getUserSessionEdit().commit();
                getFragmentManager().beginTransaction().replace(setContainerId(), LoginProcess.getInstance()).commit();
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        drawerLayout.closeDrawers();
        drawerLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (item.getItemId()) {
                    case R.id.attendance:
                        if (SubjectFragment.getInstance().isAdded()){
                            getFragmentManager().beginTransaction().detach(SubjectFragment.getInstance()).attach(SubjectFragment.getInstance()).addToBackStack(null).commit();
                        }
                        break;
                    case R.id.about:
                        Intent intents = new Intent(getActivity(), AboutActivity.class);
                        startActivity(intents);
                        break;
                }
            }
        }, 75);
        return true;
    }

    private void DialogPicker(){
        View divView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_div, null);

        appCompatSpinner =  (AppCompatSpinner) divView.findViewById(R.id.div_selection);
        appCompatSpinner1 = (AppCompatSpinner) divView.findViewById(R.id.status_selection);
        appCompatSpinner2 = (AppCompatSpinner) divView.findViewById(R.id.time);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Attendance Config");
        builder.setView(divView);
        builder.setCancelable(true);
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FrgamentLoader();
            }
        });
        builder.show();
        divList = new ArrayList<>();
        statusList = new ArrayList<>();
        timelist = new ArrayList<>();

        //////////////// Data fill in arraylist //////////////
        divList.add("A");
        divList.add("B");
        statusList.add("present");
        statusList.add("absent");
        timelist.add("9:30Am - 10:30Am");
        timelist.add("10:30Am - 11:30Am");
        timelist.add("11:45Am - 12:45Pm");
        timelist.add("12:45Pm - 1:45Pm");
        timelist.add("2:30Pm - 3:30Pm");
        timelist.add("3:30Pm - 4:30Pm");
        timelist.add("4:30Pm - 5:30Pm");
        /////////////////////////////

        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, divList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appCompatSpinner.setAdapter(arrayAdapter);
        appCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    pref.setDiv(divList.get(0));
                }else if (position == 1){
                    pref.setDiv(divList.get(1));
                }else {
                    Log.d("SubjectFragment", "Error buddy");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, statusList);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appCompatSpinner1.setAdapter(arrayAdapter1);
        appCompatSpinner1.setVisibility(View.VISIBLE);
        appCompatSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    pref.setStatus(statusList.get(0));
                }else if (position == 1){
                    pref.setStatus(statusList.get(1));
                }else {
                    Log.d("SubjectFragment", "Error buddy");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, timelist);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appCompatSpinner2.setAdapter(arrayAdapter2);
        appCompatSpinner2.setVisibility(View.VISIBLE);
        appCompatSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("SubjectFragment", "Error buddy"+ timelist.get(1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}
