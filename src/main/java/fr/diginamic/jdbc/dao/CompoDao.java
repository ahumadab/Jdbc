package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Compo;

public interface CompoDao 
{
	Compo create(Compo compo) throws SQLException;
	
	Compo findOne(Integer id) throws SQLException;
	
	List<Compo> findAll() throws SQLException;
	
	List<Compo> findByArticle(Article article) throws SQLException;
	
	List<Compo> findByBon(Bon bon) throws SQLException;
	
	Compo updateArticle(Compo compo, Article newArticle) throws SQLException;
	
	Compo updateBon(Compo compo, Bon newBon) throws SQLException;
	
	Compo updateQuantity(Compo compo, Integer newQuantity) throws SQLException;
}
