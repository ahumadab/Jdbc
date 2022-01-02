package fr.diginamic.jdbc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.ArticleService;
import fr.diginamic.jdbc.service.FournisseurService;
import fr.diginamic.jdbc.service.InputService;
import fr.diginamic.jdbc.service.MenuService;

public class InputServiceImpl implements InputService 
{
	private FournisseurService fournisseurService = new FournisseurServiceImpl();
	private ArticleService articleService = new ArticleServiceImpl();
	private MenuService menuService;
	private Scanner scanner = new Scanner(System.in);
	
	public InputServiceImpl(MenuService menuSerivce)
	{
		this.menuService = menuSerivce;
	}
	
	@Override
	public void mainMenu() 
	{
		Integer choice = scanner.nextInt();
		if (choice == 1) 
		{
			menuService.fournisseurMenu();
		}
		else if (choice == 2)
		{
			menuService.articleMenu();
		}
		else if (choice == 3)
		{
			menuService.bonMenu();
		}
		else if (choice == 0)
		{
			
		}
		else
		{
			menuService.mainMenu();
		}
	}

	@Override
	public void fournisseurMenu() 
	{
		Integer choice = scanner.nextInt();
		if (choice == 1) 
		{
			menuService.addfournisseur();
		}
		else if (choice == 2)
		{
			menuService.fournisseurList();
		}
		else if (choice == 3) 
		{
			menuService.oneFournisseur();
		}
		else if (choice == 4) 
		{
			menuService.updateFournisseur();
		}
		else if (choice == 5) 
		{
			menuService.deleteFournisseur();
		}
		else 
		{
			menuService.mainMenu();
		}
	}

	@Override
	public void addFournisseur() 
	{
		String choice = scanner.next();
		if (choice.equals("0") || choice.equals("0")) 
		{
			menuService.fournisseurMenu();
		}
		else if (!choice.equals(""))
		{
			Fournisseur fournisseur = fournisseurService.ajouterFournisseur(choice);
			menuService.addfournisseur2(fournisseur);
		}
		else
		{
			System.out.println("choice =" +choice +"?");
		}
	}

	@Override
	public void addFournisseur2() 
	{
		Integer choice = scanner.nextInt();
		if (choice == 0)
		{
			menuService.fournisseurMenu();
		}
		else if (choice == 1)
		{
			menuService.addfournisseur();
		}
		
	}

	@Override
	public void listFournisseur() 
	{
		Integer choice = scanner.nextInt();
		if (choice == 0) 
		{
			menuService.fournisseurMenu();
		}

	}

	@Override
	public void oneFournisseur() 
	{
		Integer choice = scanner.nextInt();
		if (choice == 0) 
		{
			menuService.fournisseurMenu();
		}
		else 
		{
			Fournisseur fournisseur = fournisseurService.recupererFournisseurParId(choice);
			if (fournisseur == null)
			{
				menuService.oneFournisseurNotFound();
			}
			else
			{
				menuService.oneFournisseurFound(fournisseur);
			}
		}
	}

	@Override
	public void oneFournisseurFound(Fournisseur founisseur) 
	{
		Integer choice = scanner.nextInt();
		if (choice == 0)
		{
			menuService.fournisseurMenu();
		}
		else if (choice == 1)
		{
			menuService.updateFournisseur(founisseur);
		}
		else if (choice == 2)
		{
			menuService.afficherArticles(founisseur);
		}
		else if (choice == 3)
		{
			Boolean isSuccess = fournisseurService.supprimerFournisseur(founisseur);
			menuService.deleteFournisseur2(isSuccess);
		}
		else
		{
			menuService.oneFournisseurFound(founisseur);
		}
	}

	@Override
	public void oneFournisseurNotFound() 
	{
		scanner.nextInt();
		menuService.oneFournisseur();
	}

	@Override
	public void updateFournisseur() 
	{
		Integer choice = scanner.nextInt();
		if (choice == 0) 
		{
			menuService.fournisseurMenu();
		}
		else 
		{
			Fournisseur fournisseur = fournisseurService.recupererFournisseurParId(choice);
			if (fournisseur == null)
			{
				menuService.oneFournisseurNotFound();
			}
			else
			{
				menuService.updateFournisseur(fournisseur);
			}
		}
	}

	@Override
	public void updateFournisseur2(Fournisseur fournisseur) 
	{
		Integer choice = scanner.nextInt();
		if (choice ==  1)
		{
			menuService.updateFournisseurNom(fournisseur);
		}
		else
		{
			menuService.oneFournisseurFound(fournisseur);
		}
	}

