package access.sql;

import access.ArticleDAO;
import transferobjects.Article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SqlArticleDAO extends SqlDaoBase implements ArticleDAO {
  
	private static final String findAllQuery = "SELECT ID,NAME,PRICE,DESCRIPTION,RELEASEDATE,MINPRICE,IMAGEPATH,SELLERID FROM Articles WHERE true";
	private static final String findQuery = "SELECT * FROM Articles WHERE ID=?";
	private static final String updateQuery = "UPDATE Articles SET NAME=?, PRICE=?, DESCRIPTION=?, MINPRICE=?, IMAGEPATH=? WHERE ID=?";
	private static final String insertQuery = "INSERT INTO Articles (NAME,PRICE,DESCRIPTION,RELEASEDATE,MINPRICE,IMAGEPATH,SELLERID) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String deleteQuery = "DELETE FROM Articles WHERE ID=?";
	
	
	@Override
    public Article get(long id) {
		Article a = null;
		try
		{			
			PreparedStatement statement = getConnection().prepareStatement(findQuery);
			statement.setLong(1, id );
		
			ResultSet results = statement.executeQuery();
			if (results.next()) { 
				a = new Article();
				a.setId(results.getInt(1));
				a.setName(results.getString(2));
				a.setPrice(results.getFloat(3));
				a.setDesc(results.getString(4));
				a.setReleaseDate((LocalDate)results.getObject(5));
				a.setMinPrice(results.getFloat(6));
				a.setImagePath(results.getString(7));
				a.setSellerId(results.getInt(8));
			} 
	
			statement.close();	
			results.close();			
	    } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return a;
    }
     
    @Override
    public List<Article> getAll() {

    	List<Article> articles = null;
		try
		{			
			PreparedStatement statement = getConnection().prepareStatement(findAllQuery);
			
			articles = new ArrayList<Article>();
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Article a = new Article();
				a = new Article();
				a.setId(results.getInt(1));
				a.setName(results.getString(2));
				a.setPrice(results.getFloat(3));
				a.setDesc(results.getString(4));
				a.setReleaseDate((LocalDate)results.getObject(5));
				a.setMinPrice(results.getFloat(6));
				a.setImagePath(results.getString(7));
				a.setSellerId(results.getInt(8));
				articles.add(a);
			} 
			statement.close();
	
			results.close();
			
			return articles;
	    } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;

    }
     
    @Override
    public void add(Article a) {
    	try
	    {
	      PreparedStatement statement = getConnection().prepareStatement(insertQuery);
	      statement.setString(1, a.getName());
	      statement.setFloat(2, a.getPrice());
	      statement.setString(3, a.getDesc());
	      statement.setObject(4, a.getReleaseDate());
	      statement.setFloat(5, a.getMinPrice());
	      statement.setString(6, a.getImagePath());
	      statement.setInt(7, a.getSellerId());
	      statement.execute();
	      statement.close();
	  	
			
	    } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	
    }
     
    @Override
    public void update(Article a) {
    	try
	    {
	      PreparedStatement statement = getConnection().prepareStatement(updateQuery);
	      statement.setString(1, a.getName());
	      statement.setFloat(2, a.getPrice());
	      statement.setString(3, a.getDesc());
	      statement.setFloat(4, a.getMinPrice());
	      statement.setString(4, a.getImagePath());
	     
	      statement.executeUpdate();
	      statement.close();
	  	
			
	    } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
     
    @Override
    public void delete(Article a) {
    	try
	    {
	      
	      PreparedStatement statement = getConnection().prepareStatement(deleteQuery);

	      statement.setLong(1, a.getId());
	     
	      statement.execute();
	      statement.close();	  	
			
	    } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }



	
}
