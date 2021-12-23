package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.CompoDao;
import fr.diginamic.jdbc.dao.impl.CompoDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Compo;
import fr.diginamic.jdbc.service.CompoService;

public class CompoServiceImpl implements CompoService 
{

	private CompoDao compoDao = new CompoDaoImpl();
	
	@Override
	public Compo ajouterCompo(Article article, Bon bon, Integer quantite) 
	{
		Compo compo = new Compo(article, bon, quantite);
		try
		{
			return this.compoDao.create(compo);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Compo recupererCompoParId(Integer id) 
	{
		try
		{
			return this.compoDao.findOne(id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Compo> recupererCompo() 
	{
		try
		{
			return this.compoDao.findAll();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Compo> recupererCompoParArticle(Article article) 
	{
		try
		{
			return this.compoDao.findByArticle(article);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Compo> recupererCompoParBon(Bon bon) 
	{
		try
		{
			return this.compoDao.findByBon(bon);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public Compo modifierArticle(Compo compo, Article newArticle) 
	{
		try
		{
			return this.compoDao.updateArticle(compo, newArticle);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Compo modifierArticle(Integer id, Article newArticle) 
	{
		return this.modifierArticle(this.recupererCompoParId(id), newArticle);
	}
	

	@Override
	public Compo modifierBon(Compo compo, Bon newBon) 
	{
		try
		{
			return this.compoDao.updateBon(compo, newBon);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Compo modifierBon(Integer id, Bon newBon) 
	{
		return this.modifierBon(this.recupererCompoParId(id), newBon);
	}
	

	@Override
	public Compo modifierQuantity(Compo compo, Integer newQuantity) 
	{
		try
		{
			return this.compoDao.updateQuantity(compo, newQuantity);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Compo modifierQuantity(Integer id, Integer newQuantity) 
	{
		return this.modifierQuantity(this.recupererCompoParId(id), newQuantity);
	}


}
