package com.demo;

import java.io.IOException;

import com.demo.bean.BaseBean;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FiestServlet extends HttpServlet {
    @Inject
    @Named("request")
    private BaseBean request;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("request.in.first", request.getInfo());
        req.getRequestDispatcher("/second").forward(req, resp);
    }
}
