package com.bootcamp.ektha.rewardsprogram.entity;

import java.util.ArrayList;
import java.util.Random;

/**
 * ENTITY CLASS REPRESENTATING CKMEMBER TABLES 
 * ALSO, MEMBER HAS A ADDRESS 
 * MEMBER HAS PREFERENCES 
 * MEMBER HAS LOGIN INFO
 * MEMBER HAS PERSONAL DETAILS
 * 
 * @author SV
 *
 */
public class Member {
	private Address address;
	private MemberPersonalDetails personalDetails;
	private User userLogin;
	private ArrayList<String> emailPreferences;
	private String memberEmail;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String preferredStore;
	private String memberId;
	// private String membershipDate;
	
	public Member() {
		memberId = "PM" + (new Random().nextInt(9000000) + 1000000 );
	}
	
	
	
	public Member(ArrayList<String> emailPreferences, String memberEmail, String firstName, 
			String lastName, String phoneNumber, String preferredStore,
			Address address, MemberPersonalDetails personalDetails, User user) {
		this();
		this.emailPreferences = emailPreferences;
		this.memberEmail = memberEmail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.preferredStore = preferredStore;
	}



	public String getMemberId() {
		return memberId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MemberPersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(MemberPersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public User getUser() {
		return userLogin;
	}

	public void setUser(User user) {
		this.userLogin = user;
	}

	public String getEmail() {
		return memberEmail;
	}

	public void setEmail(String email) {
		this.memberEmail = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPreferredStore() {
		return preferredStore;
	}

	public void setPreferredStore(String preferredStore) {
		this.preferredStore = preferredStore;
	}

	public ArrayList<String> getEmailPreferences() {
		return emailPreferences;
	}

	public void setEmailPreferences(ArrayList<String> emailPreferences) {
		this.emailPreferences = emailPreferences;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

}
