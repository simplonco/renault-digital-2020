<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cars</title>
    <style>
        body {
            font-family: monospace;
        }
    </style>
</head>
<body>
<h1>Cars</h1>
<div>
    <%
        Set<String> brands = (Set<String>) request.getAttribute("brands");
        for (String s : brands) {
    %>
    <button data-brand="<%=s%>"><%=s%>
    </button>
    <%
        }
    %>
</div>
<h2>List</h2>
<div id="content">
</div>
</body>
<script>
    let buttons = document.getElementsByTagName("button");
    let content = document.getElementById("content");
    for (let button of buttons) {
        button.addEventListener("click", (event) => {
            let brand = button.getAttribute("data-brand");
            fetch('?brand=' + brand, {
                headers: {
                    "Content-Type": "application/json"
                }
            }).then((response) => {
                return response.json();
            }).then((myJson) => {
                content.innerHTML = "";
                for (let car of myJson) {
                    content.innerHTML += "<div>" + car + "</div>";
                }
            });
        });
    }
</script>
</html>