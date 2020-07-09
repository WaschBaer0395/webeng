package access;

import access.sql.SqlAddressDAO;
import access.sql.SqlUserDAO;
import configuration.Configuration;
import access.mock.MockArticleDAO;
import access.mock.MockUserDAO;
import access.orm.OrmArticleDAO;
import access.sql.SqlArticleDAO;

import java.util.List;


public class DAOFactory {
	
	public enum DataSourceType
	{
		SQL,
		ORM,
		MOCK
	}

	public static UserDAO getUserDAO(){
		return getUserDAO(Configuration.getDataSourceType());
	}

	private static UserDAO getUserDAO(String typeString){
		//DataSourceType type = DataSourceType.valueOf(Configuration.getDataSourceType());
		return new SqlUserDAO();
	}

	public static AddressDAO getAddressDAO(){
		return getAddressDAO(Configuration.getDataSourceType());
	}

	public static AddressDAO getAddressDAO(String typeString){
		return new SqlAddressDAO();
	}

	// getArticleDAO with type stored in Configuration class - preferred way to get DAO
	public static ArticleDAO getArticleDAO() {
		return getArticleDAO(Configuration.getDataSourceType());

	}

	// getArticleDAO with type given by typeString
	private static ArticleDAO getArticleDAO(String typeString) {
		//DataSourceType type = DataSourceType.valueOf(Configuration.getDataSourceType());
		return new SqlArticleDAO();
	}

}
