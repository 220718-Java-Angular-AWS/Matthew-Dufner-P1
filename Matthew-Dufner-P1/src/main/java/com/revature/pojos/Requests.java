package com.revature.pojos;

public class Requests {
    private Integer requestId;
    private Double amtRequested;
    private String rsnforReimburse;
    private String cmtReimburse;

    public Requests() {
    }

    public Requests(Integer requestId, Double amtRequested, String rsnforReimburse, String cmtReimburse) {
        this.requestId = requestId;
        this.amtRequested = amtRequested;
        this.rsnforReimburse = rsnforReimburse;
        this.cmtReimburse = cmtReimburse;
    }

    public Requests(String requestId, Double amtRequested, String rsnforReimburse, String cmtReimburse) {
        this.requestId = null;
        this.amtRequested = amtRequested;
        this.rsnforReimburse = rsnforReimburse;
        this.cmtReimburse = cmtReimburse;
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
}
