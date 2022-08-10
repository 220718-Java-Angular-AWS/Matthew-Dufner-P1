package com.revature.services;

import com.revature.daos.RequestOptions;
import com.revature.pojos.Requests;

import java.util.List;

public class RequestsServices {

    private RequestOptions ROpts;

    public RequestsServices(){
        this.ROpts = new RequestOptions();
    }

    public void saveRequests(Requests requests){
        ROpts.create(requests);
    }

    public Requests searchRequests(int id){
        return ROpts.read(id);
    }

    public List<Requests> getAllRequests(){
        return ROpts.readAll();
    }

    public void deleteRequests(int id){
        ROpts.delete(id);
    }
}
