package businesslogic;


import access.ArticleDAO;
import access.DAOFactory;
import transferobjects.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleManager implements java.io.Serializable {

    ArticleDAO adao = DAOFactory.getArticleDAO();

    public List<Article> getTheArticles() {
        return adao.getAll();
    }

    public void addArticle(Article article) {
        adao.add(article);
    }

    public Article getArticle(long id){
        return adao.get(id);
    }

    public void deleteArticle(long id){
        Article a = new Article();
        a.setId(id);
        adao.delete(a);
    }

    public void updateArticle(Article article){
        adao.update(article);
    }

    public List<Article> searchArticle(String searchArticle){
        return adao.searchArticle(searchArticle);
    }

    public List<Article> getUserArticleList(long id) {
        return adao.getUserArticleList(id);
    }

}
