package fr.diginamic.jdbc.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;

public interface BonDao 
{
	Bon create(Bon bon) throws SQLException;
	
	Bon findOne(int id) throws SQLException;
	
	List<Bon> findAll() throws SQLException;
	
	List<Bon> findByFournisseur(Fournisseur fournisseur) throws SQLException;
	
	Bon updateNumero(Bon bon, Integer newNum) throws SQLException;
	
	Bon updateCommandDate(Bon bon, Date newDate) throws SQLException;
	
	Bon updateDelay(Bon bon, Integer newNum) throws SQLException;
	
	Bon updateFournisseur(Bon bon, Fournisseur newfournisseur) throws SQLException;
}
