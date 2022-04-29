package fr.diginamic.jdbc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.model.Fournisseur;
import org.diginamic.jdbc.dao.FournisseurDao;

import java.sql.PreparedStatement;
import java.sql.Connection;

public class FournisseurIdao implements FournisseurDao<Fournisseur> {

	Connection connexion = null;
	
	public FournisseurIdao() throws Exception {
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
	public List<Fournisseur> extraire() {
		List<Fournisseur> listeDesFournisseurs = new ArrayList<Fournisseur>();
		try {
			PreparedStatement stat = connexion.prepareStatement("SELECT ID, NOM FROM FOURNISSEUR");
			ResultSet curseur = stat.executeQuery();
			while (curseur.next()) {
				Fournisseur fo = new Fournisseur(curseur.getInt("ID"), curseur.getString("NOM"));
				listeDesFournisseurs.add(fo);

			}
			curseur.close();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		return listeDesFournisseurs;
	}

	@Override
	public void insert(Fournisseur data) {
		try {
			String sql = "INSERT INTO fournisseur(ID,NOM) VALUES (?, ?)";
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, data.getId());
			stat.setString(2, data.getNom());
			stat.executeUpdate();
			stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public int update(Fournisseur ancienData, Fournisseur nouveauData) {
		try {
			String sql = "UPDATE fournisseur SET NOM=? WHERE ID=?";
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setString(1, nouveauData.getNom());
			stat.setInt(2, ancienData.getId());
			stat.executeUpdate();
			stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return 0;
	}

	@Override
	public boolean delete(Fournisseur data) {
		try {
			String sql = "DELETE FROM fournisseur WHERE ID=?";
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, data.getId());
			stat.executeUpdate();
			stat.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

}
