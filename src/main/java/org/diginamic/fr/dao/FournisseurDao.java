package org.diginamic.fr.dao;

import java.util.*;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.model.Fournisseur;

import java.sql.*;


/**
 * Cette Classe va me permettre de lire en JDBC la table FOurnisseur
 * et aussi d'avoir les méthodes CRUD et d'obtenir des objets de type Fournisseur
 * @author ulreich
 *
 */
public class FournisseurDao {
	/**
	 * Retourn la liste des Fournisseurs de ma base de donnée
	 * @return
	 */
	public static List<Fournisseur> getAll() {
		Connection connection = null;
		List<Fournisseur> listeDesFournisseurs = new ArrayList<Fournisseur>();
		try {
			 connection = TestConnexionJdbc.getConnection();
			 Statement stat = connection.createStatement();
			 ResultSet curseur = stat.executeQuery("SELECT * FROM Fournisseur");
			 while(curseur.next()) {
				 /**
				  * Je veux récupérer la colonne ID et la colonne Nom de ma table
				  * la stocker dans objet de type Fournisseur
				  * et la mettre dans notre Liste
				  */
				 Fournisseur fo = new Fournisseur(curseur.getInt("ID"), curseur.getString("NOM"));
				 listeDesFournisseurs.add(fo);
			 }
			 curseur.close();
			 stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null) connection.close();				
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return listeDesFournisseurs;
	}
	
	public static void insertFournisseur() {
		Connection connection = null;
		try {
			 connection = TestConnexionJdbc.getConnection();
			 Statement stat = connection.createStatement();
			 String sql = "INSERT INTO fournisseur VALUES (4, 'La Maison De La Peinture' )";
			 stat.executeUpdate(sql);
			 stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null) connection.close();				
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
	public static void updateFournisseur() {
		Connection connection = null;
		try {
			 connection = TestConnexionJdbc.getConnection();
			 Statement stat = connection.createStatement();
			 String sql = "UPDATE fournisseur SET nom = 'La Maison des Peintures' WHERE id = 4";
			 stat.executeUpdate(sql);
			 stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null) connection.close();				
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
	
	public static void deleteFournisseur() {
		Connection connection = null;
		try {
			 connection = TestConnexionJdbc.getConnection();
			 Statement stat = connection.createStatement();
			 String sql = "DELETE FROM fournisseur WHERE id = 4";
			 stat.executeUpdate(sql);
			 stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null) connection.close();				
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
	
	
}
