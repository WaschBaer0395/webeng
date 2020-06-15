<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" %>
<%@ page import="webengShop2.businesslogic.ArticleManager" %>
<%@ page import="webengShop2.transferobjects.Article" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Article List</title>
</head>
<body>
<div class="container">
    <h1>ArticleList</h1>
    <jsp:useBean id="articles" class="java.util.ArrayList" type="java.util.List<webengShop2.transferobjects.Article>" scope="request"/>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
            <% for(Article a : articles){%>
                <% String name = a.getName(); %>
                <% int id = a.getId(); %>
                <tr>
                    <td><%=id%></td>
                    <td>
                        <% String queryString = "action=articledetails&id=" + id + "&name=" + name;
                        String url = "/webengShop2/webengShop2?" + queryString;
                        %>
                        <a href=<%=url%> ><%=name%></a>
                    </td>
                </tr>
            <% }%>
            </tbody>
        </table>
    </div>
</body>
</html>