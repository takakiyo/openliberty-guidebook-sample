package com.demo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    // 掲示板のメッセージ
    public static class Message {
        // インスタンス変数
        private String name; // 投稿者の名前
        private String content; // メッセージ内容
        private LocalDateTime timestamp; // 投稿日時
        // インスタンス変数はコンストラクターでだけ設定可能
        public Message(String name, String content) {
            this.name = name;
            this.content = content;
            this.timestamp = LocalDateTime.now();
        }
        // アクセスメソッドはgetterだけでsetterは定義しない
        public String getName() {
            return name;
        }
        public String getContent() {
            return content;
        }
        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }
    // メッセージの一覧をインスタンス変数で保持（全てのリクエストで共有される）
    private List<Message> messages = new ArrayList<>();

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
        // パラメーターを取得
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String content = req.getParameter("content");
        // パラメーターが存在していれば，メッセージを追加
        if (name != null && content != null) {
            messages.add(new Message(name, content));
            // ユーザー名は再入力しなくていいようにHttpSessionに保存しておく
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
        }
        // リクエスト・スコープの属性にmessageListをセット
        req.setAttribute("messageList", messages);
        // 表示をJSPファイルにforwardして委譲
        RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/messages.jsp");
        disp.forward(req, resp);
    }
}
