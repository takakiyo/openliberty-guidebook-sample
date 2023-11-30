package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/headers")
public class HederServlet  extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
        throws IOException, ServletException 
    {
        execute(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException 
    {
        execute(req, resp);
    }
    private void execute(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException 
    {
        resp.setContentType("text/plain; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = req.getHeader(name);
            writer.println(name + ": " + value);
        }
        // HTTP仕様は，同じ名前の複数のHeaderの存在を許しているので，
        // 正確には，以下のようにしないと全てのヘッダーが列挙できない可能性があります。
        /*
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            Enumeration<String> values = req.getHeaders(name);
            while (values.hasMoreElements()) {
                writer.println(name + ": " + values.nextElement());
            }
        }
        */
    }
}
