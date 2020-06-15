package webengShop2.acess;

import javax.servlet.ServletContext;

public class DAOFactory {
	public static ServletContext ctx = null;

	public static void setServletContext(ServletContext newCtx){
		ctx = newCtx;
	}

	public static ArticleDAO getArticleDAO() {
		return new MysqlDAO();
	}
}
