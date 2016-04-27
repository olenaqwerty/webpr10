package com.snapdeal.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.snapdeal.model.Breadcrumb;
import com.snapdeal.model.GenericModel;

@SessionAttributes("breadcrumbs")
public abstract class AbstractPageController {
	
	private static List<Breadcrumb> breadcrumbs = new ArrayList<>();

	private final static Logger LOG = LogManager.getLogger(AbstractPageController.class);
	
	@ModelAttribute("breadcrumbs")
    public  List<Breadcrumb> getBreadcrumbs () {
        return  breadcrumbs;
    }
	
	public void addBreadcrumb(Pages page, String path) {
		LOG.debug("adding product breadcrumb to breadcrumb list");
		Breadcrumb breadcrumb = null;
		try{
			breadcrumb = BreadcrumbBuilder.getBreadcrumbs(page, path);
		}catch(NullPointerException npe){
			LOG.debug("breadcrumb was not created. " + npe.getMessage());
			return;
		}
		breadcrumbs.add(breadcrumb);
	}
	
	public void addBreadcrumb(GenericModel model, String path) {
		LOG.debug("adding product breadcrumb to breadcrumb list");
		Breadcrumb breadcrumb = null;
		try{
			breadcrumb = BreadcrumbBuilder.getBreadcrumbs(model, path);
		}catch(NullPointerException npe){
			LOG.debug("breadcrumb was not created. " + npe.getMessage());
			return;
		}
		breadcrumbs.add(breadcrumb);
	}
}
