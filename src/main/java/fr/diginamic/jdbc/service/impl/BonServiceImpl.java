package fr.diginamic.jdbc.service.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.BonService;

public class BonServiceImpl implements BonService 
{

	private BonDao bonDao = new BonDaoImpl();
	
	@Override
	public Bon ajouterBon(Integer numero, Date dateCommande, Integer delai, Fournisseur fournisseur) 
	{
		Bon bon = new Bon(numero, dateCommande, delai, fournisseur);
		try
		{
			return this.bonDao.create(bon);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Bon> recupererBon() 
	{
		try
		{
			return this.bonDao.findAll();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Bon> recupererBonParFournisseur(Fournisseur fournisseur) 
	{
		try
		{
			return this.bonDao.findByFournisseur(fournisseur);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Bon recupererBonParId(Integer id) 
	{
		try
		{
			return this.bonDao.findOne(id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Bon modifierNumero(Bon bon, Integer numero) 
	{
		try
		{
			return this.bonDao.updateNumero(bon, numero);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Bon modifierNumero(Integer id, Integer numero) 
	{
		return this.modifierNumero(this.recupererBonParId(id), numero);
	}
	
	@Override
	public Bon modifierDateCommande(Bon bon, Date commandeDate) 
	{
		try
		{
			return this.bonDao.updateCommandDate(bon, commandeDate);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Bon modifierDateCommande(Integer id, Date commandeDate) 
	{
		return this.modifierDateCommande(this.recupererBonParId(id), commandeDate);
	}
	
	@Override
	public Bon modifierDelai(Bon bon, Integer delai) 
	{
		try
		{
			return this.bonDao.updateDelay(bon, delai);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Bon modifierDelai(Integer id, Integer delai) 
	{
		return this.modifierDelai(this.recupererBonParId(id), delai);
	}
	
	@Override
	public Bon modifierFournisseur(Bon bon, Fournisseur fournisseur) 
	{
		try
		{
			return this.bonDao.updateFournisseur(bon, fournisseur);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Bon modifierFournisseur(Integer id, Fournisseur fournisseur) 
	{
		return this.modifierFournisseur(this.recupererBonParId(id), fournisseur);
	}
	

	
}
