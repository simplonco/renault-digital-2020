<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<div>Hello ${name}</div>
<%
    String name = (String) request.getAttribute("name");
    if ("titi".equals(name)) {
%>
    <div style="background-color: red; height: 50px; width: 50px"></div>
<%
    }
%>
</body>
</html>