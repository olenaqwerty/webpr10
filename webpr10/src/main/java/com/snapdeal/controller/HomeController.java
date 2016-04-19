package com.snapdeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snapdeal.service.ProductService;
import com.snapdeal.service.PromotionDtoService;

@Controller
public class HomeController {

	@Autowired
	private PromotionDtoService promotionDtoService;

	@Autowired
	ProductService productService;

	@RequestMapping("/welcome")
	public String showHomePage(Model model) {
		model.addAttribute("promotionDtos", promotionDtoService.loadPromotionDtos());
		Integer phonesNum = productService.countAllPhones();
		model.addAttribute("phonesNum", phonesNum);
		/*
		 * List<Product> list = productService.getAll();
		 * System.out.println(list.get(0));
		 */
		return "welcome";
	}
}
