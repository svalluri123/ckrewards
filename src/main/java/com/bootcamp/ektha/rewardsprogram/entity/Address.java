package com.bootcamp.ektha.rewardsprogram.entity;

/**
 * This is Address Entity Class Holds information regarding customer Address
 * Possible to use for store address
 */
public class Address {
	private String addressOne;
	private String addressTwo;
	private String street;
	private String city;
	private String zip;
	private String stateId;
	private String countryId;
	
	public Address(String addressOne, String addressTwo, String city, String zip, String stateId, String countryId) {
		super();
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.street = this.addressOne + " " + this.addressTwo;
		this.city = city;
		this.zip = zip;
		this.stateId = stateId;
		this.countryId = countryId;
	}


	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAddressOne() {
		return this.addressOne + " " + this.addressTwo;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getStreet() {
		return addressOne + "," + addressTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
}
