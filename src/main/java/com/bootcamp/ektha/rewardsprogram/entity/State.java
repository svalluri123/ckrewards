package com.bootcamp.ektha.rewardsprogram.entity;

/**
 * 
 * STATE ENTITY CLASS REPRESENTS THE STATES TABLE
 * @author SV
 *
 */
public class State {
	private String stateId;
	private String stateName;
	private String stateAbb;
	private String countryID;

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public String getStateAbb() {
		return stateAbb;
	}

	public void setStateAbb(String stateAbb) {
		this.stateAbb = stateAbb;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
