package org.diginamic.jdbc.dao;

import java.util.List;

public interface ArticleDao<T> {
	List<T> extraire();
	void insert(T data);
	int update(T ancienData, T nouveauData);
	boolean delete(T data);
}
