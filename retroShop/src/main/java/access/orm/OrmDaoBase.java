package access.orm;


import configuration.Configuration;
import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;


public abstract class OrmDaoBase {

	private Database database;
	/**
	 * @return the database
	 */
	public Database getDatabase() {
		return database;
	}
	public OrmDaoBase()
	{
		
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		
	    dataSourceConfig.setUsername(Configuration.getUsername());
	    dataSourceConfig.setPassword(Configuration.getPassword());
	    dataSourceConfig.setUrl(Configuration.getUrl());
	    dataSourceConfig.setDriver(Configuration.getDriver());
	    
	    // configuration ...
	    DatabaseConfig config = new DatabaseConfig();
	    
	    config.setDataSourceConfig(dataSourceConfig);
	    

	    // create database instance
	    
	    database = DatabaseFactory.create(config);
	    
	}
	

}
