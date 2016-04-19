package com.snapdeal.controller;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snapdeal.service.ProductService;
import com.snapdeal.service.PromotionDtoService;
import com.snapdeal.service.impl.BreadcrumbsService;

@Controller
public class HomeController {
	
	//private static final Logger LOG = LogManager.getLogger(HomeController.class);

	@Autowired
	private PromotionDtoService promotionDtoService;

	@Autowired
	ProductService productService;
	
	@Autowired
	BreadcrumbsService breadcrumbsService;

	@RequestMapping("/welcome")
	public String showHomePage(Model model) {
		/*LOG.debug("in welcome page controller debug========");
		LOG.info("in welcome page controller info=========");
		LOG.warn("in welcome page controller warn=========");
		LOG.error("in welcome page controller error========");
		LOG.fatal("in welcome page controller fatal=========");*/
		System.out.println("====================qqqqqqqqq");
		
		model.addAttribute("promotionDtos", promotionDtoService.loadPromotionDtos());
		Integer phonesNum = productService.countAllPhones();
		model.addAttribute("phonesNum", phonesNum);
		//model.addAttribute("breadcrumbs", breadcrumbsService.getBreadcrumbs()); do i need breadcrumb service or builders?

		/*
		 * List<Product> list = productService.getAll();
		 * System.out.println(list.get(0));
		 */
		return "welcome";
	}
}
