package com.bootcamp.ektha.rewardsprogram.entity;
/**
 * 
 * Designed as per Database
 * contains Id, name and Abb
 * Member lives in a country 
 * and Store operates in a country
 *
 */
public class Country {
	private String countryId;
	private String countryName;
	private String countryAbb;

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryAbb() {
		return countryAbb;
	}

	public void setCountryAbb(String countryAbb) {
		this.countryAbb = countryAbb;
	}

}
