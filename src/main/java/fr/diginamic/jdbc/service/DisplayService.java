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
	void deleteFournisseur();
	void deleteFournisseur2(Boolean success);
	
	void listArticle(Fournisseur fournisseur);
	void creerArticle(Fournisseur fournisseur);

	void updateArticle(Fournisseur fournisseur);

	
	void articleMenu();	
	void creerArticle();
	void updateArticle();
}
