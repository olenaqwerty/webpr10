package com.snapdeal.controller;

import com.snapdeal.model.Breadcrumb;
import com.snapdeal.model.GenericModel;

public class BreadcrumbBuilder {

	// TOASK: would it be better to create parent model.
	// product model and category model would inherit from parent model
	// and then we don't need 2 methods getBreadcrumbs
	public static Breadcrumb getBreadcrumbs(final GenericModel productModel, String path){
		if (productModel.getName() == null || productModel.getName().isEmpty() || path == null
				|| path.isEmpty()) {
			// TOASK:if i have an exception i don't need log right?
			// TOASK:what kind of exception should be thrown here?
			throw new NullPointerException("product name or path is null");
		} else {
			return new Breadcrumb(productModel.getName(), path);
		}
	}
	
	public static Breadcrumb getBreadcrumbs(Pages page, String path) throws NullPointerException {
		if (page.toString().isEmpty()) {
			throw new NullPointerException("page name is empty");
		} else {
			return new Breadcrumb(page.toString(), path);
		}
	}

}
