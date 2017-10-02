package com.attendance.ui.fragments.dataupdate;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.attendance.R;
import com.attendance.base.BaseFragment;
import com.attendance.data.model.AttendanceModel;
import com.attendance.misc.utils.Constants;
import com.attendance.misc.utils.Extras;
import com.attendance.misc.utils.Helpers;
import com.attendance.ui.activities.MainActivity;
import com.attendance.ui.adapters.attendanceloadAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.attendance.misc.utils.Constants.FILTERAT;


/**
 * Created by coolalien on 18,March,2017
 */

public class AttendanceFragment extends BaseFragment {


    private RecyclerView rv;
    private attendanceloadAdapter attendanceloadAdapter;
    private Toolbar toolbar;
    private List<AttendanceModel> attendanceModels;
    private AttendanceModel attendanceModel;
    private Extras prefrences;
    private FloatingActionButton saveAtButton;
    private static String div;


    private AppCompatSpinner appCompatSpinner,appCompatSpinner1,appCompatSpinner2;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> divList;
    private List<Integer> otherList;
    private List<Integer> filterData;


    /**
     * Instance of this clas
     * @return
     */
    public static AttendanceFragment getInstance(String div){
        setDiv(div);
        return new AttendanceFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.common_rv;
    }

    @Override
    protected void ui(View rootview) {
        rv = (RecyclerView) rootview.findViewById(R.id.rv);
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
        saveAtButton = (FloatingActionButton) rootview.findViewById(R.id.save_at);
    }

