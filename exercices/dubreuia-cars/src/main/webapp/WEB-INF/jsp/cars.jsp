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
    <!-- TODO step 1 -->
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
            // TODO step 2
        });
    }
</script>
</html>