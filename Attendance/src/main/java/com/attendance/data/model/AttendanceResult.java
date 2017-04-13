package com.attendance.data.model;

/**
 * Created by coolalien on 23,March,2017
 */

public class AttendanceResult {

    private String atrollno;
    private String total;
    private int id;
    private String percentage;

    public String getAtrollno() {
        return atrollno;
    }

    public void setAtrollno(String atrollno) {
        this.atrollno = atrollno;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}