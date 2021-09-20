package com.saraya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	@RequestMapping(value ="/login", method = RequestMethod.GET)
	//@ResponseBody -> returns what is written in the loginPage()
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showPage(ModelMap model,@RequestParam String username) {
		model.addAttribute("usr", username);
		return "home";
			
	}
//	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
//	public String showListPage() {
//		return "add";
//			
//	}
//	
//	@RequestMapping(value="/add", method=RequestMethod.GET)
//	public String showAddPage() {
//		return "redirect:add";
//			
//	}
//	
//	@RequestMapping(value="/add", method=RequestMethod.POST)
//	public String AddPage() {
//		return "redirect:/list";
//			
//	}                  

}

