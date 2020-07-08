package access.orm;

import access.ArticleDAO;
import transferobjects.Article;

import java.util.List;

public class OrmArticleDAO extends OrmDaoBase implements ArticleDAO {
	

	@Override
    public Article get(long id) {
    	return getDatabase().find(Article.class, id);  
	
    }
     
    @Override
    public List<Article> getAll() {
    	return getDatabase().find(Article.class).findList();  
    }

    @Override
    public List<Article> searchArticle(String t) {
        return null;
    }

    @Override
    public void add(Article article) {
    	
    	getDatabase().insert(article); 
    }
     
    @Override
    public void update(Article article) {
    	getDatabase().save(article);     
    	
    }
     
    @Override
    public void delete(Article article) {
    	
    	getDatabase().delete(article);  
    }

    @Override
    public List<Article> getUserArticleList(long id) {
        return null;
    }
}
