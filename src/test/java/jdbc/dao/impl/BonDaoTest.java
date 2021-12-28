package jdbc.dao.impl;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;

public class BonDaoTest 
{
	
	private BonDao bonDao = new BonDaoImpl();
	private FournisseurDao fournisseurDao = new FournisseurDaoImpl();
	
	@Test
	public void testBonCreate() throws Exception
	{
		Fournisseur fournisseur = fournisseurDao.findOne(1);
		Bon bon = new Bon(99, new Date(99), 99, fournisseur);
		
		bon = bonDao.create(bon);
		
		assertNotNull(bon);
		assertNotNull(bon.getId());
		assertThat(bon.getNumero(), is(99));
		assertThat(bon.getDateCommande(), is(new Date(99)));
		assertThat(bon.getDelai(), is(99));
		assertThat(bon.getFournisseur(), is(fournisseur));
	}
	
	@Test
	public void testBonFindAll() throws Exception
	{
		List<Bon> bons = bonDao.findAll();
		
		assertNotNull(bons);
		if (!bons.isEmpty())
		{
			bons.stream().forEach(bon -> {
				assertNotNull(bon);
				assertNotNull(bon.getId());
				assertNotNull(bon.getFournisseur());
			});
		}
	}
	
	@Test
	public void testBonFindByFournisseur() throws Exception
	{
		Fournisseur fournisseur = fournisseurDao.findOne(1);
		List<Bon> bons = bonDao.findByFournisseur(fournisseur);
		
		assertNotNull(bons);
		if (!bons.isEmpty()) 
		{
			bons.stream().forEach(bon -> {
				assertNotNull(bon);
				assertNotNull(bon.getId());
				assertThat(bon.getFournisseur(), is(fournisseur));
			});
		}
	}
	
	@Test 
	public void testBonUpdateNumero() throws Exception
	{
		Bon bon = bonDao.findOne(1);
		Integer numero = bon.getNumero();
		Bon bonUpdate = bonDao.updateNumero(bon, 99);
		assertNotNull(bonUpdate);
		assertThat(bonUpdate.getNumero(), is(99));
		assertThat(bonUpdate.getDateCommande(), is(bon.getDateCommande()));
		assertThat(bonUpdate.getFournisseur(), is(bon.getFournisseur()));
		assertThat(bonUpdate.getId(), is(bon.getId()));
		assertThat(bonUpdate.getDelai(), is(bon.getDelai()));
		
		bonUpdate = bonDao.updateNumero(bonUpdate, numero);
		assertNotNull(bonUpdate);
		assertThat(bonUpdate, is(bon));
	}
	
	@Test 
	public void testBonUpdateCommandDate() throws Exception
	{
		Bon bon = bonDao.findOne(1);
		Date date = bon.getDateCommande();
		Bon bonUpdate = bonDao.updateCommandDate(bon, new Date(99));
		assertNotNull(bonUpdate);
		assertThat(bonUpdate.getNumero(), is(bon.getNumero()));
		assertThat(bonUpdate.getDateCommande(), is(new Date(99)));
		assertThat(bonUpdate.getFournisseur(), is(bon.getFournisseur()));
		assertThat(bonUpdate.getId(), is(bon.getId()));
		assertThat(bonUpdate.getDelai(), is(bon.getDelai()));
		
		bonUpdate = bonDao.updateCommandDate(bonUpdate, date);
		assertNotNull(bonUpdate);
		assertThat(bonUpdate, is(bon));
	}

	@Test
	public void testBonUpdateDelay() throws Exception
	{
		Bon bon = bonDao.findOne(1);
		Integer delai = bon.getDelai();
		Bon bonUpdate = bonDao.updateDelay(bon, 99);
		assertNotNull(bonUpdate);
		assertThat(bonUpdate.getNumero(), is(bon.getNumero()));
		assertThat(bonUpdate.getDateCommande(), is(bon.getDateCommande()));
		assertThat(bonUpdate.getFournisseur(), is(bon.getFournisseur()));
		assertThat(bonUpdate.getId(), is(bon.getId()));
		assertThat(bonUpdate.getDelai(), is(99));
		
		bonUpdate = bonDao.updateDelay(bonUpdate, delai);
		assertNotNull(bonUpdate);
		assertThat(bonUpdate, is(bon));
	}
	
	@Test
	public void testBonUpdateFournisseur() throws Exception
	{
		Fournisseur otherFournisseur = fournisseurDao.findOne(2);
		Bon bon = bonDao.findOne(1);
		Fournisseur fournisseur = bon.getFournisseur();
		Bon bonUpdate = bonDao.updateFournisseur(bon, otherFournisseur);
		assertNotNull(bonUpdate);
		assertThat(bonUpdate.getId(), is(bon.getId()));
		assertThat(bonUpdate.getDateCommande(), is(bon.getDateCommande()));
		assertThat(bonUpdate.getDelai(), is(bon.getDelai()));
		assertThat(bonUpdate.getNumero(), is(bon.getNumero()));
		assertThat(bonUpdate.getFournisseur(), is(otherFournisseur));
		
		bonUpdate = bonDao.updateFournisseur(bonUpdate, fournisseur);
		assertNotNull(bonUpdate);
		assertThat(bonUpdate, is(bon));
	}
	
	@Test
	public void testBonDeleteOne() throws Exception
	{
		Fournisseur fournisseur = fournisseurDao.findOne(1);
		Bon bon = new Bon(99, new Date(99), 99, fournisseur);
		Bon bonCreated = bonDao.create(bon);
		Boolean isDeleted = bonDao.deleteOne(bonCreated);
		
		assertNotNull(isDeleted);
		assertThat(isDeleted, is(true));
		
		Bon bonNotFound = bonDao.findOne(-1);
		isDeleted = bonDao.deleteOne(bonNotFound);
		assertNotNull(isDeleted);
		assertThat(isDeleted, is(false));
	}
}
