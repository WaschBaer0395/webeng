package servlets;

import listener.UserCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(urlPatterns ={ "/protected/stats" })
public class Stats extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stats() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html><html><head></head><body>");
        out.println("<div> Logged in as: " + session.getAttribute("username")+ "<div>");
        out.println("<div> Anzahl der angemeldeten Sessions: " + UserCounter.getActiveSessions()+ "<div>");
        out.println("<a href=\"" + request.getHeader("referer") + "\">back</a>");
        out.println("</body>");
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
