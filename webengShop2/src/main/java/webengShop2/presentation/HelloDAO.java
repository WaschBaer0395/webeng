package webengShop2.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webengShop2.acess.MysqlDAO;
import webengShop2.businesslogic.ArticleManager;
import webengShop2.businesslogic.CartManager;
import webengShop2.transferobjects.Article;
import webengShop2.transferobjects.Cart;

/**
 * Servlet implementation class TestDAO
 */
@WebServlet("/HelloDAO")
public class HelloDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArticleManager am = new ArticleManager();
	CartManager cm = new CartManager();
	Cart cart = new Cart();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloDAO() {
        super();
		// TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MysqlDAO mockArticleDAO = new MysqlDAO();
		mockArticleDAO.refreshList();
		List<Article> articleList = mockArticleDAO.getAll();


		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\"/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>WebengShop</h2>");
		out.println("</br>");

		out.println("<table>");
		out.println("<caption>Initial Cart</caption>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Price</th>");
		out.println("<th>Quantity</th>");
		out.println("<th>ID</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (Article a: articleList) {
			out.println("<tr>");
			out.println("<td>" + a.getName() + "</td>");
			out.println("<td>" + a.getPrice() + "</td>");
			out.println("<td>" + a.getQuantity() + "</td>");
			out.println("<td>" + a.getId() + "</td>");
		}
		out.println("</tr>");
		out.println("</tbody>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
