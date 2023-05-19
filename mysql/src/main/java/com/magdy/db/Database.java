package com.magdy.db;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Database {
	
	
	private void Database(){};
	private static final String  URL ="jdbc:mysql://localhost:3306/people?serverTimezone=UTC";
	private Connection conn;
  
	private static Database db =new Database();
	
	public static Database instance() {
		
		return db;
	}
	
	
	public void connect() throws SQLException {
		
		var conn=DriverManager.getConnection(URL,"root","hello");
		
	}
	

}
