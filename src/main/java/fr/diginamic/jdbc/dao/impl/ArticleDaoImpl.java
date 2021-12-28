package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.RequetesArticle;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.util.NamedParameterStatement;

public class ArticleDaoImpl implements ArticleDao {

	private Connection connection;
	
	public ArticleDaoImpl()
	{
		try
		{
			this.connection = ConnexionBdd.getConnection();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public Article create(Article article) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesArticle.ADD_ARTICLE.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, article.getRef());
		ps.setString(2, article.getDesignation());
		ps.setDouble(3, article.getPrice());
		ps.setInt(4, article.getFournisseur().getId());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt("ID");
		article.setId(id);
		return article;
	}

	@Override
	public Article findOne(Integer id) throws SQLException 
	{
		Article article = null;
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesArticle.ARTICLE_PAR_ID.getRequete());
		ps.setInt("id", id);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
		{
			Integer idArticle = rs.getInt("ID");
			String ref = rs.getString("REF");
			String designation = rs.getString("DESIGNATION");
			Double price = rs.getDouble("PRIX");
			Integer idFournisseur = rs.getInt("ID_FOU");
			String nameFournisseur = rs.getString("NOM_FOU");
			article = new Article(idArticle, ref, designation, price, new Fournisseur(idFournisseur, nameFournisseur));
		}
		return article;
	}
	
	@Override
	public List<Article> findByFournisseur(Fournisseur fournisseur) throws SQLException 
	{
		List<Article> articles = new ArrayList<Article>();
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesArticle.ALL_FOURNISSEUR_ARTICLE.getRequete());
		ps.setInt("fournisseurId", fournisseur.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			Integer idArticle = rs.getInt("ID");
			String ref = rs.getString("REF");
			String designation = rs.getString("DESIGNATION");
			Double price = rs.getDouble("PRIX");
			articles.add(new Article(idArticle, ref, designation, price, fournisseur));
		}
		return articles;
	}

	@Override
	public List<Article> findAll() throws SQLException 
	{
		List<Article> articles = new ArrayList<Article>();
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesArticle.ALL_ARTICLE.getRequete());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			Integer idArticle = rs.getInt("ID");
			String ref = rs.getString("REF");
			String designation = rs.getString("DESIGNATION");
			Double price = rs.getDouble("PRIX");
			Integer idFournisseur = rs.getInt("ID_FOU");
			String nameFournisseur = rs.getString("NOM_FOU");
			articles.add(new Article(idArticle, ref, designation, price, new Fournisseur(idFournisseur, nameFournisseur)));
		}
		return articles;
	}

	@Override
	public Article updateRef(Article article, String newRef) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesArticle.UPDATE_REF.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, newRef);
		ps.setInt(2, article.getId());
		ps.executeUpdate();
		article.setRef(newRef);
		return article;
	}

	@Override
	public Article updateDesignation(Article article, String newDesignation) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesArticle.UPDATE_DESIGNATION.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, newDesignation);
		ps.setInt(2, article.getId());
		ps.executeUpdate();
		article.setDesignation(newDesignation);
		return article;
	}

	@Override
	public Article updatePrice(Article article, Double newPrice) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesArticle.UPDATE_PRICE.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setDouble(1, newPrice);
		ps.setInt(2, article.getId());
		ps.executeUpdate();
		article.setPrice(newPrice);
		return article;
	}

	@Override
	public Article updateFournisseur(Article article, Fournisseur newfournisseur) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesArticle.UPDATE_FOURNISSEUR.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, newfournisseur.getId());
		ps.setInt(2, article.getId());
		ps.executeUpdate();
		article.setFournisseur(newfournisseur);
		return article;
	}

	@Override
	public Boolean deleteOne(Article article) throws Exception 
	{
		try
		{
			java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesArticle.DELETE_ONE.getRequete(), Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, article.getId());
			Integer res = ps.executeUpdate();
			if (res == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			return false;
		}
		
	}

}
