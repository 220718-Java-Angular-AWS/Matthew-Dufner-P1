package com.revature.pojos;

public class Requests extends User{


    private Integer requestID;
    private Double amtRequested;
    private String rsnforReimburse;
    private String cmtReimburse;
    private Boolean approveDeny;

    public Requests() {
    }

    public Requests(Integer userID, Integer requestId, Double amtRequested, String rsnforReimburse, String cmtReimburse, Boolean approveDeny) {
        this.requestID = requestId;
        this.amtRequested = amtRequested;
        this.rsnforReimburse = rsnforReimburse;
        this.cmtReimburse = cmtReimburse;
        this.approveDeny = approveDeny;
    }

    public Requests(String userID, String requestId, Double amtRequested, String rsnforReimburse, String cmtReimburse, Boolean approveDeny) {
        this.requestID = null;
        this.amtRequested = amtRequested;
        this.rsnforReimburse = rsnforReimburse;
        this.cmtReimburse = cmtReimburse;
        this.approveDeny = approveDeny;
    }

    public Integer getRequestID(){
        return requestID;
    }

    public void setRequestID(Integer requestID){
        this.requestID = requestID;
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

    public Boolean getApproveDeny() {
        return approveDeny;
    }

    public void setApproveDeny(Boolean approveDeny) {
        this.approveDeny = approveDeny;
    }
}
