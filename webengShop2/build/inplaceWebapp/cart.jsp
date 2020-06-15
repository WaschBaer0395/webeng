<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" %>
<%@ page import="webengShop2.transferobjects.Cart" %>
<%@ page import="webengShop2.transferobjects.Article" %>
<%@ page import="webengShop2.businesslogic.CartManager" %>
<%@ page import="java.math.*" %>


<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.min.css">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shoppingcart</title>
</head>
<body>
    <div class="container">
    <jsp:useBean id="cartBean" class="webengShop2.transferobjects.Cart" scope="session" />
    <% Cart userCart = (Cart)session.getAttribute("cartBean");%>
    <h1>Cart</h1>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">id</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <% for(Article a : userCart.getArticleList()){%>
            <% int id = a.getId(); %>
            <% String name = a.getName(); %>
            <% float price = a.getPrice(); %>
            <tr>
                <td><%=id%></td>
                <td><%=name%></td>
                <td><%=price%></td>
            </tr>
            <% }%>
            <%
                CartManager cartManager = new CartManager();
                double totalPrice = cartManager.calculatePrice(userCart);
                double roundedPrice = Math.round(totalPrice * 100.0) / 100.0;
            %>
            <tr>
                <td colspan="1"></td>
                <th>Total</th>
                <th><%=roundedPrice%> €</th>
            </tr>
            <tr>
                <td colspan="2"></td>
                <td class="w-25 p-3">
                    <form style="float: right" name="Cart_checkout" method="get" action="FrontControllerServlet">
                        <button type="submit" name="action" value="checkout" class="btn btn-primary">
                            <i class="fi-paypal"></i> Checkout
                        </button>
                    </form>
                    <form class="mr-3" style="float: right" name="article_list" method="get" action="FrontControllerServlet">
                        <button type="submit" name="action" value="articlelist" class="btn btn-secondary">
                            <i class="fi-list"></i> Catalog
                        </button>
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</body>
</html>