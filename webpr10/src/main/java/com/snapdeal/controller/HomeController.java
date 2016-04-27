package com.snapdeal.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snapdeal.service.ProductService;
import com.snapdeal.service.PromotionDtoService;

@Controller
public class HomeController extends AbstractPageController{

	private final static Logger LOG = LogManager.getLogger(HomeController.class);
	@Autowired
	private PromotionDtoService promotionDtoService;

	@Autowired
	ProductService productService;

	@RequestMapping("/welcome")
	public String showHomePage(HttpServletRequest request, Model model) {
        LOG.debug("HomeController.showHomePage");
        //TOASK: is it a good idea to get path from the outside. from the request?
        // or would it be better to form it inside in code?
        addBreadcrumb(Pages.homePage, request.getRequestURL().toString());        
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
