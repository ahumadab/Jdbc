package fr.diginamic.jdbc.service;

import fr.diginamic.jdbc.entites.Fournisseur;

public interface InputService 
{
	void mainMenu(MenuService menuService);
	
	void fournisseurMenu(MenuService menuService);
	void listFournisseur(MenuService menuService);
	void addFournisseur(MenuService menuService);
	void addFournisseur2(MenuService menuService);
	void oneFournisseur(MenuService menuService);
	void oneFournisseurFound(MenuService menuService, Fournisseur founisseur);
	void oneFournisseurNotFound(MenuService menuService);
	void updateFournisseur(MenuService menuService);
	void updateFournisseur2(MenuService menuService, Fournisseur fournisseur);
	void updateFournisseurName(MenuService menuService, Fournisseur fournisseur);
}
