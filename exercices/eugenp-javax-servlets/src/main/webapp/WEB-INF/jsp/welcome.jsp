<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<div>Hello ${name.toString().toUpperCase()}</div>
<%
    String name = (String) request.getAttribute("name");
    if ("titi".equals(name)) {
%>
        <div style="background-color:gold;width:50px; height: 50px"></div>
<%
    } else {
%>
        <div style="background-color:black; color: white; width:50px; height: 50px"> Grosminet</div>
<%
    }
%>
</body>
</html>