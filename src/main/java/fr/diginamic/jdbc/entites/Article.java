package fr.diginamic.jdbc.entites;

public class Article 
{
	private Integer id;
	private String ref;
	private String designation;
	private Double price;
	private Fournisseur fournisseur;
	
	public Article(String ref, String designation, Double price, Fournisseur fournisseur) 
	{
		super();
		this.ref = ref;
		this.designation = designation;
		this.price = price;
		this.fournisseur = fournisseur;
	}

	public Article(Integer id, String ref, String designation, Double price, Fournisseur fournisseur) 
	{
		this(ref, designation, price, fournisseur);
		this.id = id;
	}

	@Override
	public String toString() 
	{
		return "Article [id=" + id + ", ref=" + ref + ", designation=" + designation + ", price=" + price
				+ ", fournisseur=" + fournisseur + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	
}
