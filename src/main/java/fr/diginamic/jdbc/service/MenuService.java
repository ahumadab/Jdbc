package fr.diginamic.jdbc.service;

import fr.diginamic.jdbc.entites.Fournisseur;

public interface MenuService 
{
	void mainMenu();
	
	void fournisseurMenu();

	void fournisseurList();
	void addfournisseur();
	void addfournisseur2(Fournisseur fournisseur);
	void oneFournisseur();
	void oneFournisseurFound(Fournisseur fournisseur);
	void oneFournisseurNotFound();
	void updateFournisseur(Fournisseur fournisseur);
	void updateFournisseur();
	void updateFournisseurNom(Fournisseur fournisseur);
	
	void afficherArticle();
	
	void afficherBon();
	
	void afficherCompo();
	
	void afficherEnd();
	
	void display();
}
