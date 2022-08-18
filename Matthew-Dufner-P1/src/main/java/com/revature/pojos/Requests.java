package com.revature.pojos;

public class Requests extends User{
    private Integer requestID;
    private String title;
    private String requestDate;
    private Double amtRequested;
    private String rsnforReimburse;
    private String cmtReimburse;
    private String status;

    public Requests() {
    }

    public Requests(Integer requestID, String title, String requestDate, Integer requestId, Double amtRequested, String rsnforReimburse, String cmtReimburse, String status) {
        this.requestID = requestId;
        this.title = title;
        this.requestDate = requestDate;
        this.amtRequested = amtRequested;
        this.rsnforReimburse = rsnforReimburse;
        this.cmtReimburse = cmtReimburse;
        this.status = status;
    }

    public Requests(String requestID, String title, String requestDate, String requestId, Double amtRequested, String rsnforReimburse, String cmtReimburse, String status) {
        this.requestID = null;
        this.title = title;
        this.requestDate = requestDate;
        this.amtRequested = amtRequested;
        this.rsnforReimburse = rsnforReimburse;
        this.cmtReimburse = cmtReimburse;
        this.status = status;
    }

    public Requests(String title, Double amtRequested, String rsnforReimburse){
        this.title = title;
        this.amtRequested = amtRequested;
        this.rsnforReimburse = rsnforReimburse;
    }

    public Requests(String title, Double amtRequested, String rsnforReimburse, String cmtReimburse){
        this.title = title;
        this.amtRequested = amtRequested;
        this.rsnforReimburse = rsnforReimburse;
        this.cmtReimburse = cmtReimburse;
    }

    public Integer getRequestID(Requests read){
        return requestID;
    }

    public void setRequestID(Integer requestID){
        this.requestID = requestID;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
    public Double getAmtRequested() {
        return amtRequested;
    }

    public void setAmtRequested(Double amtRequested) {
        this.amtRequested = amtRequested;
    }

    public String getRsnforReimburse() {
        return rsnforReimburse;
    }

    public void setRsnforReimburse(String rsnforReimburse) {
        this.rsnforReimburse = rsnforReimburse;
    }

    public String getCmtReimburse() {
        return cmtReimburse;
    }

    public void setCmtReimburse(String cmtReimburse) {
        this.cmtReimburse = cmtReimburse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
