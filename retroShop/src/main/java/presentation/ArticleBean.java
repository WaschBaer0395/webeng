package presentation;

import businesslogic.ArticleManager;
import businesslogic.SessionUtils;
import businesslogic.UserManager;
import com.sun.org.apache.bcel.internal.generic.LoadClass;
import transferobjects.Article;
import transferobjects.User;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean
@Named
public class ArticleBean implements Serializable {

    private ArticleManager articleManager = new ArticleManager();
    ;
    private Article article = new Article();
    private List<Article> articleList;
    private List<Article> searchedList;
    private List<Article> userArticleList;
    private String searchString = "";
    private Article currentArticle = new Article();


    @PostConstruct
    public void init() {
        articleList = articleManager.getTheArticles();
        searchedList = articleList;
    }

    public void setArticle(Article a) {
        this.article = a;
    }

    public Article getArticle() {
        return this.article;
    }

    public Article getCurrentArticle() {
        return this.currentArticle;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Article> getSearchedList() {
        return this.searchedList;
    }

    public List<Article> getArticleList() {
        return this.articleList;
    }

    public String showAllArticles() {
        articleList = articleManager.getTheArticles();
        return "";
    }

    public String saveArticle() {
        System.out.println(FacesContext.getCurrentInstance().getViewRoot().getViewId());
        if (currentArticle != null) {
            if (articleManager.getArticle(currentArticle.getId()) != null) {
                currentArticle = article;
                articleManager.updateArticle(currentArticle);
            }
        } else {
            HttpSession session = SessionUtils.getSession();
            User user = (User) session.getAttribute("user");
            LocalDate today = LocalDate.now();
            article.setReleaseDate(today);
            article.setSellerId(user.getId());
            articleManager.addArticle(article);
            articleList = articleManager.getTheArticles();
        }
        return "success";
    }

    public String updateArticle() {
        articleManager.updateArticle(article);
        return "";
    }

    public String removeArticle() {
        articleManager.deleteArticle(article.getId());
        articleList = articleManager.getTheArticles();
        return "";
    }

    public String toArticleList() {
        System.out.println("to article list from :" + FacesContext.getCurrentInstance().getViewRoot().getViewId());
        return "toArticleList";
    }

    public String getSearchString() {
        return this.searchString;
    }

    public void setSearchString(String s) {
        System.out.println("setter: " + s);
        this.searchString = s;
        System.out.println("updated: " + searchString);
    }

    public String searchedArticle() {
        this.searchedList = articleManager.searchArticle(searchString);
        return "searchedList";
    }

    public List<String> listArticleNames(String s) {
        List<String> articleNames = new ArrayList<String>();

        for (Article a : articleManager.searchArticle(s)) {
            if (!articleNames.contains(a.getName())) {
                articleNames.add(a.getName());
            }

        }
        return articleNames;
    }

    public String goToDetail(long id) {
        currentArticle = null;
        if (articleManager.getArticle(id) != null) {
            currentArticle = articleManager.getArticle(id);
        } else {
            return "articleNotFound";
        }
        System.out.println(FacesContext.getCurrentInstance().getViewRoot().getViewId());
        return "articleDetail";
    }

    public void sellerArticleList(long id) {
        userArticleList = articleManager.getUserArticleList(id);
    }

    public List<Article> getUserArticleList() {
        HttpSession session = SessionUtils.getSession();
        User user = (User) session.getAttribute("user");
        long userID = user.getId();
        sellerArticleList(userID);
        return this.userArticleList;
    }

    public String goToEdit(Article a) {
        currentArticle = a;
        article = currentArticle;
        return "addArticle";
    }

    public String deleteArticle(long id) {
        articleManager.deleteArticle(id);
        return "myProfile";
    }

    public String addArticle() {
        System.out.println("Debug: addArticle <--");
        currentArticle = null;
        article = new Article();
        return "addArticle";
    }

}
