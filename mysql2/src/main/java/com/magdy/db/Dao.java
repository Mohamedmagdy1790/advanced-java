package com.magdy.db;

import java.util.List;
import java.util.Optional;


//generic interface

public interface Dao<T> {
	void save(T t);
	Optional<T> findById(int id);
	void update(T t);
	void delete(T t);
	List<T> getAll();
	}