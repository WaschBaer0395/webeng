<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>First JSP</title>
</head>

<body>

Today's date: <%= (new java.util.Date()).toLocaleString()%>
<p>
3x5 equals = <%= (3*5)%>

</body>
</html>