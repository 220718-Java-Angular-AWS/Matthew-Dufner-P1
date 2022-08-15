package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class AuthServlet  extends HttpServlet {
    ObjectMapper mapper;
    UserServices service;

    @Override
    public void init() throws ServletException{
        this.mapper = new ObjectMapper();
        this.service = new UserServices();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while(buffer.ready()){
            builder.append(buffer.readLine());
        }
        String json = builder.toString();

        User authUser = mapper.readValue(json, User.class);
        service.authenticate(authUser.getEmail(), authUser.getUserPass());
        if(authUser!= null){
            resp.setStatus(200);
            resp.getWriter().write(mapper.writeValueAsString(authUser));
            resp.addHeader("JWT", String.valueOf(authUser.getUserID()));
        }else{
            resp.setStatus(403);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    }
}
