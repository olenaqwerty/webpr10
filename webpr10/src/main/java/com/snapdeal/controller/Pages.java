package com.snapdeal.controller;

public enum Pages {

	homePage("Home Page"), 
	productPage("Product Page"), 
	productsPage("Products Page");

	private String name;

	private Pages(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
