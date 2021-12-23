package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.ArticleService;

public class ArticleServiceImpl implements ArticleService 
{

	private ArticleDao articleDao = new ArticleDaoImpl();
	
	@Override
	public Article ajouterArticle(String ref, String designation, Double price, Fournisseur fournisseur) 
	{
		Article article = new Article(ref, designation, price, fournisseur);
		try
		{
			return this.articleDao.create(article);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Article recupererArticleParId(Integer id) 
	{
		try
		{
			return this.articleDao.findOne(id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Article> recupererArticles() 
	{
		try
		{
			return this.articleDao.findAll();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Article> recupererArticlesDuFournisseur(Fournisseur fournisseur) 
	{
		try
		{
			return this.articleDao.findByFournisseur(fournisseur);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public Article modifierRef(Article article, String ref) 
	{
		try
		{
			return this.articleDao.updateRef(article, ref);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Article modifierRef(Integer id, String ref) 
	{
		return this.modifierRef(this.recupererArticleParId(id), ref);
	}
	
	@Override
	public Article modifierDesignation(Article article, String designation) 
	{
		try
		{
			return this.articleDao.updateDesignation(article, designation);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Article modifierDesignation(Integer id, String designation) 
	{
		return this.modifierDesignation(this.recupererArticleParId(id), designation);
	}
	
	@Override
	public Article modifierPrix(Article article, Double prix) 
	{
		try
		{
			return this.articleDao.updatePrice(article, prix);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Article modifierPrix(Integer id, Double prix) 
	{
		return this.modifierPrix(this.recupererArticleParId(id), prix);
	}
	
	@Override
	public Article modifierFournisseur(Article article, Fournisseur fournisseur) 
	{
		try
		{
			return this.articleDao.updateFournisseur(article, fournisseur);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Article modifierFournisseur(Integer id, Fournisseur fournisseur) 
	{
		return this.modifierFournisseur(this.recupererArticleParId(id), fournisseur);
	}

	
}
