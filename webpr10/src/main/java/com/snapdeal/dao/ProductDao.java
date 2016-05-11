package com.snapdeal.dao;

import java.math.BigDecimal;
import java.util.List;

import com.snapdeal.model.Product;
import com.snapdeal.model.StarRatingFormDto;

public interface ProductDao extends GenericDao<Product, Integer>{

	int countAllPhones();
	
	List<Product> getProductsByPriceRange(BigDecimal low, BigDecimal high);
	
	//void addStarRating(StarRatingFormDto rating, Integer productId);

	Integer getStarRatingSum(Integer productId);

	Integer getNumOfStarRatingVotes(Integer productId);
	
	void setNumOfStarRatingVotes(Integer numOfStarRatingVotes, Integer productId);
	
	void setRatingSum(Integer ratingSum, Integer productId);
}
