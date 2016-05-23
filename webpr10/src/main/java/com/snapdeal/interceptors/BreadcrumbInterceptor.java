package com.snapdeal.interceptors;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.snapdeal.controller.BreadcrumbFactory;
import com.snapdeal.controller.Pages;
import com.snapdeal.model.Breadcrumb;

@SessionAttributes("breadcrumbs")
public class BreadcrumbInterceptor extends HandlerInterceptorAdapter {
	private final static Logger LOG = LogManager.getLogger(BreadcrumbInterceptor.class);

	private static List<Breadcrumb> breadcrumbs = new ArrayList<>();

	@ModelAttribute("breadcrumbs")
	public List<Breadcrumb> getBreadcrumbs() {
		return breadcrumbs;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOG.info("preHandle()");
		String reqUri = request.getRequestURI();
		String regexpPattern = "/([a-zA-Z0-9\\-\\._\\?\\,\\'+&amp;%\\$#\\=~]+)/*$";
		Pattern pattern = Pattern.compile(regexpPattern);
		Matcher matcher = pattern.matcher(reqUri);
		String pageName = "";
		try {
			matcher.find();
			pageName = matcher.group(1);
			System.out.println("page name caught " + pageName);
		} catch (java.lang.IndexOutOfBoundsException | java.lang.IllegalStateException e) {
			LOG.warn("No match for regexp " + regexpPattern + " was found in " + reqUri
					+ ". Breadcrumb cannot be added");
			return super.preHandle(request, response, handler);
		}

		for (Pages p : Pages.values())

		{
			if (p.name().equals(pageName)) {
				addBreadcrumb(p, request.getRequestURL().toString(), request);
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
			breadcrumb = BreadcrumbFactory.getBreadcrumbs(page, path);
		} catch (NullPointerException npe) {
			LOG.debug("breadcrumb was not created. " + npe.getMessage());
			return;
		}
		bc.add(breadcrumb);
	}

}
