package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        // リクエストの指定する言語を取得
        Locale locale = req.getLocale();
        String greeting = switch(locale.getLanguage()) {
            case "fr" -> "Bonjour, ";
            case "ja" -> "こんにちは、";
            case "zh" -> "你好，";
            default -> "Hello, ";
        };
        // レスポンスのヘッダを設定
        resp.setHeader("Vary", "Accept-Language");
        resp.setLocale(locale);
        // レスポンスをHTMLに指定してPrintWriterを取得
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        // レスポンスを出力
        writer.print(
            """
            <!DOCTYPE html>
            <html>
            <head><title>Hello Servlet</title></head>
            <body>%sOpen Liberty!</body>
            </html>
            """.formatted(greeting));
    }
}
