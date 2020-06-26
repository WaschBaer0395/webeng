package access.sql;

import configuration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SqlDaoBase {
	Connection connection;
	
	public SqlDaoBase()
	{
		try {
			System.out.println(Configuration.getDriver());
			Class.forName(Configuration.getDriver());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(
					Configuration.getUrl(),
					Configuration.getUsername(),
					Configuration.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return connection;
	}
}
