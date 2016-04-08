package com.snapdeal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snapdeal.dao.GenericDao;
import com.snapdeal.model.Product;
import com.snapdeal.service.GenericService;

@Service
public abstract class GenericServiceImpl<T, N extends Number> implements GenericService<T, N> {

	private GenericDao<T, N> genericDao;

	public GenericServiceImpl() {
	}

	public GenericServiceImpl(GenericDao<T, N> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	@Transactional
	public T create(T p) {
		return this.genericDao.create(p);
	}

	@Override
	@Transactional
	public T read(int id) {
		return this.genericDao.read(id);
	}

	@Override
	@Transactional
	public void update(T p) {
		this.genericDao.update(p);
	}

	@Override
	@Transactional
	public void delete(T p) {
		this.genericDao.delete(p);

	}

	@Override
	@Transactional
	public List<Product> getAll() {
		return this.genericDao.getAll();
	}

}
