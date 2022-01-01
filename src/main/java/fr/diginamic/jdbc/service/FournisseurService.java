package fr.diginamic.jdbc.service;

import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public interface FournisseurService 
{
	Fournisseur ajouterFournisseur(String nom);
	
	List<Fournisseur> recupererFournisseur();
	
	/**
	 * Recherche un fournisseur par son ID
	 * Retourne l'objet Fournisseur si il a été trouvé sinon null
	 * @param id
	 * @return Fournisseur | null
	 */
	Fournisseur recupererFournisseurParId(Integer id);
	
	Fournisseur modifierNomFournisseur(Fournisseur fournisseur, String name);

	Boolean supprimerFournisseur(Fournisseur fournisseur);
}
