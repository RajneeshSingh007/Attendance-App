package com.attendance.data.model;

/**
 * Created by coolalien on 17,March,2017
 */

public class AttendanceModel {

    private int id;
    private String atrollno;
    private boolean checked;
    private String atdiv;
    private String atstatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtrollno() {
        return atrollno;
    }

    public void setAtrollno(String atrollno) {
        this.atrollno = atrollno;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getAtdiv() {
        return atdiv;
    }

    public void setAtdiv(String atdiv) {
        this.atdiv = atdiv;
    }

    public String getAtstatus() {
        return atstatus;
    }

    public void setAtstatus(String atstatus) {
        this.atstatus = atstatus;
    }
}
