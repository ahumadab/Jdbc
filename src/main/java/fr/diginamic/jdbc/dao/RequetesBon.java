package fr.diginamic.jdbc.dao;

public enum RequetesBon 
{
	ADD_BON("INSERT INTO BON (NUMERO, DATE_CMD, DELAI, ID_FOU) VALUES (?, ?, ?, ?)"),
	ALL_BON("SELECT BON.ID, NUMERO, DATE_CMDE, DELAI, ID_FOU, NOM as NOM_FOU FROM BON INNER JOIN fournisseur ON BON.ID_FOU = fournisseur.ID"),
	ALL_FOURNISSEUR_BON("SELECT BON.ID, NUMERO, DATE_CMDE, DELAI FROM BON WHERE ID_FOU = :fournisseurId"),
	BON_PAR_ID("SELECT BON.ID, NUMERO, DATE_CMDE, DELAI, ID_FOU, NOM as NOM_FOU FROM BON INNER JOIN fournisseur ON BON.ID_FOU = fournisseur.ID where BON.id = :id"),
	UPDATE_NUMERO("UPDATE BON SET NUMERO = ? WHERE id = ?"),
	UPDATE_DATECMDE("UPDATE BON SET DATE_CMDE = ? WHERE id = ?"),
	UPDATE_DELAI("UPDATE BON SET DELAI = ? WHERE id = ?"),
	UPDATE_FOURNISSEUR("UPDATE BON SET ID_FOU = ? WHERE id = ?"),
	;
	
	private String requete;
	
	private RequetesBon(String requete)
	{
		this.requete = requete;
	}
	
	public String getRequete()
	{
		return this.requete;
	}
}
