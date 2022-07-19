package com.service.statement.model;

public class Department extends AuditModel{

    private String id;
    private String code;
    private String name;
    private String nameEn;
    private String unit;
    private String creater;
    private String createdDate;
    private boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String getCreater() {
        return creater;
    }

    @Override
    public void setCreater(String creater) {
        this.creater = creater;
    }

    @Override
    public String getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
