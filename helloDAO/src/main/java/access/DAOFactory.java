package access;

import access.mock.MockArticleDAO;

public class DAOFactory {
	public static ArticleDAO getArticleDAO() {
		return new MockArticleDAO();
	}
}
