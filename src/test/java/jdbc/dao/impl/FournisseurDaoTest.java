package jdbc.dao.impl;

import org.junit.Test;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Fournisseur;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;


public class FournisseurDaoTest 
{
	private FournisseurDao fournisseurDao = new FournisseurDaoImpl();
	

	@Test
	public void testFournisseurCreate() throws Exception
	{
		Fournisseur f = new Fournisseur("Test");
		Fournisseur fournisseurTest = fournisseurDao.create(f);
		
		assertNotNull(fournisseurTest);
		assertNotNull(fournisseurTest.getId());
		assertThat(fournisseurTest.getName(), is("Test"));
	}
	
	@Test
	public void testFournisseurFindOne() throws Exception
	{
		Integer id = 1;
		Fournisseur f1 = fournisseurDao.findOne(id);
		Fournisseur f2 = fournisseurDao.findOne(-1);
		
		assertNotNull(f1);
		assertThat(f1.getId(), is(id));
		assertNotNull(f1.getName());
		assertNull(f2);
	}
	
	@Test
	public void testFournisseurFindAll() throws Exception
	{
		List<Fournisseur> fournisseurs = fournisseurDao.findAll();
		
		assertNotNull(fournisseurs);
		if (!fournisseurs.isEmpty())
		{
			assertNotNull(fournisseurs.get(0).getId());
			assertNotNull(fournisseurs.get(0).getName());
		}
	}
	
	@Test
	public void testFournisseurUpdate() throws Exception
	{
		Fournisseur fournisseur = fournisseurDao.findOne(1);
		if (fournisseur == null) 
		{
			fail();
		}
		Fournisseur fournisseurUpdated = fournisseurDao.updateName(fournisseur, "testUpdate");
		assertThat(fournisseurUpdated.getName(), is("testUpdate"));
	}
	
	@Test
	public void testFournisseurDeleteOne() throws Exception
	{
		Fournisseur f = new Fournisseur("Test");
		Fournisseur fournisseurCreated = fournisseurDao.create(f);
		Boolean isDeleted = fournisseurDao.deleteOne(fournisseurCreated);
		assertNotNull(isDeleted);
		assertThat(isDeleted, is(true));
		
		Fournisseur fournisseurNotFound = fournisseurDao.findOne(-1);
		isDeleted = fournisseurDao.deleteOne(fournisseurNotFound);
		assertNotNull(isDeleted);
		assertThat(isDeleted, is(false));
	}
}
