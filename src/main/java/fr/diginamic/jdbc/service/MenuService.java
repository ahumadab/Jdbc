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
	void deleteFournisseur();
	void deleteFournisseur2(Boolean success);
	
	void afficherArticles(Fournisseur fournisseur);
	void creerArticle(Fournisseur fournisseur);
	void updateArticle(Fournisseur fournisseur);
	void updateFournisseurArticleById(Fournisseur fournisseur);
	
	void articleMenu();
	void addArticle();
	void updateArticle();
	
	void bonMenu();
	
	void afficherBon();
	
	void afficherCompo();
	
	void afficherEnd();
	
	void display();
}
