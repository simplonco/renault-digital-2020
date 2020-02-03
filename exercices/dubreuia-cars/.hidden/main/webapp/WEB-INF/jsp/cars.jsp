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
        for (String brand : brands) {
    %>
    <button data-brand="<%=brand%>"><%=brand%>
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
            fetch("http://localhost:8080/dubreuia-cars/cars?brand=" + brand, {
                headers: {
                    "Content-Type": "application/json",
                }
            }).then((response) => {
                return response.json();
            }).then((cars) => {
                console.log(cars);
                content.innerHTML = "";
                for (let car of cars) {
                    content.innerHTML = content.innerHTML + "<div>" + car + "</div>";
                }
            });
        });
    }
</script>
</html>