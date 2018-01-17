package com.bootcamp.ektha.rewardsprogram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/", "index"})
	public ModelAndView getHomePage(){
		ModelAndView model = new ModelAndView("index");
		model.addObject("title", "HomePage");
		return model;
	}
	
	@RequestMapping(value = "about")
	public ModelAndView getAboutPage(){
		ModelAndView model = new ModelAndView("/jsp/about");
		model.addObject("title", "About CK");
		return model;
	}
	
	
	@RequestMapping(value = "storelocator")
	public ModelAndView getStoreLocatorPage(){
		ModelAndView model = new ModelAndView("/jsp/storelocator");
		model.addObject("title", "Locate a Store near you");
		return model;
	}
	
	@RequestMapping(value = "terms")
	public ModelAndView getTermsConditionPage(){
		ModelAndView model = new ModelAndView("/jsp/terms");
		model.addObject("title", "Terms and Conditions");
		return model;
	}
	
	@RequestMapping(value = "signinSignup")
	public ModelAndView getLoginChoicePage(){
		ModelAndView model = new ModelAndView("/jsp/promptCard");
		model.addObject("title", "Sign In || Sign up ");
		return model;
	}
}
