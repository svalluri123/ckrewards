package com.bootcamp.ektha.rewardsprogram.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bootcamp.ektha.rewardsprogram.entity.Address;
import com.bootcamp.ektha.rewardsprogram.entity.Member;
import com.bootcamp.ektha.rewardsprogram.entity.MemberPersonalDetails;
import com.bootcamp.ektha.rewardsprogram.entity.User;
import com.bootcamp.ektha.rewardsprogram.form.RegistrationFormDTO;
import com.bootcamp.ektha.rewardsprogram.service.MemberService;

@Controller
public class RegistrationController {

	private MemberService memberService;
	// private RegistrationFormValidation regForm;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = "signup")
	public ModelAndView getSignUpPage() {
		ModelAndView model = new ModelAndView("/jsp/signup");
		model.addObject("title", "New User Sign Up Page");
		model.addObject("registrationform", new RegistrationFormDTO());
		return model;
	}

	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request) {
		Member member = new Member();
		User user = new User();
		Address address = new Address();
		MemberPersonalDetails personalDetails = new MemberPersonalDetails();
		ArrayList<String> emailPrefList = new ArrayList<>();

		// hold username And password
		user.setUsername((String) request.getParameter("username"));
		user.setPassword((String) request.getParameter("password"));

		// hold information on address table
		address.setAddressOne((String) request.getParameter("addressOne"));
		address.setAddressTwo((String) request.getParameter("addressTwo"));
		address.setCity((String) request.getParameter("memberCity"));
		address.setZip((String) request.getParameter("memberZip"));
		address.setCountryId((String) request.getParameter("memberCountries"));
		address.setStateId((String) request.getParameter("memberStates"));

		// Personal Details information is hold
		personalDetails.setBirthDay((String) request.getParameter("birthDay"));
		personalDetails.setBirthMonth((String) request.getParameter("birthMonth"));
		personalDetails.setGender((String) request.getParameter("gender"));

		// income is translated
		personalDetails.setIncome((String) request.getParameter("householdIncome"));
		personalDetails.setMaritialStatus((String) request.getParameter("maritialStatus"));

		// email preferences is hold in a list ArrayList<String>
		String[] emailPreference = request.getParameterValues("emailPreference");
		for (String str : emailPreference) {
			emailPrefList.add(str);
		}
		member.setEmailPreferences(emailPrefList);

		// Member Information is hold
		member.setAddress(address);
		member.setPersonalDetails(personalDetails);
		member.setUser(user);
		member.setFirstName((String) request.getParameter("firstName"));
		member.setLastName((String) request.getParameter("lastName"));
		member.setEmail((String) request.getParameter("email"));
		member.setPhoneNumber((String) request.getParameter("phoneNumber"));
		member.setPreferredStore((String) request.getParameter("locations"));

		boolean isSuccess = memberService.addMember(member);

		if (isSuccess) {
			return "newuserwelcome";
		} else {
			return "redirect:index";
		}

	}

}
