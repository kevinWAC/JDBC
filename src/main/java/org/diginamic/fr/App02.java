package org.diginamic.fr;

import java.util.List;

import org.diginamic.fr.dao.FournisseurDao;
import org.diginamic.fr.model.Fournisseur;

public class App02 {

	public static void main(String[] args) {
		List<Fournisseur> maliste = FournisseurDao.getAll();
		for(Fournisseur fo : maliste) {
			System.out.println("Id : " + fo.getId() + "Nom : " + fo.getNom());
		}

	}

}
