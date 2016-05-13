package com.snapdeal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snapdeal.model.Product;
import com.snapdeal.model.StarRatingFormDto;
import com.snapdeal.service.ProductService;

@Controller
@RequestMapping(value = "/products")
public class ProductController extends AbstractPageController {
	private final static Logger LOG = LogManager.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@RequestMapping(path = "/{productId}", method = RequestMethod.GET)
	public String showProduct(HttpServletRequest request, @PathVariable String productId, Model model) {
		LOG.info("entering showProduct()");
		Integer id = 0;
		try {
			id = Integer.parseInt(productId);
		} catch (NumberFormatException e) {
			LOG.warn("product id not a number");
			return "welcome";
		}

		Product product = productService.read(id);
		if (product == null) {
			LOG.warn("product with id: " + productId + " was not found");
			return "welcome";
		}
		model.addAttribute("product", product);
		StarRatingFormDto starRating = new StarRatingFormDto();
		model.addAttribute("starRating", starRating);
		return "product";
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.POST)
	public String addStarRating(@Valid @ModelAttribute("starRating") StarRatingFormDto starRating,
			BindingResult bindingResult, @PathVariable String productId, Model model) {

		LOG.info("entering addStarRating()");

		if (bindingResult.hasErrors()) {

			Product product = productService.read(Integer.parseInt(productId));
			if (product == null) {
				LOG.warn("product with id: " + productId + " was not found");
				return "welcome";
			}
			model.addAttribute("product", product);
			return "product";
		}

		// TOASK: is it better to pass just productID or make a product?
		// Product product = productService.read(Integer.parseInt(productId));
		productService.setStarRating(starRating, Integer.valueOf(productId));
		return "redirect:/products/{productId}";

	}

	@RequestMapping("/")
	public String showProducts(HttpServletRequest request, Model model) {
		LOG.debug("entering showProducts()");
		addBreadcrumb(Pages.productsPage, request.getServletPath());
		model.addAttribute("products", productService.getAll());
		return "products";
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
