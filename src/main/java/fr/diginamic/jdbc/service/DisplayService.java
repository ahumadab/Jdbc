package fr.diginamic.jdbc.service;

import fr.diginamic.jdbc.entites.Fournisseur;

public interface DisplayService 
{
	void mainMenu();
	
	void fournisseurMenu();
	void listFournisseur();
	void addFournisseur();
	void addFournisseur2(Fournisseur fournisseur);
	void askForIdFournisseur();
	void oneFournisseurFound(Fournisseur fournisseur);
	void oneFournisseurNotFound();
	void updateFournisseur(Fournisseur fournisseur);
	void updateFournisseur2();
}