	@Override
	public void updateFournisseurName(Fournisseur fournisseur) 
	{
		String choice = scanner.next();
		if (choice.equals("0"))
		{
			System.out.println("test");
			menuService.fournisseurMenu();
		}
		else if (!choice.equals(""))
		{
			fournisseurService.modifierNomFournisseur(fournisseur, choice);
			menuService.oneFournisseurFound(fournisseur);
		}
	}

	
	@Override
	public void deleteFournisseur()
	{
		Integer choice = scanner.nextInt();
		if (choice == 0)
		{
			menuService.fournisseurMenu();
		}
		else
		{
			Fournisseur fournisseur = fournisseurService.recupererFournisseurParId(choice);
			Boolean isSuccess = fournisseurService.supprimerFournisseur(fournisseur);
			menuService.deleteFournisseur2(isSuccess);
		}
	}

	@Override
	public void deleteFournisseur2() 
	{
		scanner.nextInt();
		menuService.fournisseurMenu();
		
	}

	
	@Override
	public void listArticleByFournisseur(Fournisseur fournisseur) 
	{
		Integer choice = scanner.nextInt();
		if (choice == 1)
		{
			menuService.creerArticle(fournisseur);
		}
		else if (choice == 2)
		{
			menuService.updateArticle(fournisseur);
		}
		else if (choice == 3)
		{
			System.out.println("WIP");
			System.out.println("delete article");
		}
		else if (choice == 0)
		{
			menuService.oneFournisseurFound(fournisseur);
		}
		else
		{
			menuService.afficherArticles(fournisseur);
		}
	}

	@Override
	public void creerArticle(Fournisseur fournisseur) 
	{
		String ref = scanner.next();
		if (ref.equals("0"))
		{
			menuService.mainMenu();
		}
		System.out.println("Réference: " + ref);
		String designation = scanner.next();
		if (designation.equals("0"))
		{
			menuService.mainMenu();
		}
		System.out.println("Designation: " + designation);
		Double price = scanner.nextDouble();
		if (price == 0)
		{
			menuService.mainMenu();
		}
		articleService.ajouterArticle(ref, designation, price, fournisseur);
		menuService.afficherArticles(fournisseur);
	}

	@Override
	public void updateArticle(Fournisseur fournisseur)
	{
		Boolean noArticles = articleService.recupererArticlesDuFournisseur(fournisseur).isEmpty();
		Integer choice = scanner.nextInt();
		if (!noArticles)
		{
			System.out.println("WIP");
			System.out.println("Update article by id");
		}
		if (choice == 0)
		{
			menuService.afficherArticles(fournisseur);
		}
	}

	@Override
	public void articleMenu() 
	{
		Integer choice = scanner.nextInt();
		if (choice == 1) 
		{
			menuService.addArticle();
		}
		else if (choice == 2)
		{
			menuService.getAllArticles();
		}
		else if (choice == 3)
		{
			menuService.getAllFournisseurArticles();
		}
		else if (choice == 4)
		{
			menuService.getOneArticle();
		}
		else if (choice == 5)
		{
			menuService.updateArticle();
		}
		else if (choice == 6)
		{
			menuService.deleteArticle();
		}
		else if (choice == 0)
		{
			menuService.mainMenu();
		}
		else
		{
			menuService.articleMenu();
		}
	}

	@Override
	public void creerArticle() 
	{
		Fournisseur fournisseur = null;
		while (fournisseur == null)
		{
			Integer fournisseurID = scanner.nextInt();
			if (fournisseurID == 0)
			{
				menuService.articleMenu();
			}
			fournisseur = fournisseurService.recupererFournisseurParId(fournisseurID);
			if (fournisseur == null)
			{
				System.out.println("Fournisseur introuvable");
				System.out.println("Retapez l'ID du fournisseur");
			}
		}
		System.out.println(fournisseur);
		String ref = scanner.next();
		if (ref.equals("0"))
		{
			menuService.articleMenu();
		}
		System.out.println("Réference: " + ref);
		String designation = scanner.next();
		if (designation.equals("0"))
		{
			menuService.articleMenu();
		}
		System.out.println("Designation: " + designation);
		Double price = scanner.nextDouble();
		if (price == 0)
		{
			menuService.articleMenu();
		}
		articleService.ajouterArticle(ref, designation, price, fournisseur);
		menuService.afficherArticles(fournisseur);
	}

	@Override
	public void getAllArticles() 
	{
		scanner.nextInt();
		menuService.articleMenu();
	}

	@Override
	public void getAllFournisseurArticles() 
	{
		Fournisseur fournisseur = null;
		while (fournisseur == null)
		{
			Integer choice = scanner.nextInt();
			if (choice == 0)
			{
				menuService.articleMenu();
				break;
			}
			fournisseur = fournisseurService.recupererFournisseurParId(choice);
			if (fournisseur == null)
			{
				System.out.println("Fournisseur introuvable");
				System.out.println("Veuillez resaisir l'ID du Fournisseur");
			}
		}
		List<Article> articles = articleService.recupererArticlesDuFournisseur(fournisseur);
		menuService.getAllArticles(articles);
	}

