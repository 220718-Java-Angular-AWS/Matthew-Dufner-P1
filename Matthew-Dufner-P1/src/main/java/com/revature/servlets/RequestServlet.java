package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Requests;
import com.revature.services.RequestsServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class RequestServlet extends HttpServlet {
    private RequestsServices service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.service = new RequestsServices();
        this.mapper = new ObjectMapper();
    }

    @Override
    public void destroy(){
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            Integer requestId = Integer.parseInt(req.getParameter("request-id"));

            List<Requests> requestsList = service.getAllRequests();

            String json = mapper.writeValueAsString(requestsList);

            resp.getWriter().println(json);
            resp.setContentType("Application/Json; Charset=UTF-8");
            resp.setStatus(200);
            resp.getWriter().println("Request found.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();

        while(buffer.ready()){
            builder.append(buffer.readLine());
        }

        String json = builder.toString();
        Requests requests = mapper.readValue(json, Requests.class);

        service.saveRequests(requests);
        resp.getWriter().println("Request created.");
        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        String param = req.getParameter("request-id");
        if(param == null){
            resp.getWriter().println("Request ID not found.");
        }else {
            Integer requestId = Integer.parseInt(req.getParameter("request-id"));
            Requests requests = service.getRequests(requestId);

            while (buffer.ready()) {
                builder.append(buffer.readLine());
            }
            String json = builder.toString();

            requests = mapper.readValue(json, Requests.class);
            service.saveRequests(requests);
            resp.getWriter().println("Request updated.");
        }
        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String param = req.getParameter("request-id");
        if(param == null){
            resp.getWriter().println("Request ID not found.");
        }else{
            Integer requestId = Integer.parseInt(req.getParameter("request-id"));
            service.deleteRequests(requestId);
            resp.getWriter().println("I'm dead and gone, dead and gone...");
        }
        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }
}
