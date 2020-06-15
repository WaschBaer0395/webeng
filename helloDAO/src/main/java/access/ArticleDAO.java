package access;

import java.util.List;

import transferobjects.Article;


public interface ArticleDAO {
    
    Article get(int id);
     
    List<Article> getAll();
     
    void add(Article t);
     
    void update(Article t);
     
    void delete(Article t);
}
