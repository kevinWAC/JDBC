package fr.diginamic.jdbc;
import org.diginamic.fr.model.Fournisseur;
import org.diginamic.jdbc.dao.FournisseurDao;

import fr.diginamic.jdbc.dao.impl.FournisseurIdao;

public class UseFournisseurIdao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Utiliser la classe FournisseurIdao pour afficher la liste des fournisseurs
		 */
		try {
			FournisseurIdao foi =  new FournisseurIdao();
			//Affiche les fournisseurs
//			getAffiche(foi);
			//Crée un fournisseur
//			insert(foi);
			//Modifie un fournisseur
//			update(foi);
			//Supprime un fournisseur
			delete(foi);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.err.println(ex.getMessage());
		}
	}
	
	/**
	 * Méthode qui gère un objet de type FournisseurDao
	 */
	public static void getAffiche(FournisseurDao<Fournisseur> o) {
		o.extraire().forEach(fo ->System.out.println(fo.getNom()));
	}
	
	public static void insert(FournisseurDao<Fournisseur> o) {
		Fournisseur fournisseur = new Fournisseur(5, "Peintre Expert");
		o.insert(fournisseur);
	}
	
	public static void update(FournisseurDao<Fournisseur> o) {
		Fournisseur oldFournisseur = new Fournisseur(5, "Peintre Expert");
		Fournisseur newFournisseur = new Fournisseur(5, "Peinture Expert");
		o.update(oldFournisseur, newFournisseur);
	}
	
	public static void delete(FournisseurDao<Fournisseur> o) {
		Fournisseur fournisseur = new Fournisseur(5, "Peinture Expert");
		o.delete(fournisseur);
	}
}
