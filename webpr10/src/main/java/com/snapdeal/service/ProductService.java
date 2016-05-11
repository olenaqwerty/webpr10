package com.snapdeal.service;

import java.math.BigDecimal;
import java.util.List;

import com.snapdeal.model.Product;
import com.snapdeal.model.StarRatingFormDto;

public interface ProductService extends GenericService<Product, Integer> {

	int countAllPhones();

	List<Product> getProductByPriceRange(BigDecimal from, BigDecimal to);

	void setStarRating(StarRatingFormDto rating, Integer i);

	Integer getStarRatingValue(Integer productId);
	
	// List<Product> getProductsByCategory(String category);

}
