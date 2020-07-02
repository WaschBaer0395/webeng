package access;

import transferobjects.Article;

import java.util.List;


public interface ArticleDAO {
    
    Article get(long id);
     
    List<Article> getAll();

    List<Article> searchArticle(String t);
     
    void add(Article t);
     
    void update(Article t);
     
    void delete(Article t);
}
