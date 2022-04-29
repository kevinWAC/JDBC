package org.diginamic.fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) {
		try {
			TestConnexionJdbc.getConnection();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static Connection getConnection() throws Exception {
		ResourceBundle databaseConf = ResourceBundle.getBundle("dataBase");
		
		Class.forName(databaseConf.getString("database.driver"));
		//return DriverManager.getConnection("jdbc:mysql://localhost:3306/comptam02","root","");
		return DriverManager.getConnection(databaseConf.getString("database.url"),
											databaseConf.getString("database.user"),
											databaseConf.getString("database.password"));
	}

}
