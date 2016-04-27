package com.snapdeal.model;

public class Breadcrumb {

	private String url;
	private String name;

	public Breadcrumb(final String name, final String url)
	{
		this.name = name;
		this.url = url;
	}


	public String getUrl()
	{
		return url;
	}

	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}
}
