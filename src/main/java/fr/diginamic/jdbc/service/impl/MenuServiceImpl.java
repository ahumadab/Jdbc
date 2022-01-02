package fr.diginamic.jdbc.service.impl;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.ArticleService;
import fr.diginamic.jdbc.service.DisplayService;
import fr.diginamic.jdbc.service.FournisseurService;
import fr.diginamic.jdbc.service.InputService;
import fr.diginamic.jdbc.service.MenuService;

public class MenuServiceImpl implements MenuService 
{
	
	private InputService inputService = new InputServiceImpl(this);
	private DisplayService displayService = new DisplayServiceImpl();
	private ArticleService articleService = new ArticleServiceImpl();
	
	/**
	 * Display Main menu
	 */
	public void display()
	{
		mainMenu();
	}
	

	@Override
	public void mainMenu() 
	{
		displayService.mainMenu();
		inputService.mainMenu();
	}

	@Override
	public void fournisseurMenu()
	{
		displayService.fournisseurMenu();
		inputService.fournisseurMenu();
	}
	
	public void addfournisseur()
	{
		displayService.addFournisseur();
		inputService.addFournisseur();
	}
	
	public void addfournisseur2(Fournisseur fournisseur)
	{
		displayService.addFournisseur2(fournisseur);
		inputService.addFournisseur2();
	}

	@Override
	public void fournisseurList() 
	{
		displayService.listFournisseur();
		inputService.listFournisseur();
	}

	@Override
	public void oneFournisseur() 
	{
		displayService.askForIdFournisseur();
		inputService.oneFournisseur();
	}

	@Override
	public void oneFournisseurFound(Fournisseur fournisseur) 
	{
		displayService.oneFournisseurFound(fournisseur);
		inputService.oneFournisseurFound(fournisseur);
	}

	@Override
	public void oneFournisseurNotFound() 
	{
		displayService.oneFournisseurNotFound();
		inputService.oneFournisseurNotFound();
	}
	

	@Override
	public void updateFournisseur() 
	{	
		displayService.askForIdFournisseur();
		inputService.updateFournisseur();
	}
	
	@Override
	public void updateFournisseur(Fournisseur fournisseur) 
	{	
		displayService.updateFournisseur(fournisseur);
		inputService.updateFournisseur2(fournisseur);
	}

	@Override
	public void updateFournisseurNom(Fournisseur fournisseur) 
	{
		displayService.updateFournisseur2();
		inputService.updateFournisseurName(fournisseur);
	}

	@Override
	public void deleteFournisseur() 
	{
		displayService.deleteFournisseur();
		inputService.deleteFournisseur();
	}
	
	
	@Override
	public void deleteFournisseur2(Boolean success) 
	{
		displayService.deleteFournisseur2(success);
		inputService.deleteFournisseur2();
	}

	

	@Override
	public void afficherArticles(Fournisseur fournisseur)
	{
		displayService.listArticle(fournisseur);
		inputService.listArticleByFournisseur(fournisseur);
	}
	

	@Override
	public void creerArticle(Fournisseur fournisseur) 
	{
		displayService.creerArticle(fournisseur);
		inputService.creerArticle(fournisseur);
	}

	@Override
	public void updateArticle(Fournisseur fournisseur) 
	{
		displayService.updateArticle(fournisseur);
		inputService.updateArticle(fournisseur);
	}

	@Override
	public void updateFournisseurArticleById(Fournisseur fournisseur) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void articleMenu() 
	{
		displayService.articleMenu();
		inputService.articleMenu();
	}


	@Override
	public void addArticle() 
	{
		displayService.creerArticle();
		inputService.creerArticle();
	}

	@Override
	public void getAllArticles()
	{
		displayService.getAllArticle();
		inputService.getAllArticles();
	}

	@Override
	public void getAllFournisseurArticles() 
	{
		displayService.askForIdFournisseur();
		inputService.getAllFournisseurArticles();		
	}

	@Override
	public void getAllArticles(List<Article> articles) 
	{
		displayService.getAllArticle(articles);
		inputService.getAllArticles();
	}

	@Override
	public void getOneArticle() 
	{
		displayService.askForArticleId();
		inputService.getOneArticle();
	}

	@Override
	public void updateArticle() 
	{
		displayService.updateArticle();
		inputService.updateArticle();
	}

	@Override
	public void updateArticle(Article article) 
	{
		displayService.updateArticle(article);
		inputService.updateArticle2(article);
	}


	@Override
	public void deleteArticle() 
	{
		displayService.deleteArticle();
		inputService.deleteArticle();
	}

	@Override
	public void deleteArticle(Boolean isSuccess) 
	{
		displayService.deleteArticle(isSuccess);
		inputService.deleteArticle2();
	}


	@Override
	public void bonMenu() 
	{
		displayService.bonMenu();
		inputService.bonMenu();
	}


	@Override
	public void addBon() 
	{
		displayService.creerBon();
		inputService.creerArticle();
	}


	@Override
	public void getAllBons() 
	{
		displayService.getAllArticle();
		inputService.getAllArticles();
	}


	@Override
	public void getAllBons(List<Bon> bons) 
	{
		displayService.getAllBons(bons);
		inputService.getAllBons();
	}


	@Override
	public void getAllFournisseurBons() 
	{
		displayService.askForIdFournisseur();
		inputService.getAllFournisseurBons();
	}


	@Override
	public void getOneBon() 
	{
		displayService.askForBonId();
		inputService.getOneBon();
	}


	@Override
	public void updateBon() 
	{
		displayService.updateBon();
		inputService.updateBon();		
	}


	@Override
	public void updateBon(Bon bon)
	{
		displayService.updateBon(bon);
		inputService.updateBon(bon);		
	}


	@Override
	public void deleteBon()
	{
		displayService.deleteBon();
		inputService.deleteBon();
	}


	@Override
	public void deleteBon(Boolean isSuccess) 
	{
		displayService.deleteArticle(isSuccess);
		inputService.deleteBon2();
	}


	@Override
	public void afficherBon() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherCompo() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherEnd() 
	{
		System.out.println("End");
	}
	
	
	
}
