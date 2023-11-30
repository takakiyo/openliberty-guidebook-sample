package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.bean.BaseBean;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecoundServlet extends HttpServlet {
    @Inject
    @Named("request")
    private BaseBean request;

    @Inject
    @Named("session")
    private BaseBean session;

    @Inject
    @Named("application")
    private BaseBean application;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print(
            """
            <!DOCTYPE html>
            <html>
            <head><title>SecoundServlet</title></head>
            <body>
            <h1>Injection Test</h1>
            <ol>
            """);
        writer.println("<dt>request in FirstServlet<dd>" + req.getAttribute("request.in.first"));
        writer.println("<dt>request in SecondServlet<dd>" + request.getInfo());
        writer.println("<dt>session in SecondServlet<dd>" + session.getInfo());
        writer.println("<dt>application in SecondServlet<dd>" + application.getInfo());
        writer.print(
            """
            </ol>
            </body>
            </html>
            """);
    }
}
