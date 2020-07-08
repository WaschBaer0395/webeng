package presentation;

import businesslogic.ArticleManager;
import transferobjects.Article;
import transferobjects.User;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@ManagedBean
@Named
public class ArticleBean implements Serializable {

    private ArticleManager articleManager = new ArticleManager();;
    private Article article = new Article();
    private List<Article> articleList;
    private List<Article> searchedList;
    private String searchString = "";
    private Article currentArticle = new Article();


    @PostConstruct
    public void init(){
            articleList = articleManager.getTheArticles();
            searchedList = articleList;
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

    public String toArticleList(){
        System.out.println("to article list from :" + FacesContext.getCurrentInstance().getViewRoot().getViewId() );
        return "toArticleList";
    }
    public String getSearchString(){
        return this.searchString;
    }

    public void setSearchString(String s){
        System.out.println("setter: " + s);
        this.searchString = s;
        System.out.println("updated: " + searchString);
    }

    public String searchedArticle(){
        this.searchedList = articleManager.searchArticle(searchString);
        articleManager.searchArticle(searchString);
        return "searchedList";
    }

    public List<String> listArticleNames(String s){
        List<String> articleNames = new ArrayList<String>();

        for(Article a : articleManager.searchArticle(s)){
            if (!articleNames.contains(a.getName())) {
                articleNames.add(a.getName());
            }

        }
        return articleNames;
    }

    public String goToDetail(long id){
        currentArticle = null;
        if( articleManager.getArticle(id) != null){
            currentArticle = articleManager.getArticle(id);
        }
        else{
            return "articleNotFound";
        }
        return "detail";
    }
}
