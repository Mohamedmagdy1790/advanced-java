package com.magdy.db;
import java.util.Optional;

import java.sql.SQLException;
import java.util.List;

public class App {
	public static void main(String[] args) {
		var db = Database.instance();
		
		try {
			db.connect();
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