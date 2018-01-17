package com.bootcamp.ektha.rewardsprogram.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bootcamp.ektha.rewardsprogram.entity.User;
import com.bootcamp.ektha.rewardsprogram.service.UserServices;

@Controller
public class LoginController {
	UserServices userServices;

	@RequestMapping(value = { "login", "signin" })
	public ModelAndView getSignInPage() {
		ModelAndView model = new ModelAndView("/jsp/loginpage");
		model.addObject("title", "Sign In to Check Rewards");
		return model;
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String checkUser(ModelMap model, HttpServletRequest request) {
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");

		if (name != null && pwd != null) {
			User user = new User();
			user.setUsername(name);
			user.setPassword(pwd);
			boolean valid = userServices.validateUser(user);

			if (valid) {
				return "/jsp/welcome";
			}
		}

		return "redirect:signin";

	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}
}
