package jdbc.dao.impl;

import org.junit.Test;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Fournisseur;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class FournisseurDaoTest 
{
	private FournisseurDao fournisseurDao = new FournisseurDaoImpl();
	

	@Test
	public void test_fournisseur_create() throws Exception
	{
		Fournisseur f = new Fournisseur("Test");
		Fournisseur fournisseurTest = fournisseurDao.create(f);
		
		assertNotNull(fournisseurTest);
		assertNotNull(fournisseurTest.getId());
		assertThat(fournisseurTest.getName(), is("Test"));
	}
	
	@Test
	public void test_fournisseur_findOne() throws Exception
	{
		Integer id = 1;
		Fournisseur f1 = fournisseurDao.findOne(id);
		Fournisseur f2 = fournisseurDao.findOne(-1);
		
		assertNotNull(f1);
		assertThat(f1.getId(), is(id));
		assertNotNull(f1.getName());
		assertNull(f2);
	}
	
	
}
