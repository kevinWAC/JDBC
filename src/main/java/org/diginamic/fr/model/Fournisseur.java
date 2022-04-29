package org.diginamic.fr.model;

/**
 * Description de la Tablez Fournisseur par une Classe
 * Que nous utiliserons de la façon manuelle
 * @author ulreich
 *
 */

public class Fournisseur {
	private Integer id;
	private String nom;
	
	public Fournisseur(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
