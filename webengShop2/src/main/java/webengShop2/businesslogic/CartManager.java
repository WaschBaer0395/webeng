package webengShop2.businesslogic;

import webengShop2.transferobjects.Article;
import webengShop2.transferobjects.Cart;


public class CartManager {

    ArticleManager am = new ArticleManager();


    public void addNewArticle(Article article, Cart cart) {
        cart.addArticle(article);
    }

    public double calculatePrice(Cart cart) {

        double fullPrice = 0;
        for(Article a : cart.getArticleList()) {
            fullPrice += a.getPrice();
        }
        return fullPrice;
    }

    public void checkout(Cart cart) {
        calculatePrice(cart);
        cart.clearList();

    }

}
