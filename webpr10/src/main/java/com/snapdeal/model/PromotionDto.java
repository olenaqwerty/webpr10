package com.snapdeal.model;

public class PromotionDto {

	private String imageUrl;
	private String titleText1;
	private String titleText2;
	private String locationText;
	private String locationPath;

	public PromotionDto(String imageUrl, String titleText1, String titleText2, String locationText,
			String locationPath) {
		this.imageUrl = imageUrl;
		this.titleText1 = titleText1;
		this.titleText2 = titleText2;
		this.locationText = locationText;
		this.locationPath = locationPath;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTitleText1() {
		return titleText1;
	}

	public void setTitleText1(String titleText1) {
		this.titleText1 = titleText1;
	}

	public String getTitleText2() {
		return titleText2;
	}

	public void setTitleText2(String titleText2) {
		this.titleText2 = titleText2;
	}

	public String getLocationText() {
		return locationText;
	}

	public void setLocationText(String locationText) {
		this.locationText = locationText;
	}

	public String getLocationPath() {
		return locationPath;
	}

	public void setLocationPath(String locationPath) {
		this.locationPath = locationPath;
	}

}
