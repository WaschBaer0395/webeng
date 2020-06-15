package webengShop2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter (filterName="Auth",
            urlPatterns ={"/protected/"},
        dispatcherTypes = {DispatcherType.FORWARD})
public class Auth implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if(request.getServletContext().getInitParameter("AuthToken").equals("admin")){
            HttpServletResponse resp = (HttpServletResponse)response;
            resp.sendError(403, "Zugriff ist nicht erlaubt");
        }
        else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
