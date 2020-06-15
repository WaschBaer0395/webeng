<%--
  Created by IntelliJ IDEA.
  User: rene-
  Date: 6/4/2020
  Time: 12:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%-- Generates and associates a CAPTCHA --%>
<img src="<%= request.getContextPath()%gt;/servlet/AuthToken" alt="Your authentication token"/>
 <%-- The form login page --%>
<form method="POST" action='<%= response.encodeURL("j_security_check") %>' >
<table border="0" cellspacing="5">
    <input type="hidden" name="j_username" value="<%= session.getId() %>">
    <tr>
        <th align="right">Challenge:</th>
        <td align="left"><input type="password" name="j_password"></td>
    </tr>
    <tr>
        <td align="right"><input type="submit" value="Log In"></td>
        <td align="left"><input type="reset"></td>
    </tr>
</table>
</form>
</body>
</html>
