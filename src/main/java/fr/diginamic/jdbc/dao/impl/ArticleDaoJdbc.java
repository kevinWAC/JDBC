package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.model.Fournisseur;
import org.diginamic.jdbc.dao.ArticleDao;

import fr.diginamic.jdbc.entites.Article;

public class ArticleDaoJdbc implements ArticleDao<Article> {

Connection connexion = null;
	
	public ArticleDaoJdbc() throws Exception {
		connexion = TestConnexionJdbc.getConnection();
	}

	
	public void close() throws Exception {
		if (connexion != null && connexion.isClosed() == false) {
			connexion.close();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		close();
	}
		
	
	
	@Override
	public List<Article> extraire() {
		List<Article> listeArticles = new ArrayList<>();
		try {
			PreparedStatement stat = connexion.prepareStatement("SELECT * FROM ARTICLE");
			ResultSet curseur = stat.executeQuery();
			while (curseur.next()) {
				Article ar = new Article(
						curseur.getInt("ID"),
						curseur.getString("REF"),
						curseur.getString("DESIGNATION"),
						curseur.getDouble("PRIX"),
						curseur.getInt("ID_FOU")
						);
				listeArticles.add(ar);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listeArticles;
	}


	@Override
	public void insert(Article data) {
		try {
			String sql = "INSERT INTO article(ID,REF,DESIGNATION,PRIX,ID_FOU) VALUES (?,?,?,?,?)";
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, data.getId());
			stat.setString(2, data.getRef());
			stat.setString(3, data.getDesignation());
			stat.setDouble(4, data.getPrix());
			stat.setInt(5, data.getId_fou());
			stat.executeUpdate();
			stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}


	@Override
	public int update(Article ancienData, Article nouveauData) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean delete(Article data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public void discount(String keyword) {
		try {
			String sql = "UPDATE article SET prix = prix * 0.75  WHERE designation LIKE ?";
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setString(1, '%' + keyword + '%');
			stat.executeUpdate();
			stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}


	public void moyenne() {
		try {
			String sql = "SELECT AVG(prix) as moyenne FROM ARTICLE ";
			PreparedStatement stat = connexion.prepareStatement(sql);
			ResultSet curseur = stat.executeQuery();
	
			while (curseur.next()) {
				String m = curseur.getString("moyenne");
				System.out.println(m);
			}
			curseur.close();
			stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}


}
