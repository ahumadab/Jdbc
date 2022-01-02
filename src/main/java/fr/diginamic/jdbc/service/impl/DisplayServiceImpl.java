package fr.diginamic.jdbc.service.impl;

import java.util.List;

import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.ArticleService;
import fr.diginamic.jdbc.service.BonService;
import fr.diginamic.jdbc.service.DisplayService;
import fr.diginamic.jdbc.service.FournisseurService;

public class DisplayServiceImpl implements DisplayService 
{
	private FournisseurService fournisseurService = new FournisseurServiceImpl();
	private ArticleService articleService = new ArticleServiceImpl();
	private BonService bonService = new BonServiceImpl();
	
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
		System.out.println("0 - Quitter");
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
		System.out.println("5 - Supprimer un Fournisseur");
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
		System.out.println("3 - Supprimer le fournisseur");	
		System.out.println();	
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

	@Override
	public void deleteFournisseur() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer l'ID du fournisseur à supprimer");
		System.out.println();
		System.out.println("Attention, sa suppression entrainera la suppression de ses articles, bon et compo. Action définitive !");
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void deleteFournisseur2(Boolean success) 
	{
		System.out.println("---------------------");
		System.out.println();
		if (success)
		{
			System.out.println("Le Fournisseur à bien été supprimé");
			
		}
		else
		{
			System.out.println("Une erreur à été survenue lors de la suppression du Fournisseur");
		}
		System.out.println();
		System.out.println("0 - Back");
	}

	
	@Override
	public void listArticle(Fournisseur fournisseur)
	{
		List<Article> articles = articleService.recupererArticlesDuFournisseur(fournisseur);
		System.out.println("---------------------");
		System.out.println();
		System.out.println(fournisseur);
		System.out.println();
		if (articles.isEmpty())
		{
			System.out.println("Pas d'articles");
		}
		else 
		{
			articles.stream().forEach(article -> System.out.println(article));
		}
		System.out.println();
		System.out.println("1 - Créer un article");
		System.out.println("2 - Modifier un article");
		System.out.println("3 - Supprimer un article");
		System.out.println("0 - Back");
	}

