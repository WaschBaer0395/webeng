package presentation.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import configuration.Configuration;


/**
 * populates COnfiguration object from ServletContext-InitParams
 */
@WebListener
public class ConfigurationListener implements javax.servlet.ServletContextListener { 
    public void contextInitialized(ServletContextEvent sce) { 
    	Configuration.setDataSourceType(sce.getServletContext().getInitParameter("dataSourceType"));
    	Configuration.setUsername(sce.getServletContext().getInitParameter("db.user"));
    	Configuration.setPassword(sce.getServletContext().getInitParameter("db.password"));
    	Configuration.setUrl(sce.getServletContext().getInitParameter("db.url"));
    	Configuration.setDriver(sce.getServletContext().getInitParameter("org.h2.Driver"));
    	Configuration.setDriver("org.h2.Driver");
    } 	

    public void contextDestroyed(ServletContextEvent sce) { 
        
    } 

}
