package access.mock;

import access.ArticleDAO;
import transferobjects.Article;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MockArticleDAO implements ArticleDAO {
    
    private List<Article> articles = new ArrayList<>();

    MockArticleDAO(){

    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate now = LocalDate.now();


		Article a1 = new Article();
		a1.setId(1);
		a1.setName("GameBoy");
		a1.setPrice(10f);
		a1.setSellerId(1);
		a1.setImagePath("irgendeinpfad");
		a1.setMinPrice(5f);
		a1.setDesc("Toller GameBoy");
		a1.setReleaseDate(now);
		add(a1);

		Article a2 = new Article();
		a1.setId(2);
		a1.setName("N64");
		a1.setPrice(56f);
		a1.setSellerId(1);
		a1.setImagePath("irgendeinpfad");
		a1.setMinPrice(52f);
		a1.setDesc("Tolle N64");
		a1.setReleaseDate(now);
		add(a2);

		Article a3 = new Article();
		a1.setId(3);
		a1.setName("Ocarina of Time");
		a1.setPrice(3.99f);
		a1.setSellerId(2);
		a1.setImagePath("irgendeinpfad");
		a1.setMinPrice(3f);
		a1.setDesc("Gut Erhalten");
		a1.setReleaseDate(now);
		add(a3);

		Article a4 = new Article();
		a1.setId(4);
		a1.setName("SuperMario 64");
		a1.setPrice(2.95f);
		a1.setSellerId(3);
		a1.setImagePath("irgendeinpfad");
		a1.setMinPrice(2.55f);
		a1.setDesc("Sehr gut erhalten");
		a1.setReleaseDate(now);
		add(a4);


	}
     
    
	@Override
    public Article get(long id) {
    	Article a = null;
    	try 
    	{
    		  a = articles.get((int) id);
    		  return a;
    	}
		catch(IndexOutOfBoundsException e) {
			System.out.println("MockArticleDAO::get: indexOutOfBounds");
		}

    	return a;
    }
     
    @Override
    public List<Article> getAll() {
    	List<Article> copy = new ArrayList<>();
    	for (Article a : articles)
    	{
    		copy.add(a);
    	}
        return copy;
    }
     
    @Override
    public void add(Article a) {
    	articles.add(a);
    }
     
    @Override
    public void update(Article article) {
    	Article a = get(article.getId());
    	a.setName(article.getName());
    	a.setPrice(article.getPrice());
    	a.setDesc(article.getDesc());
		a.setMinPrice(article.getMinPrice());
		a.setImagePath(article.getImagePath());
    }
     
    @Override
    public void delete(Article article) {
    	Article a = get(article.getId());
    	articles.remove(a);
    }



}
