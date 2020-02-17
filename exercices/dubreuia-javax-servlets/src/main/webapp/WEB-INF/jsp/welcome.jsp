<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<div>Hello ${name}</div>
<%
if (request.getAttribute("name") != null && request.getAttribute("name").equals("titi")) {
%>
<div style="width:50px; height: 50px; background-color: red"></div>
<%
}
%>
</body>
</html>