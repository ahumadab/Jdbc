package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.FournisseurService;

public class FournisseurServiceImpl implements FournisseurService 
{
	private FournisseurDao fournisseurDao = new FournisseurDaoImpl();
	
	@Override
	public Fournisseur ajouterFournisseur(String name) {
		Fournisseur fournisseur = new Fournisseur(name);
		try
		{
			this.fournisseurDao.create(fournisseur);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		return fournisseur;
	}

	@Override
	public List<Fournisseur> recupererFournisseur() {
		try
		{
			return this.fournisseurDao.findAll();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Fournisseur recupererFournisseurParId(Integer id) {
		try
		{
			return this.fournisseurDao.findOne(id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Fournisseur modifierNomFournisseur(Fournisseur fournisseur, String name) 
	{
		try
		{
			return this.fournisseurDao.updateName(fournisseur, name);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return fournisseur;
		}
	}

	@Override
	public Boolean supprimerFournisseur(Fournisseur fournisseur) 
	{
		try
		{
			return this.fournisseurDao.deleteOne(fournisseur);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
