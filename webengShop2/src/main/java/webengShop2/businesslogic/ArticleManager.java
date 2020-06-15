package webengShop2.businesslogic;

import webengShop2.acess.MysqlDAO;
import webengShop2.transferobjects.Article;

import java.util.List;

public class ArticleManager implements java.io.Serializable {

    MysqlDAO ma = new MysqlDAO();

    public List<Article> getTheArticles() {
        return ma.getAll();
    }

    public void addArticle(Article article) {
        ma.add(article);
    }

    public Article getArticle(int id){
        return ma.get(id);
    }

    public void deleteArticle(int id){
        ma.delete(id);
    }

    public void updateArticle(Article article){
        ma.update(article);
    }

}
