package webengShop2.acess;

import java.util.List;

import webengShop2.transferobjects.Article;


public interface ArticleDAO {
    
    Article get(int id);
     
    List<Article> getAll();
     
    void add(Article t);
     
    void update(Article t);

    void delete(int id);
}
