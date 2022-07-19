package com.service.statement.model.request;

import java.util.List;

public class UnitRequest {
    private String code;
    private String name;
    private int status;
    private int limit;
    private int page;
    private String fileType;
    private List f;


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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List getF() {
        return f;
    }

    public void setF(List f) {
        this.f = f;
    }
}
