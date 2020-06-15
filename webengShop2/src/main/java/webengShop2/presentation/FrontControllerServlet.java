package webengShop2.presentation;

import webengShop2.businesslogic.ArticleManager;
import webengShop2.businesslogic.CartManager;
import webengShop2.transferobjects.Article;
import webengShop2.transferobjects.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FrontControllerServlet", urlPatterns = {""})
public class FrontControllerServlet extends HttpServlet {


    public FrontControllerServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);
        Cart userCart = (Cart)session.getAttribute("cartBean");
        if(userCart == null){
            userCart = new Cart();
            userCart.initialize();
            session.setAttribute("cartBean", userCart);
        }

        if(action == null) action = "default";

        switch(action.toUpperCase()){
            case "DEFAULT":
                dispatcher = request.getRequestDispatcher("default.jsp");
                dispatcher.forward(request, response);
                break;
            case "ADMIN":
                if(getServletContext().getInitParameter("AuthToken").equals("admin")){
                    dispatcher = request.getRequestDispatcher("/protected/admin.jsp");
                    dispatcher.forward(request, response);
                }
                break;
            case "ARTICLELIST":
                ArticleManager articleManager_articlelist = new ArticleManager();
                List<Article> articles_list = articleManager_articlelist.getTheArticles();
                request.setAttribute("articles", articles_list);
                dispatcher = request.getRequestDispatcher("article_list.jsp");
                dispatcher.forward(request, response);
                break;
            case "ARTICLEDETAILS":
                ArticleManager articleManager = new ArticleManager();
                List<Article> articles = articleManager.getTheArticles();
                Article article = new Article();
                int id = Integer.parseInt(request.getParameter("id"));
                for(Article a : articles){
                    if(a.getId() == id){
                        article = a;
                    }
                }
                request.setAttribute("article", article);
                dispatcher = request.getRequestDispatcher("article_detail.jsp");
                dispatcher.forward(request, response);
                break;

            case "INSERT":
                ArticleManager articleManager_insert = new ArticleManager();
                int id_insert = Integer.parseInt(request.getParameter("id"));
                Article article_insert = articleManager_insert.getArticle(id_insert);
                CartManager cartManager = new CartManager();
                cartManager.addNewArticle(article_insert, userCart);
                response.sendRedirect(request.getContextPath()+"/cart.jsp");
                break;

            case "EDIT":
                Article article_edit = new Article();
                article_edit.setId(Integer.parseInt(request.getParameter("article_id")));
                article_edit.setName(request.getParameter("article_name"));
                article_edit.setPrice(Float.parseFloat(request.getParameter("article_price")));
                article_edit.setQuantity(Integer.parseInt(request.getParameter("article_quantity")));
                ArticleManager articleManager_edit = new ArticleManager();
                articleManager_edit.updateArticle(article_edit);
                response.sendRedirect(request.getContextPath()+"/FrontController?action=admin");
                break;

            case "DELETE":
                int article_id_delete = Integer.parseInt(request.getParameter("article_id"));
                ArticleManager articleManager_delete = new ArticleManager();
                articleManager_delete.deleteArticle(article_id_delete);
                response.sendRedirect(request.getContextPath()+"/FrontController?action=admin");
                break;

            case "ADD":
                Article article_add = new Article();
                article_add.setName(request.getParameter("article_name"));
                article_add.setPrice(Float.parseFloat(request.getParameter("article_price")));
                article_add.setQuantity(Integer.parseInt(request.getParameter("article_quantity")));
                ArticleManager articleManager_add = new ArticleManager();
                articleManager_add.addArticle(article_add);
                response.sendRedirect(request.getContextPath()+"/FrontController?action=admin");
                break;

            case "CHECKOUT":
                userCart.clearList();
                dispatcher = request.getRequestDispatcher("checkout.jsp");
                dispatcher.forward(request, response);
                break;
        }
    }
}
