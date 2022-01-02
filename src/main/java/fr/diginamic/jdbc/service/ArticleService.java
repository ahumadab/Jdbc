package fr.diginamic.jdbc.service;

import java.util.List;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;

public interface ArticleService 
{
	// Create

	Article ajouterArticle(String ref, String designation, Double price, Fournisseur fournisseur);
	
	// Read
	
	Article recupererArticleParId(Integer id);

	List<Article> recupererArticles();
	
	List<Article> recupererArticlesDuFournisseur(Fournisseur fournisseur);
	
	// Update
	
	Article modifierRef(Article article, String ref);
	Article modifierRef(Integer id, String ref);
	
	Article modifierDesignation(Article article, String designation);
	Article modifierDesignation(Integer id, String designation);
	
	Article modifierPrix(Article article, Double prix);
	Article modifierPrix(Integer id, Double prix);
	
	Article modifierFournisseur(Article article, Fournisseur fournisseur);
	Article modifierFournisseur(Integer id, Fournisseur fournisseur);
	
	Boolean supprimerArticle(Article article);
}
