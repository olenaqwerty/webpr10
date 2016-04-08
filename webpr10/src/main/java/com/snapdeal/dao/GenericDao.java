package com.snapdeal.dao;

import java.util.List;

import com.snapdeal.model.Product;

public interface GenericDao<T, N extends Number> {
	
	T create(T p);

	T read(int id);

	void update(T p);

	void delete(T p);

	List<Product> getAll();
}
