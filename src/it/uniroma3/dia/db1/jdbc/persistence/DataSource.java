package it.uniroma3.dia.db1.jdbc.persistence;

import java.sql.*;

public class DataSource {
	//indirizzo DB
	private String dbURI = "jdbc:postgresql://localhost/university";
	//user del DB
	private String user = "postgres";
	//pass del DB
	private String password = "siw";

	//metodo che ritorna una connessione
	public Connection getConnection()  {
		Connection connection = null;
		//carica driver e si connette
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbURI,user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
