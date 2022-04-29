package org.diginamic.jdbc.dao;

import java.util.List;

import org.diginamic.fr.model.Fournisseur;

/**
 * FournisseurDao est une interface Générique pour toutes les futures claxses de type FournisseurDao
 * @author ulrei
 *
 * @param <T>
 */
public interface FournisseurDao<T> {
	List<T> extraire();
	void insert(T data);
	int update(T ancienData, T nouveauData);
	boolean delete(T data);
}
