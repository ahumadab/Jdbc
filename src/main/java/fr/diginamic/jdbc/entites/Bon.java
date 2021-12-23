package fr.diginamic.jdbc.entites;

import java.sql.Date;

public class Bon 
{
	private Integer id;
	private Integer numero;
	private Date dateCommande;
	private Integer delai;
	private Fournisseur fournisseur;
	
	public Bon(Integer numero, Date dateCommande, Integer delai, Fournisseur fournisseur) 
	{
		super();
		this.numero = numero;
		this.dateCommande = dateCommande;
		this.delai = delai;
		this.fournisseur = fournisseur;
	}
	
	public Bon(Integer id, Integer numero, Date dateCommande, Integer delai, Fournisseur fournisseur) 
	{
		this(numero, dateCommande, delai, fournisseur);
		this.id = id;
	}

	@Override
	public String toString() 
	{
		return "Bon [id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + ", delai=" + delai
				+ ", fournisseur=" + fournisseur + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	
}
