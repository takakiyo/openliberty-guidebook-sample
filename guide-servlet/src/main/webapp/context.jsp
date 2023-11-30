<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
    import="java.util.Enumeration" %>
<html>
<head><title>ServletContext Attributes</title></head>
<body>
<h1>ServletContext Attributes</h1>
<%  Enumeration<String> names = application.getAttributeNames(); %>
<dl>
<%  while (names.hasMoreElements()) {
        String name = names.nextElement(); %>
            <dt><%= name %></dt>
            <dd><%= application.getAttribute(name) %></dd>
        </tr>
<%  }   %>
</dl>
</body>
</html>
