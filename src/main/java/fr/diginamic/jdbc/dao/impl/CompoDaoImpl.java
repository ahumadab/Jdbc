package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.CompoDao;
import fr.diginamic.jdbc.dao.RequetesCompo;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Compo;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.util.NamedParameterStatement;

public class CompoDaoImpl implements CompoDao 
{

	private Connection connection;
	
	public CompoDaoImpl()
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
	public Compo create(Compo compo) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesCompo.ADD_COMPO.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, compo.getArticle().getId());
		ps.setInt(2, compo.getBon().getId());
		ps.setInt(3, compo.getQuantity());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		Integer id = rs.getInt("ID");
		compo.setId(id);
		return compo;
	}

	@Override
	public Compo findOne(Integer id) throws SQLException 
	{
		Compo compo = null;
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesCompo.COMPO_PAR_ID.getRequete());
		ps.setInt("id", id);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
		{
			Integer idFromDB = rs.getInt("id");
			Integer quantity = rs.getInt("qte");
			
			Integer fournisseurId = rs.getInt("fournisseurId");
			String fournisseurName = rs.getString("fournisseurNom");
			Fournisseur fournisseur = new Fournisseur(fournisseurId, fournisseurName);
			
			Integer articleId = rs.getInt("articleId");
			String articleRef = rs.getString("articleRef");
			Double articlePrice = rs.getDouble("articlePrice");
			Article article = new Article(articleId, articleRef, articleRef, articlePrice, fournisseur);
			
			Integer bonId = rs.getInt("bonId");
			Integer bonNumero = rs.getInt("bonNum");
			Date bonDateCmde = rs.getDate("bonDateCmde");
			Integer bonDelai = rs.getInt("bonDelai");
			Bon bon = new Bon(bonId, bonNumero, bonDateCmde, bonDelai, fournisseur);
			
			compo = new Compo(idFromDB, article, bon, quantity);
		}
		return compo;
	}

	@Override
	public List<Compo> findAll() throws SQLException 
	{
		List<Compo> compos = new ArrayList<Compo>();
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesCompo.ALL_COMPO.getRequete());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			Integer id = rs.getInt("id");
			Integer quantity = rs.getInt("qte");
			
			Integer fournisseurId = rs.getInt("fournisseurId");
			String fournisseurName = rs.getString("fournisseurNom");
			Fournisseur fournisseur = new Fournisseur(fournisseurId, fournisseurName);
			
			Integer articleId = rs.getInt("articleId");
			String articleRef = rs.getString("articleRef");
			Double articlePrice = rs.getDouble("articlePrice");
			Article article = new Article(articleId, articleRef, articleRef, articlePrice, fournisseur);
			
			Integer bonId = rs.getInt("bonId");
			Integer bonNumero = rs.getInt("bonNum");
			Date bonDateCmde = rs.getDate("bonDateCmde");
			Integer bonDelai = rs.getInt("bonDelai");
			Bon bon = new Bon(bonId, bonNumero, bonDateCmde, bonDelai, fournisseur);
			
			compos.add(new Compo(id, article, bon, quantity));
		}
		return compos;
	}
	
	@Override
	public List<Compo> findByArticle(Article article) throws SQLException 
	{
		List<Compo> compos = new ArrayList<Compo>();
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesCompo.COMPO_PAR_ARTICLE.getRequete());
		ps.setInt("idArticle", article.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			Integer compoId = rs.getInt("id");
			Integer compoQuantity = rs.getInt("qte");

			Integer bonId = rs.getInt("bonId");
			Integer bonNumero = rs.getInt("bonNum");
			Date bonDateCmde = rs.getDate("bonDateCmde");
			Integer bonDelai = rs.getInt("bonDelai");
			Bon bon = new Bon(bonId, bonNumero, bonDateCmde, bonDelai, article.getFournisseur());
			
			compos.add(new Compo(compoId, article, bon, compoQuantity));
		}
		return compos;
	}
	

	@Override
	public List<Compo> findByBon(Bon bon) throws SQLException 
	{
		List<Compo> compos = new ArrayList<Compo>();
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesCompo.COMPO_PAR_BON.getRequete());
		ps.setInt("idBon", bon.getId());
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Integer compoId = rs.getInt("id");
			Integer compoQuantity = rs.getInt("qte");

			Integer articleId = rs.getInt("articleId");
			String articleRef = rs.getString("articleRef");
			Double articlePrice = rs.getDouble("articlePrice");
			Article article = new Article(articleId, articleRef, articleRef, articlePrice, bon.getFournisseur());
			
			compos.add(new Compo(compoId, article, bon, compoQuantity));
		}
		return compos;
	}
	

	@Override
	public Compo updateArticle(Compo compo, Article newArticle) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesCompo.UPDATE_ARTICLE.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, newArticle.getId());
		ps.setInt(2, compo.getId());
		ps.executeUpdate();
		compo.setArticle(newArticle);
		return compo;
	}

	@Override
	public Compo updateBon(Compo compo, Bon newBon) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesCompo.UPDATE_BON.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, newBon.getId());
		ps.setInt(2, compo.getId());
		ps.executeUpdate();
		compo.setBon(newBon);
		return compo;
	}

	@Override
	public Compo updateQuantity(Compo compo, Integer newQuantity) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesCompo.UPDATE_QUANTITY.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, newQuantity);
		ps.setInt(2, compo.getId());
		ps.executeUpdate();
		compo.setQuantity(newQuantity);
		return compo;
	}

}
