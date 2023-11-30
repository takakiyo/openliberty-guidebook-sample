package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/snoop/*")
public class SnoopServlet extends HttpServlet {
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
        // リクエスト・ラインに関する情報
        writer.println("Request Method      : " + req.getMethod());
        writer.println("Request URI         : " + req.getRequestURI());
        writer.println("Request Protocol    : " + req.getProtocol());
        writer.println("Context Path        : " + req.getContextPath());
        writer.println("Servlet Path        : " + req.getServletPath());
        writer.println("Path Info           : " + req.getPathInfo());
        writer.println("Path Translated     : " + req.getPathTranslated());
        writer.println("Query String        : " + req.getQueryString());
        // ヘッダーから得られる情報
        writer.println("Content Length      : " + req.getContentLength());
        writer.println("Content Type        : " + req.getContentType());
        writer.println("Character Encoding  : " + req.getCharacterEncoding());
        writer.println("Locale              : " + req.getLocale());
        writer.print("Locales             : ");
        Enumeration<Locale> e = req.getLocales();
        while (e.hasMoreElements()) {
            writer.print(e.nextElement() + " ");
        }
        writer.println();
        // ネットワーク接続についての情報
        writer.println("Local Name          : " + req.getLocalName());
        writer.println("Local Port          : " + req.getLocalPort());
        writer.println("Server Name         : " + req.getServerName());
        writer.println("Server Port         : " + req.getServerPort());
        writer.println("Remote Address      : " + req.getRemoteAddr());
        writer.println("Remote Host         : " + req.getRemoteHost());
        writer.println("Remote Port         : " + req.getRemotePort());
        writer.println("Request ID          : " + req.getRequestId());
        writer.println("Secure Connection   : " + req.isSecure());
        // 認証についての情報
        writer.println("Authorization Scheme: " + req.getAuthType());
        writer.println("Remote User         : " + req.getRemoteUser());
    }
}
