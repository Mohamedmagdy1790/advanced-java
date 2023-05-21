package com.magdy.db;
import java.util.Optional;
import java.util.Properties;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class App {
	public static void main(String[] args) {
		
		
		Properties prob =new Properties();
		
		String env=System.getProperty("env");
		
		
		if(env ==null) {
			env="dev";
		}
		
		String configprobrties =String.format("/config/db.%s.properties", env);
		System.out.println(configprobrties);
		try {
			prob.load(App.class.getResourceAsStream(configprobrties));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		var db = Database.instance();
		
		
		try {
			db.connect(prob);
		} catch (SQLException e) {
			System.out.println("Cannot connect to database.");
		}
		
		
		System.out.println("Connected");
		
		UserDao userDao = new UserDaoImpl();
		
		
		//userDao.save(new User("Mars"));
		//userDao.save(new User("Mercury"));
		//userDao.save(new User("Neptune"));
		//userDao.save(new User("mohamed"));
		List<User> users= userDao.getAll();
		
		users.forEach(System.out::println);

		Optional<User> user=userDao.findById(7);
		//System.out.println(user);
		
		//User t =new User(4,"mohamed");
		//userDao.delete(t);
		userDao.update(new User(2,"abdelrahamanmagdy"));
		
		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close database connection.");
		}
		
	}
}