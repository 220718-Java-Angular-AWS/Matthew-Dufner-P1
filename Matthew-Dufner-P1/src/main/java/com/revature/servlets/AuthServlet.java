package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String email = req.getParameter("email");
        String userPass = req.getParameter("user-pass");

        User authUser = service.authenticate(email, userPass);

        String json = mapper.writeValueAsString(authUser);

        resp.getWriter().println(json);

        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String email = req.getParameter("email");

        User authUser = service.getUpdate(firstName, lastName, email);

        String json = mapper.writeValueAsString(authUser);

        resp.getWriter().println(json);

        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }
}
