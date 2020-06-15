<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="webengShop2.acess.*" %>
<%@ page import="webengShop2.transferobjects.*" %>
<%@ page import="webengShop2.businesslogic.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AdminPage</title>
</head>
<body>
<h1>Adminbereich</h1>
    <%! %>
<% ArticleManager articleManager = new ArticleManager();
    List<Article> articles = articleManager.getTheArticles();%>
<table style=" border: black solid 1px">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th></th>
        <th></th>
    </tr>

    <% for(Article a : articles){%>
    <% String name = a.getName(); %>
    <% int id = a.getId(); %>
    <% int quantity = a.getQuantity();%>
    <% float price = a.getPrice();%>
    <tr>
        <td><%=id%></td>
        <td colspan="4">
            <form name="form_<%=name%>" method="get" action="FrontControllerServlet">
                <input type="hidden" id="<%=id%>" name="article_id" value="<%=id%>">
                <input type="text" id="<%=name%>" name="article_name" value="<%=name%>">
                <input type="number" step=".01" id="<%=price%>" name="article_price" value="<%=price%>">
                <input type="number" id="<%=quantity%>" name="article_quantity" value="<%=quantity%>">
                <button name="action" value="edit" type="submit">Edit</button>
                <button name="action" value="delete" type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <% }%>
    <tr>
        <td></td>
        <td colspan="4">
            <form name="form_add" method="get" action="FrontControllerServlet">
                <input type="text" id="new_article_name" name="article_name" value="">
                <input type="number" step=".01" id="new_article_price" name="article_price" value="">
                <input type="number" id="new_article_quantity" name="article_quantity" value="">
                <button name="action" value="add" type="submit">Add</button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>