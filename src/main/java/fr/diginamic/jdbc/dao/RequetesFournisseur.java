package fr.diginamic.jdbc.dao;

public enum RequetesFournisseur 
{
	ADD_FOURNISSEUR("INSERT INTO fournisseur (NOM) VALUES (?)"),
	ALL_FOURNISSEUR("SELECT * FROM fournisseur"),
	FOURNISSEUR_PAR_ID("SELECT * FROM fournisseur WHERE id=:id"),
	UPDATE_FOURNISSEUR_NOM("UPDATE fournisseur SET NOM = ? WHERE id = ?"),
	DELETE_ONE("DELETE FROM fournisseur WHERE ID = ?");
	
	private String requete;
	
	private RequetesFournisseur(String requete)
	{
		this.requete = requete;
	}
	
	public String getRequete()
	{
		return this.requete;
	}
}
