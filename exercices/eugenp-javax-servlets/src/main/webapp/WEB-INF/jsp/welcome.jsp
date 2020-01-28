<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <style>

    </style>
</head>
<body>
<div>Hello ${key}</div>
<%
    if ("titi".equals(request.getAttribute("key"))) {
%>
    <div style="background-color: red; width: 50px; height: 50px"></div>
<%
    }
%>
</body>
</html>