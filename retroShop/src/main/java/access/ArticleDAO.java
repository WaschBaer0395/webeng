package access;

import transferobjects.Article;

import java.util.List;


public interface ArticleDAO {
    
    Article get(long id);
     
    List<Article> getAll();
     
    void add(Article t);
     
    void update(Article t);
     
    void delete(Article t);
}
