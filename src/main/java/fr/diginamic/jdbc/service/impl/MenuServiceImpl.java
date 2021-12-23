package fr.diginamic.jdbc.service.impl;

import java.util.Scanner;

import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.DisplayService;
import fr.diginamic.jdbc.service.FournisseurService;
import fr.diginamic.jdbc.service.InputService;
import fr.diginamic.jdbc.service.MenuService;

public class MenuServiceImpl implements MenuService 
{
	private Scanner scanner = new Scanner(System.in);
	
	private InputService inputService = new InputServiceImpl();
	private DisplayService displayService = new DisplayServiceImpl();
	
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
		inputService.mainMenu(this);
	}

	@Override
	public void fournisseurMenu()
	{
		displayService.fournisseurMenu();
		inputService.fournisseurMenu(this);
	}
	
	public void addfournisseur()
	{
		displayService.addFournisseur();
		inputService.addFournisseur(this);
	}
	
	public void addfournisseur2(Fournisseur fournisseur)
	{
		displayService.addFournisseur2(fournisseur);
		inputService.addFournisseur2(this);
	}

	@Override
	public void fournisseurList() 
	{
		displayService.listFournisseur();
		inputService.listFournisseur(this);
	}

	@Override
	public void oneFournisseur() 
	{
		displayService.askForIdFournisseur();
		inputService.oneFournisseur(this);
	}

	@Override
	public void oneFournisseurFound(Fournisseur fournisseur) 
	{
		displayService.oneFournisseurFound(fournisseur);
		inputService.oneFournisseurFound(this, fournisseur);
	}

	@Override
	public void oneFournisseurNotFound() 
	{
		displayService.oneFournisseurNotFound();
		inputService.oneFournisseurNotFound(this);
	}
	

	@Override
	public void updateFournisseur() 
	{	
		displayService.askForIdFournisseur();
		inputService.updateFournisseur(this);
	}
	
	@Override
	public void updateFournisseur(Fournisseur fournisseur) 
	{	
		displayService.updateFournisseur(fournisseur);
		inputService.updateFournisseur2(this, fournisseur);
	}

	@Override
	public void updateFournisseurNom(Fournisseur fournisseur) 
	{
		displayService.updateFournisseur2();
		inputService.updateFournisseurName(this, fournisseur);
	}

	@Override
	public void afficherArticle() 
	{
		// TODO Auto-generated method stub
		
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
