<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="transferobjects.*" %>
<%@ page import="access.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AdminPage</title>
</head>
<body>
<h1>Adminbereich</h1>
    <%! %>
    <% articleDAO articleManager = (ArticleManager)request.getAttribute("myBean");
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
            <form name="form_<%=name%>" method="post">
                <input type="text" id="<%=id%>" name="article_name" value="<%=name%>">
                <input type="number" id="<%=price%>" name="article_price" value="<%=price%>">
                <input type="number" id="<%=quantity%>" name="article_quantity" value="<%=quantity%>">
                <button name="edit_<%=name%>" type="submit">Edit</button>
                <button name="delete_<%=name%>" type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <% }%>
    <tr>
        <td></td>
        <td colspan="4">
            <form name="form_add" method="post">
                <input type="text" id="new_article_name" name="article_name" value="">
                <input type="number" id="new_article_price" name="article_price" value="">
                <input type="number" id="new_article_quantity" name="article_quantity" value="">
                <button name="add_article" type="submit">Add</button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>