package com.bootcamp.ektha.rewardsprogram.form;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistrationFormValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return RegistrationFormDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		RegistrationFormDTO regForm = (RegistrationFormDTO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeCountries", "NotEmpty.userForm.storeCountries");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeStates", "NotEmpty.userForm.storeStates");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locations", "NotEmpty.userForm.locations");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userForm.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.userForm.confirmPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.userForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.userForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberCountry", "NotEmpty.userForm.memberCountry");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberStates", "NotEmpty.userForm.memberStates");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressOne", "NotEmpty.userForm.addressOne");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberCity", "NotEmpty.userForm.memberCity");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberZip", "NotEmpty.userForm.memberZip");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmEmail", "NotEmpty.userForm.confirmemail");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "NotEmpty.userForm.phoneNumber");
	
		
		if (!regForm.getPassword().equals(regForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
		}
		
		if (!regForm.getEmail().equals(regForm.getConfirmEmail())) {
			errors.rejectValue("confirmEmail", "Diff.userform.confirmEmail");
		}
		
		//USERNAME
		
		//Email
	
	}
	

}
