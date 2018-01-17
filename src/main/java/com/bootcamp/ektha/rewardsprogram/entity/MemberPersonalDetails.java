package com.bootcamp.ektha.rewardsprogram.entity;

/**
 * Member personal details class representing MEMBER_PERSONAL_DETAILS tables
 * 
 * @author SV
 *
 */
public class MemberPersonalDetails {
	private String memberId;
	private int minIncome;
	private int maxIncome;
	private String income;
	private String gender;
	private String birthDay;
	private String birthMonth;
	private String maritialStatus;

	public MemberPersonalDetails() {
		// TODO Auto-generated constructor stub
	}

	public MemberPersonalDetails(String income, String gender, String birthDay, String birthMonth,
			String maritialStatus) {
		this();
		this.income = income;
		this.gender = gender;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.maritialStatus = maritialStatus;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public int getMinIncome() {
		return minIncome;
	}

	public void setMinIncome(int minIncome) {
		this.minIncome = minIncome;
	}

	public int getMaxIncome() {
		return maxIncome;
	}

	public void setMaxIncome(int maxIncome) {
		this.maxIncome = maxIncome;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String string) {
		this.birthDay = string;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}
}
