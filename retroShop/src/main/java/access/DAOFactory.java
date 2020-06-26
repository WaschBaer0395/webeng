package access;

import configuration.Configuration;
import access.mock.MockArticleDAO;
import access.orm.OrmArticleDAO;
import access.sql.SqlArticleDAO;


public class DAOFactory {
	
	public enum DataSourceType
	{
		SQL,
		ORM,
		MOCK
	}
	
	
	// getArticleDAO with type stored in Configuration class - preferred way to get DAO
	public static ArticleDAO getArticleDAO() {
		System.out.println(Configuration.getDataSourceType());
		return getArticleDAO(Configuration.getDataSourceType());
		
	}
	
	// getArticleDAO with type given by typeString
	public static ArticleDAO getArticleDAO(String typeString) {
		DataSourceType type = DataSourceType.valueOf(Configuration.getDataSourceType());
		switch(type)
		{
		case MOCK:
			return new MockArticleDAO();

		case ORM:
			return new OrmArticleDAO();

		case SQL:
			System.out.println("SQL was selected!");
			return new SqlArticleDAO();
		
		default:
			return null;
			
		}
		
	}

}
