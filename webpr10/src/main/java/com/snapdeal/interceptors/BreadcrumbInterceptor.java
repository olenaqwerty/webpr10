package com.snapdeal.interceptors;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.snapdeal.controller.BreadcrumbBuilder;
import com.snapdeal.controller.Pages;
import com.snapdeal.model.Breadcrumb;

public class BreadcrumbInterceptor extends HandlerInterceptorAdapter {
	private final static Logger LOG = LogManager.getLogger(BreadcrumbInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String reqUri = request.getLocalName();
		String pageName = reqUri.substring(reqUri.lastIndexOf("/") + 1, reqUri.length());

		for (Pages p : Pages.values()) {
			if (p.name().equals(pageName)) {
				//addBreadcrumb(pageName, request.getRequestURL().toString());
			}
		}

		return super.preHandle(request, response, handler);
	}

	@SuppressWarnings("unchecked")
	public void addBreadcrumb(Pages page, String path, HttpServletRequest request) {
		LOG.debug("adding product breadcrumb to breadcrumb list");
		ArrayList<Breadcrumb> bc = (ArrayList<Breadcrumb>) request.getSession().getAttribute("breadcrumbs");

		Breadcrumb breadcrumb = null;
		try {
			breadcrumb = BreadcrumbBuilder.getBreadcrumbs(page, path);
		} catch (NullPointerException npe) {
			LOG.debug("breadcrumb was not created. " + npe.getMessage());
			return;
		}
		bc.add(breadcrumb);
	}

}
