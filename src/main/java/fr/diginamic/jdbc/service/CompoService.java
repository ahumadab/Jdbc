package fr.diginamic.jdbc.service;

import java.util.List;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Compo;

public interface CompoService 
{
	// Create
	
	Compo ajouterCompo(Article article, Bon bon, Integer quantite);
	
	// Read
	
	Compo recupererCompoParId(Integer id);
	
	List<Compo> recupererCompo();
	
	List<Compo> recupererCompoParArticle(Article article);
	
	List<Compo> recupererCompoParBon(Bon bon);
	
	// Update
	
	Compo modifierArticle(Compo compo, Article newArticle);
	Compo modifierArticle(Integer id, Article newArticle);
	
	Compo modifierBon(Compo compo, Bon newBon);
	Compo modifierBon(Integer id, Bon newBon);
	
	Compo modifierQuantity(Compo compo, Integer newQuantity);
	Compo modifierQuantity(Integer id, Integer newQuantity);
}
