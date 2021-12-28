package fr.diginamic.jdbc.dao;

public enum RequetesArticle 
{
	ADD_ARTICLE("INSERT INTO article (REF, DESIGNATION, PRIX, ID_FOU) VALUES (?, ?, ?, ?)"),
	ALL_ARTICLE("SELECT article.ID, REF, DESIGNATION, PRIX, ID_FOU, NOM as NOM_FOU FROM ARTICLE INNER JOIN fournisseur ON article.ID_FOU = fournisseur.ID"),
	ALL_FOURNISSEUR_ARTICLE("SELECT ID, REF, DESIGNATION, PRIX FROM ARTICLE WHERE ID_FOU = :fournisseurId"),
	ARTICLE_PAR_ID("SELECT article.ID, REF, DESIGNATION, PRIX, ID_FOU, NOM as NOM_FOU FROM ARTICLE INNER JOIN fournisseur ON article.ID_FOU = fournisseur.ID where article.id = :id"),
	UPDATE_REF("UPDATE article SET REF = ? WHERE id = ?"),
	UPDATE_DESIGNATION("UPDATE article SET DESIGNATION = ? WHERE id = ?"),
	UPDATE_PRICE("UPDATE article SET PRIX = ? WHERE id = ?"),
	UPDATE_FOURNISSEUR("UPDATE article SET ID_FOU = ? WHERE id = ?"),
	DELETE_ONE("DELETE FROM article WHERE ID = ?")
	;
	
	private String requete;
	
	private RequetesArticle(String requete)
	{
		this.requete = requete;
	}
	
	public String getRequete()
	{
		return this.requete;
	}
}
