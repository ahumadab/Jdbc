package fr.diginamic.jdbc.service;

import java.util.List;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
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
	void getAllArticles();
	void getAllArticles(List<Article> articles);
	void getAllFournisseurArticles();
	void getOneArticle();
	void updateArticle();
	void updateArticle(Article article);
	void deleteArticle();
	void deleteArticle(Boolean isSuccess);
	
	void bonMenu();
	void addBon();
	void getAllBons();
	void getAllBons(List<Bon> bons);
	void getAllFournisseurBons();
	void getOneBon();
	void updateBon();
	void updateBon(Bon bon);
	void deleteBon();
	void deleteBon(Boolean isSuccess);
	
	void afficherBon();
	
	void afficherCompo();
	
	void afficherEnd();
	
	void display();
}
