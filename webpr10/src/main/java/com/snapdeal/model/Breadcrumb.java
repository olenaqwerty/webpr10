package com.snapdeal.model;

public class Breadcrumb {

	private String url;
	private String name;

	public Breadcrumb(final String url, final String name)
	{
		this.url = url;
		this.name = name;
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
