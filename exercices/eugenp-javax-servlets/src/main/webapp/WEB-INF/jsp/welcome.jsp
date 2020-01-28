<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<div>Hello ${nom}</div>
<%
    String name = (String)request.getAttribute("nom");
    if (name != null && name.equals("titi")) {
%>
<div style="background-color: red; width: 50px; height: 50px"></div>
<%
    }
%>
</body>
</html>