package fr.diginamic.jdbc.service.impl;

import java.util.Scanner;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.ArticleService;
import fr.diginamic.jdbc.service.FournisseurService;
import fr.diginamic.jdbc.service.InputService;
import fr.diginamic.jdbc.service.MenuService;

public class InputServiceImpl implements InputService 
{
	private FournisseurService fournisseurService = new FournisseurServiceImpl();
	private ArticleService articleService = new ArticleServiceImpl();
	private Scanner scanner = new Scanner(System.in);
	
	@Override
	public void mainMenu(MenuService menuService) 
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
	public void fournisseurMenu(MenuService menuService) 
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
	public void addFournisseur(MenuService menuService) 
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
	public void addFournisseur2(MenuService menuService) 
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
	public void listFournisseur(MenuService menuService) 
	{
		Integer choice = scanner.nextInt();
		if (choice == 0) 
		{
			menuService.fournisseurMenu();
		}

	}

	@Override
	public void oneFournisseur(MenuService menuService) 
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
	public void oneFournisseurFound(MenuService menuService, Fournisseur founisseur) 
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
	public void oneFournisseurNotFound(MenuService menuService) 
	{
		scanner.nextInt();
		menuService.oneFournisseur();
	}

	@Override
	public void updateFournisseur(MenuService menuService) 
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
	public void updateFournisseur2(MenuService menuService, Fournisseur fournisseur) 
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
	public void updateFournisseurName(MenuService menuService, Fournisseur fournisseur) 
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
	public void deleteFournisseur(MenuService menuService)
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
	public void deleteFournisseur2(MenuService menuService) 
	{
		Integer choice = scanner.nextInt();
		if (choice == 0)
		{
			menuService.fournisseurMenu();
		}
	}

	
	@Override
	public void listArticleByFournisseur(MenuService menuService, Fournisseur fournisseur) 
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
	public void creerArticle(MenuService menuService, Fournisseur fournisseur) 
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
	public void updateArticle(MenuService menuService, Fournisseur fournisseur)
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
	public void articleMenu(MenuService menuService) 
	{
		Integer choice = scanner.nextInt();
		if (choice == 1) 
		{
			menuService.addArticle();
		}
		else if (choice == 2)
		{
//			menuService.listArticle();
		}
		else if (choice == 3)
		{
//			menuService.listArticleByFournisseurID();
		}
		else if (choice == 4)
		{
//			menuService.getArticleById();
		}
		else if (choice == 5)
		{
//			menuService.getArticleById();
		}
		else if (choice == 6)
		{
//			menuService.getArticleById();
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
	public void creerArticle(MenuService menuService) 
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
	public void updateArticle(MenuService menuService) 
	{
		Article article = null;
		Integer choice = scanner.nextInt();
		if (choice == 0 )
		{
			menuService.mainMenu();
		}
		while (article == null)
		{
			article = articleService.recupererArticleParId(choice);
			if (article == null)
			{
				System.out.println("Article introuvable");
				System.out.println("Veuillez resaisir l'ID d'un article");
			}
		}
		
		// switch au menu du réel update article
	}

	@Override
	protected void finalize() throws Throwable 
	{
		scanner.close();
	}
	
}
