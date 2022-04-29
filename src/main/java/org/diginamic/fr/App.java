package org.diginamic.fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/comptam02","root","");
			System.out.println(connection.getCatalog());
			System.out.println(connection.getClientInfo());
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
