package fr.diginamic.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.diginamic.jdbc.dao.ArticleDao;

import fr.diginamic.jdbc.dao.impl.ArticleDaoJdbc;
import fr.diginamic.jdbc.entites.Article;

public class TestJdbcArticles {

	public static void main(String[] args) {
		try {
			ArticleDaoJdbc adj =  new ArticleDaoJdbc();
//			insert(adj);
//			discount(adj);
//			getAffiche(adj);
			moyenne(adj);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	
	public static void getAffiche(ArticleDao<Article> o) {
		o.extraire().forEach(ar ->System.out.println("REF : " + ar.getRef() + " DESIGNATION : " + ar.getDesignation() + " PRIX : " + ar.getPrix()));

	}


	public static void insert(ArticleDao<Article> o) {
		
		List<Article> articles = new ArrayList<>();
		articles.add(new Article(11, "PB10", "Peinture blanche 1L", 12.5, 4));
		articles.add(new Article(12, "PR11", "Peinture rouge mate 1L", 15.5, 4));
		articles.add(new Article(13, "PN10", "Peinture noire laquée 1L", 17.8, 4));
		articles.add(new Article(14, "PB11", "Peinture bleue mate 1L", 15.5, 4));
		
		for (Article article : articles) {
			o.insert(article);			
		}

	}

	public static void discount(ArticleDaoJdbc o) {
		o.discount("mat");
	}
	
	public static void moyenne(ArticleDaoJdbc o) {
		o.moyenne();
	}
}
