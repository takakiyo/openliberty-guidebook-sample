<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>掲示板</title></head>
<body>

<!-- 新規メッセージ追加フォーム -->
<form action="./message" method="post">
    <fieldset>
        <legend>新規メッセージ追加</legend>
        名前: <input type="text" name="name" value="${name}" required><br>
        メッセージ: <textarea name="content" required></textarea><br>
        <input type="submit" value="送信">
    </fieldset>
</form>

<!-- メッセージ一覧表示 -->
<h2>メッセージ一覧</h2>
<table border="1">
    <thead>
        <tr>
            <th>名前</th>
            <th>メッセージ</th>
            <th>時間</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="message" items="${messageList}">
        <tr>
            <td>${message.name}</td>
            <td>${message.content}</td>
            <td>${message.timestamp}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
