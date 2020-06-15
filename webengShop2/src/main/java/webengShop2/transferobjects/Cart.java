package webengShop2.transferobjects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repräsentiert einen Einkauswagen.
 * @author Nadia Radau, Mathias Betghe, Rene Hippe
 */

public class Cart implements Serializable{

    //Wird automatisch erstellt
    private static final long serialVersionUID = 1L;

    private List<Article> articleList;
    private double fullPrice;

    public void initialize(){
        this.articleList = new ArrayList<>();
    }

    public List<Article> getArticleList(){
        return this.articleList;
    }

    public void addArticle(Article article){
        this.articleList.add(article);
    }

    public void clearList(){
        this.articleList.clear();
    }



}
