package com.magdy.db;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao{
	
	@Override
	public void save(User t)   {
		// TODO Auto-generated method stub
		
		var sql =("insert into user (name) values(?)");
		var conn=(Database.instance()).getconnection();
		
		
		
		try {
			var stmt =conn.prepareStatement(sql);
			
			stmt.setString(1,t.getName());
			stmt.executeUpdate();
			stmt.close();
			
			
			
			
		} catch (SQLException e) {
			throw new DaoException(e);			
		}
		
		

	}

	

	@Override
	public Optional<User> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
