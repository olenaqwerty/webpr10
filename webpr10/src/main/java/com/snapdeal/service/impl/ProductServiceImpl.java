package com.snapdeal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snapdeal.dao.GenericDao;
import com.snapdeal.dao.ProductDao;
import com.snapdeal.model.Product;
import com.snapdeal.model.StarRatingFormDto;
import com.snapdeal.service.ProductService;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductService {

	private ProductDao productDao;

	public ProductServiceImpl() {
	}

	@Autowired
	public ProductServiceImpl(@Qualifier("productDaoImpl") GenericDao<Product, Integer> genericDao) {
		super(genericDao);
		this.productDao = (ProductDao) genericDao;
	}

	@Override
	@Transactional
	public int countAllPhones() {
		return this.productDao.countAllPhones();
	}

	@Override
	@Transactional
	public List<Product> getProductByPriceRange(BigDecimal low, BigDecimal high) {
		return productDao.getProductsByPriceRange(low, high);
	}

	@Override
	public void addStarRating(StarRatingFormDto rating) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public List<Product> getProductsByCategory(String category) {
	 * // TODO Auto-generated method stub return null; }
	 */

}