	@Override
	public void getOneArticle() 
	{
		Article article = null;
		while (article == null)
		{
			Integer choice = scanner.nextInt();
			if (choice == 0)
			{
				menuService.articleMenu();
				break;
			}
			article = articleService.recupererArticleParId(choice);
			if (article == null)
			{
				System.out.println("Article introuvable");
				System.out.println("Veuillez resaisir l'ID de l'Article");
			}
		}
		List<Article> articles = new ArrayList<Article>();
		articles.add(article);
		menuService.getAllArticles(articles);
	}

	@Override
	public void updateArticle() 
	{
		Article article = null;
		while (article == null)
		{
			Integer choice = scanner.nextInt();
			if (choice == 0)
			{
				menuService.mainMenu();
				break;
			}
			article = articleService.recupererArticleParId(choice);
			if (article == null)
			{
				System.out.println("Article introuvable");
				System.out.println("Veuillez resaisir l'ID d'un article");
			}
		}
		
		menuService.updateArticle(article);
	}

	@Override
	public void updateArticle2(Article article) 
	{
		String ref = scanner.next();
		if (ref.equals("0"))
		{
			menuService.articleMenu();
		}
		System.out.println("Réference: " + ref);
		String designation = scanner.next();
		if (designation.equals("0"))
		{
			menuService.articleMenu();
		}
		System.out.println("Designation: " + designation);
		Double price = scanner.nextDouble();
		if (price == 0)
		{
			menuService.articleMenu();
		}
		articleService.modifierRef(article, ref);
		articleService.modifierDesignation(article, designation);
		articleService.modifierPrix(article, price);
		List<Article> articles = new ArrayList<>();
		articles.add(article);
		menuService.getAllArticles(articles);
	}

	@Override
	public void deleteArticle() 
	{
		Integer choice = scanner.nextInt();
		if (choice == 0)
		{
			menuService.articleMenu();
		}
		else
		{
			Article article = articleService.recupererArticleParId(choice);
			Boolean isSuccess = articleService.supprimerArticle(article);
			menuService.deleteArticle(isSuccess);
		}
	}

	@Override
	public void deleteArticle2() 
	{
		scanner.nextInt();
		menuService.articleMenu();
	}

	@Override
	public void bonMenu() 
	{
		Integer choice = scanner.nextInt();
		if (choice == 1) 
		{
			menuService.addBon();
		}
		else if (choice == 2)
		{
			menuService.getAllBons();
		}
		else if (choice == 3)
		{
			menuService.getAllFournisseurBons();
		}
		else if (choice == 4)
		{
			menuService.getOneBon();
		}
		else if (choice == 5)
		{
			menuService.updateBon();
		}
		else if (choice == 6)
		{
			menuService.deleteBon();
		}
		else if (choice == 0)
		{
			menuService.mainMenu();
		}
		else
		{
			menuService.bonMenu();
		}
	}

	@Override
	public void creerBon() 
	{
		Fournisseur fournisseur = null;
		while (fournisseur == null)
		{
			Integer fournisseurID = scanner.nextInt();
			if (fournisseurID == 0)
			{
				menuService.articleMenu();
			}
			fournisseur = fournisseurService.recupererFournisseurParId(fournisseurID);
			if (fournisseur == null)
			{
				System.out.println("Fournisseur introuvable");
				System.out.println("Retapez l'ID du fournisseur");
			}
		}
		System.out.println(fournisseur);
		Integer numero = scanner.nextInt();
		if (numero == 0)
		{
			menuService.bonMenu();
		}
		System.out.println("Numero : " + numero);
		Integer delai = scanner.nextInt();
		if (delai == 0)
		{
			menuService.bonMenu();
		}
		System.out.println("Delai: " + delai);
		Integer day = scanner.nextInt();
		if (day == 0)
		{
			menuService.bonMenu();
		}
		System.out.println("Date de commande : " + day +"/MM/AAAA");
		Integer month = scanner.nextInt();
		if (month == 0)
		{
			menuService.bonMenu();
		}
		System.out.println("Date de commande : " + day +"/"+ month +"/AAAA");
		Integer year = scanner.nextInt();
		if (year == 0)
		{
			menuService.bonMenu();
		}
		System.out.println("Date de commande : " + day +"/"+ month +"/" + year);
		
		GregorianCalendar gDate = new GregorianCalendar(year, month+1, day);
	}

	@Override
	public void getOneBon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllBons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllFournisseurBons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBon(Bon bon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBon2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void finalize() throws Throwable 
	{
		scanner.close();
	}

	
}
