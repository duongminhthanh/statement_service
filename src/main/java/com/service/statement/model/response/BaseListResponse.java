package com.service.statement.model.response;

public class BaseListResponse extends BaseResponse{

    private long totalRecord;

    private int limit;

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public BaseListResponse() {
    }

    public BaseListResponse(long totalRecord, int limit) {
        super();
        this.totalRecord = totalRecord;
        this.limit = limit;
    }

    public BaseListResponse(Object data,long totalRecord, int limit) {
        super(data);
        this.totalRecord = totalRecord;
        this.limit = limit;
    }

    public BaseListResponse(Object data, String errorCode, String errorDesc, long totalRecord, int limit) {
        super(data, errorCode, errorDesc);
        this.totalRecord = totalRecord;
        this.limit = limit;
    }

    public BaseListResponse(Object data) {
        super(data);
    }
}
