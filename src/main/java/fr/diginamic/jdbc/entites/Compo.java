package fr.diginamic.jdbc.entites;

public class Compo 
{
	private Integer id;
	private Article article;
	private Bon bon;
	private Integer quantity;
	
	public Compo(Article article, Bon bon, Integer quantity) 
	{
		super();
		this.article = article;
		this.bon = bon;
		this.quantity = quantity;
	}
	
	public Compo(Integer id, Article article, Bon bon, Integer quantity) 
	{
		this(article, bon, quantity);
		this.id = id;
	}

	@Override
	public String toString() 
	{
		return "Compo [article=" + article + ", bon=" + bon + ", quantity=" + quantity + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Bon getBon() {
		return bon;
	}

	public void setBon(Bon bon) {
		this.bon = bon;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
