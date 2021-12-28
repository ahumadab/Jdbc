package jdbc.dao.impl;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;

public class ArticleDaoTest 
{

	private ArticleDao articleDao = new ArticleDaoImpl();
	private FournisseurDao fournisseurDao = new FournisseurDaoImpl();
	
	@Test
	public void testArticleCreate() throws Exception
	{
		Fournisseur fournisseur = fournisseurDao.findOne(1);
		Article article = new Article("testCreate", "testCreation", 10.00, fournisseur);
		Article articleCreated = articleDao.create(article);
		
		assertNotNull(articleCreated);
		assertNotNull(articleCreated.getId());
		assertThat(articleCreated.getRef(), is("testCreate"));
		assertThat(articleCreated.getDesignation(), is("testCreation"));
		assertThat(articleCreated.getPrice(), is(10.00));
		assertThat(articleCreated.getFournisseur(), is(fournisseur));
	}

	@Test
	public void testArticleFindOne() throws Exception
	{
		Article articleFound = articleDao.findOne(1);
		Article articleNotFound = articleDao.findOne(-1);
		
		assertNotNull(articleFound);
		assertNotNull(articleFound.getId());
		assertNotNull(articleFound.getRef());
		assertNotNull(articleFound.getDesignation());
		assertNotNull(articleFound.getFournisseur());
		assertNull(articleNotFound);
	}
	
	@Test
	public void testArticleFindByFournisseur() throws Exception
	{
		Fournisseur fournisseur = fournisseurDao.findOne(1);
		List<Article> articles = articleDao.findByFournisseur(fournisseur);
		
		assertNotNull(articles);
		if (!articles.isEmpty())
		{
			articles.stream().forEach(article -> {
				assertThat(article.getFournisseur().getId(), is(fournisseur.getId()));
				assertNotNull(article.getId());
				assertNotNull(article.getRef());
				assertNotNull(article.getDesignation());
				assertNotNull(article.getPrice());
			});
		}	
	}
	
	@Test
	public void testArticleFindAll() throws Exception
	{
		List<Article> articles = articleDao.findAll();
		
		assertNotNull(articles);
		if (!articles.isEmpty())
		{
			articles.stream().forEach(article -> {
				assertNotNull(article);
				assertNotNull(article.getId());
				assertNotNull(article.getRef());
				assertNotNull(article.getDesignation());
				assertNotNull(article.getPrice());
				assertNotNull(article.getFournisseur());
			});
		}
	}
	
	@Test
	public void testArticleUpdateRef() throws Exception
	{
		Article article = articleDao.findOne(1);
		String ref = article.getRef();
		Article articleUpdated = articleDao.updateRef(article, "testUpdateRef");
		assertNotNull(articleUpdated);
		assertThat(articleUpdated.getId(), is(article.getId()));
		assertThat(articleUpdated.getDesignation(), is(article.getDesignation()));
		assertThat(articleUpdated.getPrice(), is(article.getPrice()));
		assertThat(articleUpdated.getFournisseur(), is(article.getFournisseur()));
		assertThat(articleUpdated.getRef(), is("testUpdateRef"));
		
		articleUpdated = articleDao.updateRef(articleUpdated, ref);
		assertNotNull(articleUpdated);
		assertThat(articleUpdated, is(article));
	}	
	
	@Test
	public void testArticleUpdateDesignation() throws Exception
	{
		Article article = articleDao.findOne(1);
		String designation = article.getDesignation();
		Article articleUpdated = articleDao.updateDesignation(article, "testUpdateDesignation");
		assertNotNull(articleUpdated);
		assertThat(articleUpdated.getId(), is(article.getId()));
		assertThat(articleUpdated.getPrice(), is(article.getPrice()));
		assertThat(articleUpdated.getFournisseur(), is(article.getFournisseur()));
		assertThat(articleUpdated.getRef(), is(article.getRef()));
		assertThat(articleUpdated.getDesignation(), is("testUpdateDesignation"));
		
		articleUpdated = articleDao.updateDesignation(articleUpdated, designation);
		assertNotNull(articleUpdated);
		assertThat(articleUpdated, is(article));
	}
	
	@Test
	public void testArticleUpdatePrice() throws Exception
	{
		Article article = articleDao.findOne(1);
		Double price = article.getPrice();
		Article articleUpdated = articleDao.updatePrice(article, 99.99);
		assertNotNull(articleUpdated);
		assertThat(articleUpdated.getId(), is(article.getId()));
		assertThat(articleUpdated.getPrice(), is(99.99));
		assertThat(articleUpdated.getFournisseur(), is(article.getFournisseur()));
		assertThat(articleUpdated.getRef(), is(article.getRef()));
		assertThat(articleUpdated.getDesignation(), is(article.getDesignation()));
		
		articleUpdated = articleDao.updatePrice(articleUpdated, price);
		assertNotNull(articleUpdated);
		assertThat(articleUpdated, is(article));
	}
	
	@Test
	public void testArticleUpdateFournisseur() throws Exception
	{
		Article article = articleDao.findOne(1);
		Fournisseur fournisseur = article.getFournisseur();
		Fournisseur otherFournisseur = fournisseurDao.findOne(2);
		Article articleUpdated = articleDao.updateFournisseur(article, otherFournisseur);
		assertNotNull(articleUpdated);
		assertThat(articleUpdated.getId(), is(article.getId()));
		assertThat(articleUpdated.getPrice(), is(article.getPrice()));
		assertThat(articleUpdated.getFournisseur(), is(otherFournisseur));
		assertThat(articleUpdated.getRef(), is(article.getRef()));
		assertThat(articleUpdated.getDesignation(), is(article.getDesignation()));
		
		articleUpdated = articleDao.updateFournisseur(articleUpdated, fournisseur);
		assertNotNull(articleUpdated);
		assertThat(articleUpdated, is(article));
	}
	
	@Test
	public void testArticleDeleteOne() throws Exception
	{
		Fournisseur fournisseur = fournisseurDao.findOne(1);
		Article article = new Article("testCreate", "testCreation", 10.00, fournisseur);
		Article articleCreated = articleDao.create(article);
		Boolean isDeleted = articleDao.deleteOne(articleCreated);
		
		assertNotNull(isDeleted);
		assertThat(isDeleted, is(true));
		
		Article articleNotFound = articleDao.findOne(-1);
		isDeleted = articleDao.deleteOne(articleNotFound);
		assertNotNull(isDeleted);
		assertThat(isDeleted, is(false));
		
	}
}
