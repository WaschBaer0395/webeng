package access.mock;

import access.ArticleDAO;
import transferobjects.Article;

import java.util.ArrayList;
import java.util.List;

public class MockArticleDAO implements ArticleDAO {
    
    private List<Article> articles = new ArrayList<>();
     
     
    
	@Override
    public Article get(long id) {
    	Article a = null;
    	try 
    	{
    		  a = articles.get((int) id);
    		  return new Article(a.getId(), a.getName(), a.getPrice(), a.getQuantity());
    	}
		catch(IndexOutOfBoundsException e) {
			System.out.println("MockArticleDAO::get: indexOutOfBounds");
		}

    	return a;
    }
     
    @Override
    public List<Article> getAll() {
    	List<Article> copy = new ArrayList<>();
    	for (Article a : articles)
    	{
    		copy.add(new Article(a.getId(), a.getName(), a.getPrice(), a.getQuantity()));
    	}
        return copy;
    }
     
    @Override
    public void add(Article a) {
    	Article data = new Article(a.getId(), a.getName(), a.getPrice(), a.getQuantity());
    	articles.add(data);
    	data.setId(articles.size()-1);
    }
     
    @Override
    public void update(Article article) {
    	Article a = get(article.getId());
    	a.setName(article.getName());
    	a.setPrice(article.getPrice());
    	a.setQuantity(article.getQuantity());
    }
     
    @Override
    public void delete(Article article) {
    	Article a = get(article.getId());
    	articles.remove(a);
    }
}
