package com.snapdeal.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	private final static Logger LOG = LogManager.getLogger(GlobalControllerExceptionHandler.class);

	public GlobalControllerExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(Exception.class)
	public ModelAndView defaultErrorHandler(Exception ex) {
		LOG.info("Exception Occured: " + ex.getMessage());

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex.getMessage());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

}
