package fr.diginamic.jdbc.service.impl;

import java.util.Scanner;

import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.FournisseurService;
import fr.diginamic.jdbc.service.InputService;
import fr.diginamic.jdbc.service.MenuService;

public class InputServiceImpl implements InputService 
{
	private FournisseurService fournisseurService = new FournisseurServiceImpl();
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
			
		}
		else if (choice == 3)
		{
			
		}
		else
		{
			
		}
		scanner.close();
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
			System.out.println("WIP");
			menuService.oneFournisseurFound(founisseur);
		}
		else if (choice == 2)
		{
			System.out.println("WIP");
			menuService.oneFournisseurFound(founisseur);
		}
		else
		{
			menuService.oneFournisseurFound(founisseur);
		}
	}

	@Override
	public void oneFournisseurNotFound(MenuService menuService) 
	{
		Integer choice = scanner.nextInt();
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
	
	

}