    @Override
    protected void function() {
        prefrences = new Extras(getContext());
        saveAtButton.setVisibility(View.VISIBLE);
        toolbar.setTitle("Attendance");
        attendanceModels = new ArrayList<>();
        otherList = new ArrayList<>();
        filterData = new ArrayList<>();
        toolbar.showOverflowMenu();
        if (prefrences.getrollNo() != -1){
            int limit = prefrences.getrollNo();
            for (int i=1; i<=limit; i++){
                attendanceModel = new AttendanceModel();
                attendanceModel.setId(i);
                attendanceModel.setAtrollno(String.valueOf(i));
                attendanceModel.setAtdiv(div);
                attendanceModels.add(attendanceModel);
                attendanceloadAdapter = new attendanceloadAdapter(getContext(), attendanceModels);
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new GridLayoutManager(getContext(), 4, GridLayoutManager.VERTICAL, false));
                rv.setAdapter(attendanceloadAdapter);
                otherList.add(i);
                prefrences.unsaveatData(otherList);
            }
        }else {
            Log.d("AttendanceFragment", "Error");
        }
        setHasOptionsMenu(true);
        MainActivity mainActivity = ((MainActivity) getActivity());
        if (toolbar != null) {
            mainActivity.setSupportActionBar(toolbar);
            if (mainActivity.getSupportActionBar() != null) {
                mainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                mainActivity.getSupportActionBar().setHomeButtonEnabled(true);
                mainActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        }
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy >0){
                    saveAtButton.hide();
                }else {
                    saveAtButton.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        saveAtButton.setImageBitmap(Helpers.textAsBitmap("Save", 16, Color.WHITE));
        saveAtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveClick();
            }
        });
    }

    @Override
    protected Fragment setfragment() {
        return AttendanceViewFragment.getInstance();
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.attendance_view, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.attendance_view:
                DialogPicker();
                break;
            case R.id.attendance_view2:
                shortAttendanceView();
                break;
        }
        return true;
    }


    public static String getDiv() {
        return div;
    }

    public static void setDiv(String divs) {
      div = divs;
    }

     //////////////////////// Selection Dialog //////////////////////////////////

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
        divList.add("A");
        divList.add("B");
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, divList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appCompatSpinner.setAdapter(arrayAdapter);
        appCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    prefrences.setDiv(divList.get(0));
                }else if (position == 1){
                    prefrences.setDiv(divList.get(1));
                }else {
                    Log.d("SubjectFragment", "Error buddy");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        appCompatSpinner1.setVisibility(View.GONE);
        appCompatSpinner2.setVisibility(View.GONE);
    }


    ////////////////// short attendance view //////////////////

    private TextView totalPresent, totalAbsent;

    private void shortAttendanceView(){
        View quickView = LayoutInflater.from(getContext()).inflate(R.layout.dailog_quick, null);

        totalPresent = (TextView) quickView.findViewById(R.id.total_present);
        totalAbsent = (TextView) quickView.findViewById(R.id.total_absent);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Attendance view");
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
            }
        });
        builder.setView(quickView);
        builder.show();

        AndroidNetworking.post(Constants.QUICKATTENDANCE)
                .addBodyParameter("tablename", prefrences.getTableData())
                .addBodyParameter("date", prefrences.getDTime())
                .addBodyParameter("atstatus", prefrences.getStatus())
                .addBodyParameter("atdiv", prefrences.getDiv())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0){
                            for (int k = 0; k <response.length(); k++){
                                JSONObject json;
                                try {
                                    json = response.getJSONObject(k);
                                    String total = json.getString("Total");
                                    String status = json.getString("Status");
                                    Log.d("AttendanceViewFragment", total);
                                    if (status.equals("present")){
                                        totalPresent.setText("Total Present : " + total);
                                        int absentvalues = prefrences.getrollNo() - prefrences.getatData().size();
                                        totalAbsent.setText("Total Absent : " +String.valueOf(absentvalues));
                                    }else if (status.equals("absent")){
                                        totalAbsent.setText("Total Absent : " + total);
                                        int absentvalues = prefrences.getrollNo() - prefrences.getatData().size();
                                        totalPresent.setText("Total Present : " +String.valueOf(absentvalues));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                        Log.d("Attendance", "error", anError);
                    }
                });
    }

    /////////// onClick ///////////////
    private void onSaveClick(){
        if (prefrences.getDiv().equals("A")){
            prefrences.saveCounter(prefrences.getCounter()+1);
        }else if (prefrences.getDiv().equals("B")){
            prefrences.saveCounterSecond(prefrences.getCounterSecond() +1);
        }
        for (int rollno : prefrences.getatData()){
            addAtData(prefrences.getStatus(),rollno);

        }
        try {
            prefrences.getSharedPreferences().edit().remove(FILTERAT).commit();
            Log.d("Log", "Cleared");
        }finally {
            for (int k : prefrences.getunsaveData()){
                if (!prefrences.getatData().contains(k)){
                    filterData.add(k);
                    prefrences.filterData(filterData);
                }
            }
            if (prefrences.getStatus().equals("present")){
                Log.d("Log", "workingA");
                adduncheckatData("absent");
            }else if (prefrences.getStatus().equals("absent")){
                Log.d("Log", "workingP");
                adduncheckatData("present");
            }
        }
    }


    ///////////////////// Add Attendance Data in database //////////////

    private void addAtData(String status, int rollno){
        AndroidNetworking.post(Constants.INSERTATTEND)
                .addBodyParameter("tablename", prefrences.getTableData())
                .addBodyParameter("atrollno", String.valueOf(rollno))
                .addBodyParameter("atdiv",  prefrences.getDiv())
                .addBodyParameter("atstatus", status)
                .addBodyParameter("atdate", Helpers.now())
                .setTag("saving_data")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            boolean goterror = response.getBoolean("error");
                            if (!goterror) {
                                Log.d("Saving Attendance", "" + response); //response from json
                                String format = Helpers.now().substring(0, Helpers.now().length()-9);
                                prefrences.saveDTime(format);
                                Snackbar.make(rv,"Saved In Db", Snackbar.LENGTH_LONG).setText("Saved in database").show();
                            } else {
                                String errorMsg = response.getString("error_msg");
                                Log.d("attendanceAdapter", errorMsg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

    private void adduncheckatData(String status){
        for (int kool : prefrences.getfilterData()){
            addAtData(status, kool);
        }
    }
}
