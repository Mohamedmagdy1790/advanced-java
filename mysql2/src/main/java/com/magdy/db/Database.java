package com.magdy.db;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Database db = new Database();
	//private static final String URL = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC"; //connct to database server
	private Connection conn;

	public static Database instance() {
		return db;
	}

	private Database() {

	}

	public void connect(Properties prop) throws SQLException {
		String server = prop.getProperty("server");
		String port = prop.getProperty("port");
		String database = prop.getProperty("database");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		String URL =String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC",server,port,database);
		System.out.println(URL);
		conn = DriverManager.getConnection(URL, user, password);
	}
	
	public Connection getconnection(){
		return conn;
	}

	public void close() throws SQLException {
		conn.close();
	}
}