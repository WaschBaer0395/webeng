package presentation;

import access.DAOFactory;
import businesslogic.ArticleManager;
import transferobjects.Article;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class ArticleBean implements Serializable {

    ArticleManager articleManager = new ArticleManager();;
    private Article article = new Article();
    private List<Article> articleList;
    private List<Article> searchedList;
    private String searchString = "";


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

    public List<Article> getSearchedList(){return this.searchedList;}

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

    public String getSearchString(){
        return this.searchString;
    }

    public void setSearchString(String s){
        System.out.println("setter: " + s);
        this.searchString = s;
        System.out.println("updated: " + searchString);
    }

    public List<Article> searchedArticle(){
        System.out.println("String: " + searchString);
        this.searchedList = articleManager.searchArticle(searchString);
        if(searchString.equals("oca")){
            System.out.println("debug");
        }
        return articleManager.searchArticle(searchString);
    }
}
