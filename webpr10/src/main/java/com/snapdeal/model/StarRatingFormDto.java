package com.snapdeal.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class StarRatingFormDto {
	
	@Range(min=1, max=5, message="rate value should be from 1 to 5")
	@NotNull(message ="you need to rate this device")
	private Integer starRatingValue;


	public Integer getStarRatingValue() {
		return starRatingValue;
	}

	public void setStarRatingValue(int starRatingValue) {
		this.starRatingValue = starRatingValue;
	}

	public StarRatingFormDto() {
		// TODO Auto-generated constructor stub
	}

}
