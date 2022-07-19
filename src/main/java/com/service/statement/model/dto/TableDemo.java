package com.service.statement.model.dto;

public class TableDemo {
    private String trDate;
    private String valDate;
    private String details;
    private String tranAmount;
    private String balance;

    public TableDemo(String trDate, String valDate, String details, String tranAmount, String balance) {
        this.trDate = trDate;
        this.valDate = valDate;
        this.details = details;
        this.tranAmount = tranAmount;
        this.balance = balance;
    }

    public String getTrDate() {
        return trDate;
    }

    public void setTrDate(String trDate) {
        this.trDate = trDate;
    }

    public String getValDate() {
        return valDate;
    }

    public void setValDate(String valDate) {
        this.valDate = valDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(String tranAmount) {
        this.tranAmount = tranAmount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
