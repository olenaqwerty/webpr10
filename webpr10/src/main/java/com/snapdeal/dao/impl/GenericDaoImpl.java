package com.snapdeal.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snapdeal.dao.GenericDao;
import com.snapdeal.model.Product;

@Repository
public abstract class GenericDaoImpl<T, N extends Number> implements GenericDao<T, N> {

	@Autowired
	SessionFactory sessionFactory;

	protected Class<? extends T> daoType;

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T create(T t) {
		getSession().save(t);
		return t;
	}

	protected Session getSession() {
		return this.getSessionFactory().getCurrentSession();
	}

	@Override
	public T read(int id) {
		return getSessionFactory().getCurrentSession().get(this.daoType, id);
	}

	@Override
	public void update(T t) {
		getSessionFactory().getCurrentSession().update(t);
	}

	@Override
	public void delete(T t) {
		getSessionFactory().getCurrentSession().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAll() {
		return getSessionFactory().getCurrentSession().createCriteria(this.daoType).list();

	}
}
