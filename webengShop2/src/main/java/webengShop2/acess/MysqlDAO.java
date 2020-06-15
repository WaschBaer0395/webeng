package webengShop2.acess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webengShop2.transferobjects.Article;

public class MysqlDAO implements ArticleDAO {
    
    private static List<Article> articles = new ArrayList<>();

	public List<Article> refreshList() {
		articles.clear();
		try{
			MysqlConnect mysql = new MysqlConnect();
			Connection con = mysql.connect();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from article");
			while(rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt(1));
				article.setName(rs.getString(2));
				article.setPrice(rs.getFloat(3));
				article.setQuantity(rs.getInt(4));
				articles.add(article);
			}
			con.close();
			return articles;
		}catch(Exception e){ System.out.println(e);}
		return articles;
	}
    
	@Override
    public Article get(int id) {
    	Article a = null;
    	try 
    	{
			MysqlConnect mysql = new MysqlConnect();
			Connection con = mysql.connect();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from article where article.id =" + id);
			Article article = new Article();
			while(rs.next()) {
				article.setId(rs.getInt(1));
				article.setName(rs.getString(2));
				article.setPrice(rs.getFloat(3));
				article.setQuantity(rs.getInt(4));
			}
			stmt.close();
			rs.close();
			con.close();
			return article;
    	}
		catch(IndexOutOfBoundsException e) {
			System.out.println("MockArticleDAO::get: indexOutOfBounds");
		}
    	catch(Exception e){ System.out.println(e);}

    	return a;
    }
     
    @Override
    public List<Article> getAll() {
		refreshList();
        return articles;
    }
     
    @Override
    public void add(Article article) {
		try{
			MysqlConnect mysql = new MysqlConnect();
			Connection con = mysql.connect();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO article (name, price,quantity) " +
					"VALUES('" + article.getName() +"','" + article.getPrice() + "','" + article.getQuantity() +"')");
			stmt.close();
			con.close();
		}catch(Exception e){ System.out.println(e);}
    	articles.add(article);
		refreshList();
    }
     
    @Override
    public void update(Article article) {
		try{
			MysqlConnect mysql = new MysqlConnect();
			Connection con = mysql.connect();
			Statement stmt = con.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE article SET"
					+" name ='" + article.getName() + "',"
					+ "price ='" + article.getPrice() + "',"
					+ "quantity ='" + article.getQuantity()
					+ "' WHERE id ='" + article.id + "'");
			stmt.executeUpdate(sb.toString());
			stmt.close();
			con.close();
		}catch(Exception e){ System.out.println(e);}
		refreshList();
    }

    @Override
    public void delete(int id) {
		try{
			MysqlConnect mysql = new MysqlConnect();
			Connection con = mysql.connect();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM article WHERE id=" + id);
			stmt.close();
			con.close();
		}catch(Exception e){ System.out.println(e);}
		refreshList();
    }

}
