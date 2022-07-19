package com.service.statement.model.dto;

public class ChartDemo {
    private long id;
    private String date;
    private double val;

    public ChartDemo(long id, String date, double val) {
        this.id = id;
        this.date = date;
        this.val = val;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}
