package jdbc.dao.impl;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.dao.CompoDao;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.CompoDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Compo;

public class CompoDaoTest 
{
	private CompoDao compoDao = new CompoDaoImpl();
	private ArticleDao articleDao = new ArticleDaoImpl();
	private BonDao bonDao = new BonDaoImpl();
	
	@Test
	public void testCompoCreate() throws Exception 
	{
		Article article = articleDao.findOne(1);
		Bon bon = bonDao.findOne(1);
		Compo compo = new Compo(article, bon, 99);
		Compo compoCreated = compoDao.create(compo);
		
		assertNotNull(compoCreated);
		assertNotNull(compoCreated.getId());
		assertThat(compoCreated.getArticle(), is(article));
		assertThat(compoCreated.getBon(), is(bon));
		assertThat(compoCreated.getQuantity(), is(99));
	}
	
	@Test
	public void testCompoFindOne() throws Exception
	{
		Compo compoFound = compoDao.findOne(1);
		Compo compoNotFound = compoDao.findOne(-1);
		
		assertNotNull(compoFound);
		assertNotNull(compoFound.getId());
		assertNotNull(compoFound.getBon());
		assertNotNull(compoFound.getArticle());
		
		assertNull(compoNotFound);
	}
	
	@Test
	public void testCompoFindAll() throws Exception
	{
		List<Compo> compos = compoDao.findAll();
		
		assertNotNull(compos);
		if (!compos.isEmpty())
		{
			compos.stream().forEach(compo -> {
				assertNotNull(compo);
				assertNotNull(compo.getArticle());
				assertNotNull(compo.getBon());
				assertNotNull(compo.getId());
			});
		}
	}
	
	@Test
	public void testCompoFindByArticle() throws Exception
	{
		Article article = articleDao.findOne(1);
		List<Compo> compos = compoDao.findByArticle(article);
		
		assertNotNull(compos);
		if (!compos.isEmpty())
		{
			compos.stream().forEach(compo -> {
				assertNotNull(compo);
				assertThat(compo.getArticle(), is(article));
				assertNotNull(compo.getBon());
				assertNotNull(compo.getId());
			});
		}
	}
	
	@Test
	public void testCompoFindByBon() throws Exception
	{
		Bon bon = bonDao.findOne(1);
		List<Compo> compos = compoDao.findByBon(bon);
		
		assertNotNull(compos);
		if (!compos.isEmpty())
		{
			compos.stream().forEach(compo -> {
				assertNotNull(compo);
				assertNotNull(compo.getArticle());
				assertThat(compo.getBon(), is(bon));
				assertNotNull(compo.getId());
			});
		}
	}
	
	@Test
	public void testCompoUpdateArticle() throws Exception
	{
		Compo compo = compoDao.findOne(1);
		Article article = compo.getArticle();
		Article otherArticle = articleDao.findOne(1);
		Compo compoUpdate = compoDao.updateArticle(compo, otherArticle);
		
		assertNotNull(compoUpdate);
		assertNotNull(compoUpdate.getId());
		assertNotNull(compoUpdate.getBon());
		assertNotNull(compoUpdate.getQuantity());
		assertThat(compoUpdate.getArticle(), is(otherArticle));
		
		compoUpdate = compoDao.updateArticle(compo, article);
		assertNotNull(compoUpdate);
		assertThat(compoUpdate.getArticle(), is(article));
	}
	
	@Test
	public void testCompoUpdateBon() throws Exception
	{
		Compo compo = compoDao.findOne(1);
		Bon bon = compo.getBon();
		Bon otherBon = bonDao.findOne(1);
		Compo compoUpdate = compoDao.updateBon(compo, otherBon);
		
		assertNotNull(compoUpdate);
		assertNotNull(compoUpdate.getId());
		assertNotNull(compoUpdate.getArticle());
		assertNotNull(compoUpdate.getQuantity());
		assertThat(compoUpdate.getBon(), is(otherBon));
		
		compoUpdate = compoDao.updateBon(compoUpdate, bon);
		assertNotNull(compoUpdate);
		assertThat(compo.getBon(), is(bon));
		
	}

	@Test
	public void testCompoUpdateQuantity() throws Exception
	{
		Compo compo = compoDao.findOne(1);
		Integer quantity = compo.getQuantity();
		Compo compoUpdate = compoDao.updateQuantity(compo, 99);
		
		assertNotNull(compoUpdate);
		assertNotNull(compoUpdate.getId());
		assertNotNull(compoUpdate.getArticle());
		assertNotNull(compoUpdate.getBon());
		assertThat(compoUpdate.getQuantity(), is(99));
		
		compoUpdate = compoDao.updateQuantity(compoUpdate, quantity);
		assertNotNull(compoUpdate);
		assertThat(compo.getQuantity(), is(quantity));
	}
	
	@Test
	public void testCompoDeleteOne() throws Exception
	{
		
		Article article = articleDao.findOne(1);
		Bon bon = bonDao.findOne(1);
		Compo compo = new Compo(article, bon, 99);
		Compo compoCreated = compoDao.create(compo);
		Boolean hasBeenDeleted = compoDao.deleteOne(compoCreated);
		assertNotNull(hasBeenDeleted);
		assertThat(hasBeenDeleted, is(true));
		
		Compo compoDoesntExist = compoDao.findOne(-1);
		hasBeenDeleted = compoDao.deleteOne(compoDoesntExist);
		assertNotNull(hasBeenDeleted);
		assertThat(hasBeenDeleted, is(false));
	}
}
