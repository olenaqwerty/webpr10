package com.snapdeal.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.snapdeal.dao.ProductDao;
import com.snapdeal.model.Product;
import com.snapdeal.model.StarRatingFormDto;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product, Integer> implements ProductDao {

	@Override
	@Transactional
	public int countAllPhones() {
		return ((Long) getSession()
				.createQuery("select count(*) from " + this.daoType.getName() + " where category.name = 'phones'")
				.uniqueResult()).intValue();
	}

	@Override
	@Transactional
	public List<Product> getProductsByPriceRange(BigDecimal low, BigDecimal high) {
		// getSession().createQuery("from " + this.daoType.getName() + " where
		// product.productPrice => " + low + "AND < " + high);

		Query query = getSession().createQuery("from " + this.daoType.getSimpleName()
				+ " product where product.productPrice >= :param1 AND product.productPrice <= :param2");
		query.setParameter("param1", low);
		query.setParameter("param2", high);
		List<Product> products = query.list();
		return products;
	}

	public void addStarRating(StarRatingFormDto rating) {
	}

	@Override
	@Transactional
	public Integer getStarRatingSum(Integer productId) {
		Query query = getSession().createQuery(
				"select starRatingSum from " + this.daoType.getSimpleName() + " where product_id = :param1");
		query.setParameter("param1", productId);
		// TOASK: is it worth doing try catch for class cast exception here?
		// this exception will arise if in bd wrong value is stored
		Integer i = (Integer) query.uniqueResult();
		return i;
	}
	
	
	@Override
	@Transactional
	public void setRatingSum(Integer starRatingSum, Integer productId) {
		 Product product = (Product) getSession().get(Product.class, productId);
		 product.setStarRatingSum(starRatingSum);
		 getSession().update(product);
	}

	@Override
	@Transactional
	public Integer getNumOfStarRatingVotes(Integer productId) {
		Query query = getSession().createQuery(
				"select numOfStarRatingVotes from " + this.daoType.getSimpleName() + " where product_id = :param1");
		query.setParameter("param1", productId);
		// TOASK: is it worth doing try catch for class cast exception here?
		// this exception will arise if in bd wrong value is stored
		Integer i = (Integer) query.uniqueResult();
		return i;
	}

	@Override
	@Transactional
	public void setNumOfStarRatingVotes(Integer numOfStarRatingVotes, Integer productId) {
		Product product = (Product) getSession().get(Product.class, productId);
		 product.setNumOfStarRatingVotes(numOfStarRatingVotes);
		 getSession().update(product);
	}

	/*
	 * ((Integer) getSession().createQuery("select count(*) from "
	 * +this.daoType.getName() + "INNER JOIN Category"
	 * ).uniqueResult()).intValue();
	 * 
	 * "from Product where category.categoryName = 'phones'";
	 */

	/*
	 * @SuppressWarnings("unchecked") public List<Product>
	 * getProductsByPriceRange(BigDecimal low, BigDecimal high) { return
	 * (List<Product>)
	 * super.getEntityManager().createNamedQuery("Product.getByPriceRange")
	 * .setParameter("low", low).setParameter("high", high).getResultList(); }
	 */

}
