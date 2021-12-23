package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.dao.RequetesBon;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.util.NamedParameterStatement;

public class BonDaoImpl implements BonDao {

	private Connection connection;
	
	public BonDaoImpl()
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
	public Bon create(Bon bon) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesBon.ADD_BON.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, bon.getNumero());
		ps.setDate(2, bon.getDateCommande());
		ps.setInt(3, bon.getDelai());
		ps.setInt(4, bon.getFournisseur().getId());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt("ID");
		bon.setId(id);
		return bon;
	}

	@Override
	public Bon findOne(int id) throws SQLException 
	{
		Bon bon = null;
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesBon.BON_PAR_ID.getRequete());
		ps.setInt("id", id);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
		{
			int idBon = rs.getInt("ID");
			int numero = rs.getInt("NUMERO");
			Date dateCmde = rs.getDate("DATE_CMDE");
			int delai = rs.getInt("DELAI");
			int idFournisseur = rs.getInt("ID_FOU");
			String nameFournisseur = rs.getString("NOM_FOU");
			bon = new Bon(idBon, numero, dateCmde, delai, new Fournisseur(idFournisseur, nameFournisseur));
		}
		return bon;
	}

	@Override
	public List<Bon> findAll() throws SQLException 
	{
		List<Bon> bons = new ArrayList<Bon>();
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesBon.ALL_BON.getRequete());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			int idBon = rs.getInt("ID");
			int numero = rs.getInt("NUMERO");
			Date dateCmde = rs.getDate("DATE_CMDE");
			int delai = rs.getInt("DELAI");
			int idFournisseur = rs.getInt("ID_FOU");
			String nameFournisseur = rs.getString("NOM_FOU");
			bons.add(new Bon(idBon, numero, dateCmde, delai, new Fournisseur(idFournisseur, nameFournisseur)));
		}
		return bons;
	}
	
	@Override
	public List<Bon> findByFournisseur(Fournisseur fournisseur) throws SQLException 
	{
		List<Bon> bons = new ArrayList<Bon>();
		NamedParameterStatement ps = new NamedParameterStatement(this.connection, RequetesBon.ALL_FOURNISSEUR_BON.getRequete());
		ps.setInt("fournisseurId", fournisseur.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			int idBon = rs.getInt("ID");
			int numero = rs.getInt("NUMERO");
			Date dateCmde = rs.getDate("DATE_CMDE");
			int delai = rs.getInt("DELAI");
			bons.add(new Bon(idBon, numero, dateCmde, delai, fournisseur));
		}
		return bons;
	}

	
	@Override
	public Bon updateNumero(Bon bon, Integer newNum) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesBon.UPDATE_NUMERO.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, newNum);
		ps.setInt(2, bon.getId());
		ps.executeUpdate();
		bon.setNumero(newNum);
		return bon;
	}

	@Override
	public Bon updateCommandDate(Bon bon, Date newDate) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesBon.UPDATE_DATECMDE.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setDate(1, newDate);
		ps.setInt(2, bon.getId());
		ps.executeUpdate();
		bon.setDateCommande(newDate);
		return bon;
	}

	@Override
	public Bon updateDelay(Bon bon, Integer newNum) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesBon.UPDATE_DELAI.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, newNum);
		ps.setInt(2, bon.getId());
		ps.executeUpdate();
		bon.setDelai(newNum);
		return bon;
	}

	@Override
	public Bon updateFournisseur(Bon bon, Fournisseur newfournisseur) throws SQLException 
	{
		java.sql.PreparedStatement ps = this.connection.prepareStatement(RequetesBon.UPDATE_FOURNISSEUR.getRequete(), Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, newfournisseur.getId());
		ps.setInt(2, bon.getId());
		ps.executeUpdate();
		bon.setFournisseur(newfournisseur);
		return bon;
	}

}
