package com.bootcamp.ektha.rewardsprogram.entity;

/**
 * STORE ENTITY CLASS TO HOLD INFORMATION REGARDING STORE REPRESENTS THE STORE
 * TABLE THE DATABASE
 * 
 * @author SV
 *
 */
public class Store {
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", storeStreet=" + storeStreet
				+ ", storeSuite=" + storeSuite + ", storeCity=" + storeCity + ", stateId=" + stateId + "]";
	}

	private String storeId;
	private String storeName;
	private String storeStreet;
	private String storeSuite;
	private String storeCity;
	private String stateId;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreStreet() {
		return storeStreet;
	}

	public void setStoreStreet(String storeStreet) {
		this.storeStreet = storeStreet;
	}

	public String getStoreSuite() {
		return storeSuite;
	}

	public void setStoreSuite(String storeSuite) {
		this.storeSuite = storeSuite;
	}

	public String getStoreCity() {
		return storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

}
