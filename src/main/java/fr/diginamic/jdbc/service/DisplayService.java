package fr.diginamic.jdbc.service;


import java.util.List;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
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
	void askForArticleId();
	void getAllArticle();
	void getAllArticle(List<Article> articles);
	void updateArticle();
	void updateArticle(Article article);
	void deleteArticle();
	void deleteArticle(Boolean isSuccess);
	
	
	void bonMenu();
	void creerBon();
	void askForBonId();
	void getAllBons();
	void getAllBons(List<Bon> bons);
	void updateBon();
	void updateBon(Bon bon);
	void deleteBon();
	void deleteBon(Boolean isSuccess);
}
