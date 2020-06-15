<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="webengShop2.acess.*" %>
<%@ page import="webengShop2.transferobjects.*" %>
<%@ page import="webengShop2.businesslogic.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AdminPage</title>
</head>
<style>
    ::placeholder{
        color: rgba(34,125,225,0.5)!important;
    }
</style>
<body>
<div class="container">
    <h1>Adminbereich</h1>
    <%! %>
    <% ArticleManager articleManager = new ArticleManager();
        List<Article> articles = articleManager.getTheArticles();%>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price in €</th>
            <th>Quantity</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <% for (Article a : articles) {%>
            <% String name = a.getName(); %>
            <% int id = a.getId(); %>
            <% int quantity = a.getQuantity();%>
            <% float price = a.getPrice();%>
        <tr>
            <td><%=id%>
            </td>
            <form name="form_<%=name%>" method="get" action="FrontControllerServlet">
                <div class="form-group">
                    <input type="hidden" id="<%=id%>" name="article_id" value="<%=id%>">
                    <td><input class="form-control" type="text" id="<%=name%>" name="article_name" value="<%=name%>" placeholder="<%=name%>" required></td>
                    <td><input class="form-control" type="number" step=".01" id="<%=price%>" name="article_price" value="<%=price%>" placeholder="<%=price%>" required></td>
                    <td><input class="form-control" type="number" id="<%=quantity%>" name="article_quantity" value="<%=quantity%>" placeholder="<%=quantity%>" required></td>
                    <input class="form-control" type="hidden" name="AuthToken" value="<%=((HttpServletRequest)request).getParameter("AuthToken")%>">
                    <td><button class="btn btn-primary mb-2" name="action" value="edit" type="submit"><i class="fas fa-save" style="color: white"></i></button></td>
                    <td><button class="btn btn-danger mb-2" name="action" value="delete" type="submit"><i class="fas fa-trash" style="color: white"></i></button></td>
                </div>
            </form>
        </tr>
            <% }%>
        <tr>
            <td></td>
            <form name="form_add" method="get" action="FrontControllerServlet">
                <div class="form-group">
                    <td><input class="form-control" type="text" id="new_article_name" name="article_name" value="" required></td>
                    <td><input class="form-control" type="number" step=".01" id="new_article_price" name="article_price" value="" required></td>
                    <td><input class="form-control" type="number" id="new_article_quantity" name="article_quantity" value="" required></td>
                    <input class="form-control" type="hidden" name="AuthToken" value="<%=((HttpServletRequest)request).getParameter("AuthToken")%>">
                    <td><button class="btn btn-dark mb-2" name="action" value="add" type="submit"><i class="fas fa-plus" style="color: white"></i></button></td>
                </div>
            </form>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>