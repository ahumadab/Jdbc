package fr.diginamic.jdbc.service;

import java.util.List;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;

public interface InputService 
{
	void mainMenu();
	
	void fournisseurMenu();
	void listFournisseur();
	void addFournisseur();
	void addFournisseur2();
	void oneFournisseur();
	void oneFournisseurFound(Fournisseur founisseur);
	void oneFournisseurNotFound();
	void updateFournisseur();
	void updateFournisseur2(Fournisseur fournisseur);
	void updateFournisseurName(Fournisseur fournisseur);
	void deleteFournisseur();
	void deleteFournisseur2();
	void listArticleByFournisseur(Fournisseur fournisseur);
	void creerArticle(Fournisseur fournisseur);
	
	void updateArticle(Fournisseur fournisseur);

	void articleMenu();
	void creerArticle();
	void getAllArticles();
	void getAllFournisseurArticles();
	void getOneArticle();
	void updateArticle();
	void updateArticle2(Article article);
	void deleteArticle();
	void deleteArticle2();
	
	void bonMenu();
	void creerBon();
	void getOneBon();
	void getAllBons();
	void getAllFournisseurBons();
	void updateBon();
	void updateBon(Bon bon);
	void deleteBon();
	void deleteBon2();
}
