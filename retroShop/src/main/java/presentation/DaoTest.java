package presentation;

import access.ArticleDAO;
import access.DAOFactory;
import transferobjects.Article;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TestDAO
 */
@WebServlet("/DaoTest")
public class DaoTest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private ArticleDAO articleDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DaoTest() {
        super();
         
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
	
        
        articleDAO = DAOFactory.getArticleDAO();
        articleDAO.add(new Article(0,"TestArtikel01",10,7));
        articleDAO.add(new Article(0,"TestArtikel02",20,6));
        articleDAO.add(new Article(0,"TestArtikel03",30,5));
        articleDAO.add(new Article(0,"TestArtikel04",40,4));
        articleDAO.add(new Article(0,"TestArtikel05",50,3));
        articleDAO.add(new Article(0,"TestArtikel06",60,2));
        
       
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("-------------------------------------------------");
		response.getWriter().println("Alle Artikel:");
		response.getWriter().println("-------------------------------------------------");
		
		for (Article a : articleDAO.getAll()) {
			response.getWriter().println(a.getId());
			response.getWriter().println(a.getName());
			response.getWriter().println(a.getPrice());
			response.getWriter().println(a.getQuantity());
			response.getWriter().println();
		}
		response.getWriter().println("-------------------------------------------------");
		response.getWriter().println("Artikel mit ID 3");
		response.getWriter().println("-------------------------------------------------");
		Article a = articleDAO.get(3);
		
		response.getWriter().println(a.getId());
		response.getWriter().println(a.getName());
		response.getWriter().println(a.getPrice());
		response.getWriter().println(a.getQuantity());
		response.getWriter().println();
		
		response.getWriter().println("-------------------------------------------------");
		response.getWriter().println("Artikel mit ID 3 aktualisieren");
		response.getWriter().println("-------------------------------------------------");
		a = articleDAO.get(3);
		a.setName(a.getName()+"Update");
		a.setQuantity(a.getQuantity()-1);
		a.setPrice(999);
		
		response.getWriter().println(a.getId());
		response.getWriter().println(a.getName());
		response.getWriter().println(a.getPrice());
		response.getWriter().println(a.getQuantity());
		response.getWriter().println();
		response.getWriter().println("-------------------------------------------------");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
