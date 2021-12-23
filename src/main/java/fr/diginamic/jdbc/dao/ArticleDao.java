package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;

public interface ArticleDao 
{
	Article create(Article article) throws SQLException;
	
	Article findOne(Integer id) throws SQLException;
	
	List<Article> findByFournisseur(Fournisseur fournisseur) throws SQLException;
	
	List<Article> findAll() throws SQLException;
	
	Article updateRef(Article article, String newRef) throws SQLException;
	
	Article updateDesignation(Article article, String newDesignation) throws SQLException;
	
	Article updatePrice(Article article, Double newPrice ) throws SQLException;
	
	Article updateFournisseur(Article article, Fournisseur newfournisseur) throws SQLException;
	
}
