package access;

import java.util.List;

import transferobjects.Article;


public interface ArticleDAO {
    
    Article get(long id);
     
    List<Article> getAll();
     
    void add(Article t);
     
    void update(Article t);
     
    void delete(Article t);
}
