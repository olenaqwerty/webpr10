package com.snapdeal.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.snapdeal.dao.ProductDao;
import com.snapdeal.model.Product;
import com.snapdeal.model.StarRatingFormDto;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product, Integer> implements ProductDao {

	@Override
	public int countAllPhones() {
		return ((Long) getSession()
				.createQuery(
						"select count(*) from " + this.daoType.getName() + " where category.name = 'phones'")
				.uniqueResult()).intValue();
	}

	@Override
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
