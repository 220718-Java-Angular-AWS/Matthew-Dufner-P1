package com.revature.daos;

import com.revature.pojos.Requests;
import com.revature.pojos.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RequestOptions implements DataSourceCRUD<Requests> {
    Connection connection;

    public RequestOptions(Connection connection){
        this.connection = connection;
    }

    public RequestOptions(){
        //TODO: Finish this after Connection Manager
    }

    @Override
    public void create(Requests request){
        try{
            String sql = "INSERT INTO requests (amount_requested, reason_for_reimbursement, reimbursement_comments, approve_deny)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, request.getAmtRequested());
            pstmt.setString(2, request.getRsnforReimburse());
            pstmt.setString(3, request.getCmtReimburse());
            pstmt.setBoolean(4, request.getApproveDeny());

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Requests read(int id) {
        Requests requests = new Requests();
        User user = new User();

        try{
            String sql = "SELECT * FROM requests WHERE request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();



            if(results.next()){
                user.setUserID(results.getInt("user_id"));
                requests.setRequestID(results.getInt("request_id"));
                requests.setAmtRequested(results.getDouble("amount_requested"));
                requests.setRsnforReimburse(results.getString("reason_for_reimbursement"));
                requests.setCmtReimburse(results.getString("reimbursement_comments"));
                requests.setApproveDeny(results.getBoolean("approve_deny"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public List<Requests> readAll() {
        List<Requests> requestList = new LinkedList<>();
        Requests requests = new Requests();
        User user = new User();

        try{
            String sql = "SELECT * FROM requests";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();

            while(results.next()){

                user.setUserID(results.getInt("user_id"));
                requests.setRequestID(results.getInt("request_id"));
                requests.setAmtRequested(results.getDouble("amount_requested"));
                requests.setRsnforReimburse(results.getString("reason_for_reimbursement"));
                requests.setCmtReimburse(results.getString("reimbursement_comments"));
                requests.setApproveDeny(results.getBoolean("approve_deny"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return requestList;
    }

    @Override
    public void update(Requests requests) {

        try{
            String sql = "UPDATE requests SET amount_requested = ?, reason_for_reimbursement = ?, reimbursement_comments = ?, approve_deny = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, requests.getAmtRequested());
            pstmt.setString(2, requests.getRsnforReimburse());
            pstmt.setString(3, requests.getCmtReimburse());
            pstmt.setBoolean(4, requests.getApproveDeny());

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try{
            String sql = "DELETE FROM requests WHERE request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
