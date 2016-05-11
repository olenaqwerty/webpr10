package com.snapdeal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
	public int countAllPhones() {
		return this.productDao.countAllPhones();
	}

	@Override
	public List<Product> getProductByPriceRange(BigDecimal low, BigDecimal high) {
		return productDao.getProductsByPriceRange(low, high);
	}

	@Override
	public void setStarRating(StarRatingFormDto rating, Integer productId) {
		Integer newRatingSum = productDao.getStarRatingSum(productId) + rating.getStarRatingValue();
		Integer newNumOfStarRatingVotes = productDao.getNumOfStarRatingVotes(productId) + 1;
		productDao.setRatingSum(newRatingSum, productId);
		productDao.setNumOfStarRatingVotes(newNumOfStarRatingVotes, productId);
	}

	@Override
	public Integer getStarRatingValue(Integer productId) {
		return Math.round(productDao.getStarRatingSum(productId) + productDao.getNumOfStarRatingVotes(productId));
	}

	/*
	 * @Override public List<Product> getProductsByCategory(String category) {
	 * // TODO Auto-generated method stub return null; }
	 */

}
