package fr.diginamic.jdbc.service.impl;

import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.DisplayService;
import fr.diginamic.jdbc.service.FournisseurService;

public class DisplayServiceImpl implements DisplayService 
{
	private FournisseurService fournisseurService = new FournisseurServiceImpl();

	@Override
	public void mainMenu() 
	{

		System.out.println("---------------------");
		System.out.println();
		System.out.println("Salut mon pote");
		System.out.println();
		System.out.println("Veuillez selectionner votre choix: ");
		System.out.println("1 - Gérer Fournisseur");
		System.out.println("2 - Gérer Article");
		System.out.println("3 - Gérer Bon");
	}

	@Override
	public void fournisseurMenu() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Gérer Fournisseur");
		System.out.println();
		System.out.println("Veuillez selectionner votre choix: ");
		System.out.println("1 - Ajouter un nouveau Fournisseur");
		System.out.println("2 - Voir tous les Fournisseurs");
		System.out.println("3 - Voir un Fournisseur");
		System.out.println("4 - Modifier un Fournisseur");
		System.out.println();
		System.out.println("0 - Back");
	}
	
	
	@Override
	public void addFournisseur() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer le nom du nouveau fournisseur");
		System.out.println();
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void addFournisseur2(Fournisseur fournisseur) 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Fournisseur enregistré");
		System.out.println();
		System.out.println(fournisseur);
		System.out.println();
		System.out.println("1 - Ajouter un nouveau Fournisseur");
		System.out.println("0 - Back");
	}
	
	@Override
	public void askForIdFournisseur() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer l'ID du fournisseur");
		System.out.println();
		System.out.println("0 - Back");
	}
	
	@Override
	public void oneFournisseurFound(Fournisseur fournisseur) 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Fournisseur trouvé");
		System.out.println();
		System.out.println(fournisseur);
		System.out.println();		
		System.out.println("1 - Gérer ses informations");		
		System.out.println("2 - Gérer ses articles");		
		
		System.out.println("0 - Back");
	}

	@Override
	public void oneFournisseurNotFound() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Fournisseur introuvable");
		System.out.println();
		System.out.println();
		System.out.println("0 - Back");
	}

	public void listFournisseur()
	{
		System.out.println("---------------------");
		System.out.println();
		fournisseurService.recupererFournisseur()
			.stream()
			.forEach(fournisseur -> System.out.println(fournisseur));
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void updateFournisseur(Fournisseur fournisseur) 
	{
		System.out.println("Fournisseur trouvé");
		System.out.println();
		System.out.println(fournisseur);
		System.out.println();		
		System.out.println("1 - Modifier le nom");		
		System.out.println();
		System.out.println("0 - Back");	
	}

	@Override
	public void updateFournisseur2() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer le nouveau nom de fournisseur");
		System.out.println();
		System.out.println("0 - Back");
	}
	
	

	
}
