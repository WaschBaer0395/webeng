<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" %>
<%@ page import="webengShop2.businesslogic.ArticleManager" %>
<%@ page import="webengShop2.transferobjects.Article" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Article List</title>
</head>
<body>
<h1>ArticleList</h1>
<%! %>
<% ArticleManager articleManager = new ArticleManager();
    List<Article> articles = articleManager.getTheArticles();%>
<table style=" border: black solid 1px">
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>

    <% for(Article a : articles){%>
    <% String name = a.getName(); %>
    <% int id = a.getId(); %>
    <tr>
        <td><%=id%></td>
        <td><a href=""><%=name%></a></td>
    </tr>
    <% }%>
</table>
</body>
</html>