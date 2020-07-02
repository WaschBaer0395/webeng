package presentation;

import access.DAOFactory;
import businesslogic.ArticleManager;
import transferobjects.Article;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class ArticleBean {

    ArticleManager articleManager = new ArticleManager();;
    private Article article = new Article();
    private List<Article> articleList;


    @PostConstruct
    public void init(){
            articleList = articleManager.getTheArticles();
    }

    public void setArticle(Article a){
        this.article = a;
    }

    public Article getArticle() {
        return this.article;
    }

    public void setArticleList(List<Article> articleList){
        this.articleList = articleList;
    }

    public List<Article> getArticleList() {
        return this.articleList;
    }

    public String showAllArticles(){
        articleList = articleManager.getTheArticles();
        return "";
    }

    public String saveArticle(){
        articleManager.addArticle(article);
        articleList = articleManager.getTheArticles();
        return "";

    }public String updateArticle(){
        articleManager.updateArticle(article);
        return "";
    }

    public String removeArticle(){
        articleManager.deleteArticle(article.getId());
        articleList = articleManager.getTheArticles();
        return "";
    }

    public List<Article> searchedArticle(String searchString){
        return articleManager.searchArticle(searchString);
    }
}
