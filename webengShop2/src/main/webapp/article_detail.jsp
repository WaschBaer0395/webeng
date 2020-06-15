<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="webengShop2.transferobjects.Article" %>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Article_detail</title>
</head>
<body>
<jsp:useBean id="article" class="webengShop2.transferobjects.Article" scope="request"/>
<%//Article article = (Article) request.getAttribute("myBean");%>
<div class="container w-25 mt-5">
    <ul class="list-group">
        <li class="list-group-item">ArtNr: <%= article.getId()%></li>
        <li class="list-group-item">Name: <%= article.getName()%></li>
        <li class="list-group-item">Price: <%= article.getPrice()%> €</li>
        <li class="list-group-item">Quantity: <%= article.getQuantity()%></li>
    </ul>

    <div class="container">
        <div class="row float-right mt-2">
            <form name="article_list" method="get" action="FrontControllerServlet">
                <button type="submit" name="action" value="articlelist" class="btn btn-secondary">
                    <i class="fi-list"></i> Catalog
                </button>
            </form>
            <form class="ml-3" name="to_cart" method="get" action="FrontControllerServlet">
                <input type="hidden" name="id" value="<%=article.getId()%>">
                <input type="hidden" name="quantity" value="1">
                <button type="submit" name="action" value="insert" class="btn btn-primary"><i class="fi-shopping-cart"></i> Add to Cart</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>