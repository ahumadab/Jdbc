package fr.diginamic.jdbc.dao;

public enum RequetesCompo 
{
	ADD_COMPO("INSERT INTO COMPO (ID_ART, ID_BON, QTE) VALUES (?, ?, ?)"),
	ALL_COMPO("SELECT compo.id, compo.qte,\r\n"
			+ "article.id as articleId, article.ref as articleRef, article.DESIGNATION as articleDesi, article.prix as articlePrice,\r\n"
			+ "bon.id as bonId, bon.numero as bonNumero, bon.date_cmde as bonDateCmde, bon.delai as bonDelai  , \r\n"
			+ "fournisseur.id as fournisseurId, fournisseur.nom as fournisseurNom\r\n"
			+ "FROM COMPO \r\n"
			+ "INNER JOIN article ON COMPO.ID_ART = article.ID\r\n"
			+ "INNER JOIN bon ON COMPO.ID_BON = bon.ID\r\n"
			+ "INNER JOIN fournisseur ON ARTICLE.id_fou = fournisseur.id"),
	COMPO_PAR_ID("SELECT compo.id, compo.qte,\r\n"
			+ "article.id as articleId, article.ref as articleRef, article.DESIGNATION as articleDesi, article.prix as articlePrice,\r\n"
			+ "bon.id as bonId, bon.numero as bonNumero, bon.date_cmde as bonDateCmde, bon.delai as bonDelai  , \r\n"
			+ "fournisseur.id as fournisseurId, fournisseur.nom as fournisseurNom\r\n"
			+ "FROM COMPO \r\n"
			+ "INNER JOIN article ON COMPO.ID_ART = article.ID\r\n"
			+ "INNER JOIN bon ON COMPO.ID_BON = bon.ID\r\n"
			+ "INNER JOIN fournisseur ON ARTICLE.id_fou = fournisseur.id\r\n"
			+ "WHERE compo.id = :id"),
	COMPO_PAR_ARTICLE("SELECT compo.id, compo.qte,\r\n"
			+ "bon.id as bonId, bon.numero as bonNumero, bon.date_cmde as bonDateCmde, bon.delai as bonDelai\r\n"
			+ "FROM COMPO\r\n"
			+ "INNER JOIN bon ON COMPO.ID_BON = bon.ID\r\n"
			+ "WHERE compo.ID_ART = :idArticle"),
	COMPO_PAR_BON("SELECT compo.id, compo.qte,\r\n"
			+ "article.id as articleId, article.ref as articleRef, article.DESIGNATION as articleDesi, article.prix as articlePrice\r\n"
			+ "FROM COMPO \r\n"
			+ "INNER JOIN article ON COMPO.ID_ART = article.ID\r\n"
			+ "WHERE COMPO.ID_BON = :idBon"),
	UPDATE_ARTICLE("UPDATE COMPO SET ID_ART = ? WHERE id = ?"),
	UPDATE_BON("UPDATE COMPO SET ID_BON = ? WHERE id = ?"),
	UPDATE_QUANTITY("UPDATE COMPO SET QTE = ? WHERE id = ?");
	
	private String requete;
	
	private RequetesCompo(String requete)
	{
		this.requete = requete;
	}
	
	public String getRequete()
	{
		return this.requete;
	}
}
