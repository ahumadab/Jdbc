package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.RequetesFournisseur;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.util.NamedParameterStatement;

public class FournisseurDaoImpl implements FournisseurDao {

	private Connection connection;
	
	public FournisseurDaoImpl()
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
	public Fournisseur create(Fournisseur fournisseur) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesFournisseur.ADD_FOURNISSEUR.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, fournisseur.getName());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt("ID");
		fournisseur.setId(id);
		return fournisseur;
	}

	@Override
	public Fournisseur findOne(Integer id) throws SQLException 
	{
		Fournisseur fournisseur = null;
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesFournisseur.FOURNISSEUR_PAR_ID.getRequete());
		ps.setInt("id", id);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
		{
			int idFromDB = rs.getInt("ID");
			String name = rs.getString("NOM");
			fournisseur = new Fournisseur(idFromDB, name);
		}
		return fournisseur;
	}

	@Override
	public List<Fournisseur> findAll() throws SQLException 
	{
		List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesFournisseur.ALL_FOURNISSEUR.getRequete());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			int id = rs.getInt("ID");
			String name = rs.getString("NOM");
			fournisseurs.add(new Fournisseur(id, name));
		}
		return fournisseurs;
	}

	@Override
	public Fournisseur updateName(Fournisseur fournisseur, String newName) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesFournisseur.UPDATE_FOURNISSEUR_NOM.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, newName);
		ps.setInt(2, fournisseur.getId());
		ps.executeUpdate();
		fournisseur.setName(newName);
		return fournisseur;
	}

	
}
