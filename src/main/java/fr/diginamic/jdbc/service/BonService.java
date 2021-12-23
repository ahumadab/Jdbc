package fr.diginamic.jdbc.service;

import java.sql.Date;
import java.util.List;

import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;

public interface BonService 
{
	// Create
	
	Bon ajouterBon(Integer numero, Date dateCommande, Integer delai, Fournisseur fournisseur);
	
	// Read
	
	List<Bon> recupererBon();
	
	List<Bon> recupererBonParFournisseur(Fournisseur fournisseur);
	
	Bon recupererBonParId(Integer id);
	
	// Update
	
	Bon modifierNumero(Bon bon, Integer numero);
	Bon modifierNumero(Integer id, Integer numero);
	
	Bon modifierDateCommande(Bon bon, Date commandeDate);
	Bon modifierDateCommande(Integer id, Date commandeDate);
	
	Bon modifierDelai(Bon bon, Integer delai);
	Bon modifierDelai(Integer id, Integer delai);
	
	Bon modifierFournisseur(Bon bon, Fournisseur fournisseur);
	Bon modifierFournisseur(Integer id, Fournisseur fournisseur);

}
