package com.attendance.ui.fragments.dataupdate;

import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.appeaser.sublimepickerlibrary.datepicker.SelectedDate;
import com.appeaser.sublimepickerlibrary.helpers.SublimeOptions;
import com.attendance.R;
import com.attendance.base.BaseFragment;
import com.attendance.data.model.AttendanceResult;
import com.attendance.misc.utils.Constants;
import com.attendance.misc.utils.Extras;
import com.attendance.ui.activities.MainActivity;
import com.attendance.ui.fragments.dialog.DatePickerFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Created by coolalien on 23,March,2017
 */

public class AttendanceViewFragment extends BaseFragment {

    private Extras prefrences;
    private Toolbar toolbar;
    private TableLayout tableLayout;
    private TextView totalLect;

    /**
     * Instance of this class
     * @return
     */
    public static AttendanceViewFragment getInstance(){
        return new AttendanceViewFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_attendanceview;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
        tableLayout = (TableLayout) rootview.findViewById(R.id.table);
        totalLect = (TextView) rootview.findViewById(R.id.totalLect);
    }

    @Override
    protected void function() {
        toolbar.setTitle("Attendance Result");
        prefrences = new Extras(getContext());
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
       calendarView();
    }

    private void calendarView(){
        if (prefrences.getDiv().equals("A")){
            totalLect.setText("Total Lectures: " +String.valueOf(prefrences.getCounter()));
        }else if (prefrences.getDiv().equals("B")){
            totalLect.setText("Total Lectures: " +String.valueOf(prefrences.getCounterSecond()));
        }
        final DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        // Options
        Pair<Boolean, SublimeOptions> optionsPair = getOptions();
        // Valid options
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUBLIME_OPTIONS", optionsPair.second);
        datePickerFragment.setArguments(bundle);
        datePickerFragment.setCallback(new DatePickerFragment.Callback() {
            @Override
            public void onCancelled() {
                datePickerFragment.dismiss();
            }

            @Override
            public void onDateTimeRecurrenceSet(SelectedDate selectedDate) {
                datePickerFragment.dismiss();
                prefrences.setStartDate(String.valueOf(selectedDate.getStartDate().get(Calendar.YEAR))+"-"+"0" +String.valueOf(selectedDate.getStartDate().get(Calendar.MONTH)+1)+"-"+ String.valueOf(selectedDate.getStartDate().get(Calendar.DATE)));
                prefrences.setEndDate(String.valueOf(selectedDate.getEndDate().get(Calendar.YEAR))+"-"+"0" +String.valueOf(selectedDate.getEndDate().get(Calendar.MONTH)+1)+"-"+ String.valueOf(selectedDate.getEndDate().get(Calendar.DATE)));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadAttendData();
                    }
                },200);
            }
        });
        datePickerFragment.show(this.getFragmentManager(), "SUBLIME_PICKER");
    }

    private Pair<Boolean, SublimeOptions> getOptions() {
        SublimeOptions options = new SublimeOptions();
        int displayOptions = 0;
        displayOptions |= SublimeOptions.ACTIVATE_DATE_PICKER;
        options.setPickerToShow(SublimeOptions.Picker.DATE_PICKER);
        options.setAnimateLayoutChanges(true);

        options.setDisplayOptions(displayOptions);

        // Enable/disable the date range selection feature
        options.setCanPickDateRange(true);
        return new Pair<>(displayOptions != 0 ? Boolean.TRUE : Boolean.FALSE, options);
    }

    @Override
    protected Fragment setfragment() {
        return AttendanceViewFragment.getInstance();
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }

    /**
     * Load attendance Data
     */
    private void loadAttendData(){
        TableRow tr = new TableRow(getContext());
        final String startDate = prefrences.getStartDate();
        final String endDate = prefrences.getEndDate();
        String lect = null;
        if (prefrences.getDiv().equals("A")){
            lect = String.valueOf(prefrences.getCounter());
        }else if (prefrences.getDiv().equals("B")){
            lect = String.valueOf(prefrences.getCounterSecond());
        }
        String div = prefrences.getDiv();
        String status = prefrences.getStatus();
        Log.d("StartDate", startDate);
        Log.d("EndDate", endDate);
        TextView b6 = new TextView(getContext());
        b6.setText("Sn");
        b6.setTextColor(Color.BLUE);
        b6.setTextSize(16);
        b6.setPadding(10,10,10,10);
        tr.addView(b6);
        TextView b19 = new TextView(getContext());
        b19.setPadding(10,10,10,10);
        b19.setTextSize(16);
        b19.setText("Rollno");
        b19.setTextColor(Color.BLUE);
        tr.addView(b19);
        TextView b29 = new TextView(getContext());
        b29.setPadding(10,10,10,10);
        b29.setText("Total");
        b29.setTextColor(Color.BLUE);
        b29.setTextSize(16);
        tr.addView(b29);
        TextView b30 = new TextView(getContext());
        b30.setPadding(10,10,10,10);
        b30.setText("Percentage");
        b30.setTextColor(Color.BLUE);
        b30.setTextSize(16);
        tr.addView(b30);
        tableLayout.addView(tr);
        View vline1 = new View(getContext());
        vline1.setBackgroundColor(Color.BLUE);
        tableLayout.addView(vline1);
        AndroidNetworking.post(Constants.VIEWATTENDANCE)
                .addBodyParameter("tablename", prefrences.getTableData())
                .addBodyParameter("startdate", startDate)
                .addBodyParameter("enddate", endDate)
                .addBodyParameter("lect", lect)
                .addBodyParameter("atdiv", div)
                .addBodyParameter("atstatus", status)
                .setPriority(Priority.HIGH)
                .setTag("get__atresults")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                            for (int i =0; i < response.length(); i++) {
                                TableRow tableRow = new TableRow(getContext());
                                AttendanceResult attendanceResult = new AttendanceResult();
                                JSONObject json;
                                try {
                                    json = response.getJSONObject(i);
                                    attendanceResult.setId(i+1);
                                    attendanceResult.setAtrollno(json.getString("Rollno"));
                                    attendanceResult.setTotal(json.getString("Total"));
                                    double d = Double.parseDouble(json.getString("Percentage"));
                                    String percent = new DecimalFormat("#").format(d);
                                    attendanceResult.setPercentage(percent);
                                    Log.d("viewat",json.getString("Rollno")+" "+ json.getString("Total") + json.getString("Percentage"));
                                    TextView b = new TextView(getContext());
                                    b.setText(String.valueOf(attendanceResult.getId()));
                                    b.setTextColor(Color.BLACK);
                                    b.setPadding(10, 10, 10, 10);
                                    b.setTextSize(16);
                                    tableRow.addView(b);
                                    TextView b1 = new TextView(getContext());
                                    b1.setPadding(10, 10, 10, 10);
                                    b1.setTextSize(16);
                                    b1.setText(attendanceResult.getAtrollno());
                                    b1.setTextColor(Color.BLACK);
                                    tableRow.addView(b1);
                                    TextView b2 = new TextView(getContext());
                                    b2.setPadding(10, 10, 10, 10);;
                                    b2.setText(attendanceResult.getTotal());
                                    b2.setTextColor(Color.BLACK);
                                    b2.setTextSize(16);
                                    tableRow.addView(b2);
                                    TextView b3 = new TextView(getContext());
                                    b3.setPadding(10, 10, 10, 10);
                                    b3.setText(attendanceResult.getPercentage());
                                    b3.setTextColor(Color.BLACK);
                                    b3.setTextSize(16);
                                    tableRow.addView(b3);
                                    tableLayout.addView(tableRow);
                                    View vline1 = new View(getContext());
                                    vline1.setBackgroundColor(Color.GRAY);
                                    tableLayout.addView(vline1);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                        Log.d("ViewAttendance", "error", anError);
                    }
                });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.calendar_view, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.calendar:
                FrgamentLoader();
                break;
        }
        return true;
    }



}
