package com.service.statement.model;

import java.util.Date;

public class BankStatement {
    private String id;
    private String bankCode;
    private String branchCode;
    private String statementNumber;
    private Date fromDate;
    private Date toDate;
    private String superiorBranchCode;
    private String accnoo;
    private String custno;
    private String posttype;
    private String orderno;
    private String notranfalg;
    private String status;
    private String fileName;
    private String fileType;
    private String creater;
    private Date createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getStatementNumber() {
        return statementNumber;
    }

    public void setStatementNumber(String statementNumber) {
        this.statementNumber = statementNumber;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getSuperiorBranchCode() {
        return superiorBranchCode;
    }

    public void setSuperiorBranchCode(String superiorBranchCode) {
        this.superiorBranchCode = superiorBranchCode;
    }

    public String getAccnoo() {
        return accnoo;
    }

    public void setAccnoo(String accnoo) {
        this.accnoo = accnoo;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getPosttype() {
        return posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getNotranfalg() {
        return notranfalg;
    }

    public void setNotranfalg(String notranfalg) {
        this.notranfalg = notranfalg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
