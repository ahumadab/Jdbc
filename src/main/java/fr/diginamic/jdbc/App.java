package fr.diginamic.jdbc;

import java.util.Scanner;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.RequetesFournisseur;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.service.FournisseurService;
import fr.diginamic.jdbc.service.MenuService;
import fr.diginamic.jdbc.service.impl.FournisseurServiceImpl;
import fr.diginamic.jdbc.service.impl.MenuServiceImpl;

/**
 * @author christophe Germain
 * 
 * Programme principal 
 * 
 * Objectif du programme :
 * 
 * Gérer des Bons de commande d'Articles
 * 
 * 1 - CRUD Fournisseur
 * 2 - CRUD Article
 * 3 - CRUD Bon
 * 4 - Gérer des Compo pour faire le lien entre un article et un bon avec une qté
 * 
 *  En reprenant les consignes des TP 4 - 5 - 6
 *  
 *  Gérer un menu avec l'utilisation de la classe scanner pour pouvoir choisir
 *  1 Gérer Fournisseur
 *  2 Gérer Article
 *  3 Gérer Bon
 *  4 Créer lien Promo (on aura directement la possibilité de saisir le nom de l'article
 *  , le numéro du bon et de la qté )
 *  
 *  
 *  Sous Menus des choix 1 2 3
 *  1 Créer
 *  2 Modifier (demander le nom ou le numéro (pour le bon) )
 *  3 Supprimer (demander le nom ou le numéro (pour le bon) )
 *  4 Liste Compléte
 *  5 Visualisation d'un élément (demander le nom ou le numéro (pour le bon) )
 *  
 *  (pour la création : saisir les informations correspondantes aux rubriques 
 *  de la table correspondante )
 *  
 *  Gérer les Dao et les services pour répondre à la gestion des menus 
 *  
 *   La validation des informations se fait par la touche Entrée 
 **/
public class App {
	
	private static MenuService menuService = new MenuServiceImpl();
	private static FournisseurService fs = new FournisseurServiceImpl();
	/**
	 * Point principal à gérer pour notre TP
	 * @param args tableau de String en pramètre facultatif 
	 */
	public static void main(String[] args) throws Exception
	{
		
		menuService.display();


	}
	
	
}
