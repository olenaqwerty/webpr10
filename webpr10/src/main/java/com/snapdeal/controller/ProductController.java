package com.snapdeal.controller;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snapdeal.model.Product;
import com.snapdeal.model.StarRatingFormDto;
import com.snapdeal.service.ProductService;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(path = "/{productId}", method = RequestMethod.GET)
	public String findProduct(@PathVariable String productId, Model model) {
		int id = 0;
		try {
			id = Integer.parseInt(productId);
		} catch (NumberFormatException e) {
			// throw new OrderNotFoundException(id);
		}
		Product product = null;
		product = productService.read(id);
		// if (product == null) throw new OrderNotFoundException(id);
		model.addAttribute("product", product);
		StarRatingFormDto rating = new StarRatingFormDto();
		model.addAttribute("rating", rating);
		return "product";
	}

	@RequestMapping()
	public String showProducts(Model model) {
		model.addAttribute("products", productService.getAll());
		return "products";

	}

	/*@RequestMapping(value = "/addStarRating", method = RequestMethod.GET)
	public String getAddStarRating(Model model) {
		StarRatingFormDto rating = new StarRatingFormDto();
		model.addAttribute("rating", rating);
		return "addProduct";
	}*/

	@RequestMapping(value = "/{productId}", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("rating") StarRatingFormDto rating, Model model) {
		productService.addStarRating(rating);
		model.addAttribute("avgRating", rating.getStarRatingValue());
		return "redirect:/product";
	}

	/*
	 * @RequestMapping("/{price}") public String
	 * filterProducts(@MatrixVariable(pathVar = "price") Map<String,
	 * List<String>> priceParams, Model model) {
	 * 
	 * Set<Product> productsByPrice = new HashSet<Product>();
	 * 
	 * BigDecimal low = new BigDecimal(priceParams.get("low").get(0));
	 * BigDecimal high = new BigDecimal(priceParams.get("high").get(0));
	 * productsByPrice.addAll(productService.getProductByPriceRange(low, high));
	 * 
	 * return "welcome"; }
	 */

}
