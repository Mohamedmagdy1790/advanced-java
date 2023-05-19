package com.magdy.db;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User t) {
		// TODO Auto-generated method stub

		var sql = ("insert into user (name) values(?)");
		var conn = (Database.instance()).getconnection();

		try {
			var stmt = conn.prepareStatement(sql);

			stmt.setString(1, t.getName());
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public Optional<User> findById(int id) {

		var conn = (Database.instance()).getconnection();

		try {
			var stmt = conn.prepareStatement("select * from user where id =?");

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				String name = rs.getString("name");

				User user = new User(id, name);
				return Optional.of(user);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return Optional.empty();
	}

	@Override
	public void update(User t) {
		var conn = (Database.instance()).getconnection();

		try {
			var stmt = conn.prepareStatement("update user set name = ? where id =?");

			stmt.setInt(2, t.getId());
			stmt.setString(1, t.getName());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public void delete(User t) {
		var conn = (Database.instance()).getconnection();

		try {
			var stmt = conn.prepareStatement("delete from user where id =?");

			stmt.setInt(1, t.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}
	
	
	
	
	

	@Override
	public List<User> getAll() {

		var sql = ("select * from user");
		var conn = (Database.instance()).getconnection();
		List<User> users = new ArrayList<>();

		try {
			var stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");

				users.add(new User(id, name));
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return users;
	}

}
