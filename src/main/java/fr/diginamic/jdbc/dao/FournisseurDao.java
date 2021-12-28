package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public interface FournisseurDao 
{
	Fournisseur create(Fournisseur fournisseur) throws SQLException;
	
	Fournisseur findOne(Integer id) throws SQLException;
	
	List<Fournisseur> findAll() throws SQLException;
	
	Fournisseur updateName(Fournisseur fournisseur, String newName) throws SQLException;
	
	Boolean deleteOne(Fournisseur fournisseur) throws Exception;
}