	@Override
	public void creerArticle(Fournisseur fournisseur) 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Création d'Article");
		System.out.println();
		System.out.println("Veuillez renseigner une Référence, Désignation(description) et le prix");
		System.out.println();
		System.out.println("0 - Back");
	}
	
	@Override
	public void creerArticle() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Création d'Article");
		System.out.println();
		System.out.println("Veuillez renseigner l'ID du fournisseur, une Référence, Désignation(description) et le prix");
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void updateArticle(Fournisseur fournisseur) 
	{
		List<Article> articles = articleService.recupererArticlesDuFournisseur(fournisseur);
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Modification d'Article");
		System.out.println();
		if (articles.isEmpty())
		{
			System.out.println("Il n'y a pas d'article à modifier");
		}
		else
		{
			articles.stream().forEach(article -> System.out.println(article));
			System.out.println();
			System.out.println("Veuillez entrer l'ID de l'article à modifier");
			System.out.println();
		}
		System.out.println("0 - Back");
	}

	@Override
	public void articleMenu() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Gérer Article");
		System.out.println();
		System.out.println("Veuillez selectionner votre choix: ");
		System.out.println("1 - Ajouter un nouvel Article");
		System.out.println("2 - Voir tous les Articles");
		System.out.println("3 - Voir tous les Articles d'un Fournisseur");
		System.out.println("4 - Voir un Article");
		System.out.println("5 - Modifier un Article");
		System.out.println("6 - Supprimer un Article");
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void updateArticle() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer l'ID de l'article à modifier");
		System.out.println();
	}

	@Override
	public void updateArticle(Article article) 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Modification d'Article");
		System.out.println();
		System.out.println(article);
		System.out.println();
		System.out.println("Veuillez renseigner une Référence, Désignation(description) et le prix");
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void deleteArticle() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer l'ID de l'article à supprimer");
		System.out.println();
		System.out.println("Attention, sa suppression entrainera la suppression de ses compos. Action définitive !");
		System.out.println();
		System.out.println("0 - Back");		
	}

	@Override
	public void deleteArticle(Boolean isSuccess) 
	{
		System.out.println("---------------------");
		System.out.println();
		if (isSuccess)
		{
			System.out.println("L'Article à bien été supprimé");
			
		}
		else
		{
			System.out.println("Une erreur à été survenue lors de la suppression de l'Article");
		}
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void getAllArticle() 
	{
		List<Article> articles = articleService.recupererArticles();
		System.out.println("---------------------");
		System.out.println();
		if (articles.isEmpty())
		{
			System.out.println("Pas d'article trouvé !");
		}
		else 
		{
			articles.stream().forEach(article -> System.out.println(article));
		}
		System.out.println();
		System.out.println("0 - Back");		
	}

	@Override
	public void getAllArticle(List<Article> articles) 
	{
		System.out.println("---------------------");
		System.out.println();
		if (articles.isEmpty())
		{
			System.out.println("Pas d'article trouvé !");
		}
		else 
		{
			articles.stream().forEach(article -> System.out.println(article));
		}
		System.out.println();
		System.out.println("0 - Back");	
	}

	@Override
	public void askForArticleId() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer l'ID de l'Article");
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void bonMenu() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Gérer Bon");
		System.out.println();
		System.out.println("Veuillez selectionner votre choix: ");
		System.out.println("1 - Ajouter un nouveau Bon");
		System.out.println("2 - Voir tous les Bons");
		System.out.println("3 - Voir tous les Bons d'un Fournisseur");
		System.out.println("4 - Voir un Bon");
		System.out.println("5 - Modifier un Bon");
		System.out.println("6 - Supprimer un Bon");
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void creerBon() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Création de Bon");
		System.out.println();
		System.out.println("Veuillez renseigner l'ID du fournisseur, un Numéro, Delai et la date de commande (JJ/MM/AAAA)");
		System.out.println();
		System.out.println("0 - Back");
	}
	@Override
	public void askForBonId() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer l'ID du bon");
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void getAllBons() 
	{
		List<Bon> bons = bonService.recupererBon();
		System.out.println("---------------------");
		System.out.println();
		if (bons.isEmpty())
		{
			System.out.println("Pas d'article trouvé !");
		}
		else 
		{
			bons.stream().forEach(bon -> System.out.println(bon));
		}
		System.out.println();
		System.out.println("0 - Back");	
	}

	@Override
	public void getAllBons(List<Bon> bons) 
	{
		System.out.println("---------------------");
		System.out.println();
		if (bons.isEmpty())
		{
			System.out.println("Pas d'article trouvé !");
		}
		else 
		{
			bons.stream().forEach(bon -> System.out.println(bon));
		}
		System.out.println();
		System.out.println("0 - Back");	
	}

	@Override
	public void updateBon() 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer l'ID du bon à modifier");
		System.out.println();
	}

	@Override
	public void updateBon(Bon bon) 
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Modification de Bon");
		System.out.println();
		System.out.println(bon);
		System.out.println();
		System.out.println("Veuillez renseigner un Numéro, Delai et la date de commande (JJ/MM/AAAA)");
		System.out.println();
		System.out.println("0 - Back");
	}

	@Override
	public void deleteBon()
	{
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Veuillez entrer l'ID du bon à supprimer");
		System.out.println();
		System.out.println("Attention, sa suppression entrainera la suppression de ses compos. Action définitive !");
		System.out.println();
		System.out.println("0 - Back");	
	}

	@Override
	public void deleteBon(Boolean isSuccess) 
	{
		System.out.println("---------------------");
		System.out.println();
		if (isSuccess)
		{
			System.out.println("Le Bon à bien été supprimé");
			
		}
		else
		{
			System.out.println("Une erreur à été survenue lors de la suppression du Bon");
		}
		System.out.println();
		System.out.println("0 - Back");
	}

	
	
	

	
}
