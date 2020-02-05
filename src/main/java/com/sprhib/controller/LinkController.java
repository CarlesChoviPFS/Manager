package com.sprhib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {
	
	@RequestMapping(value="/")
	public String mainPage() {
		//return new ModelAndView("home");
		return "redirect:/Manager/login";
	}
	
	@RequestMapping(value="/index")
	public String indexPage() {
		//return new ModelAndView("home");
		return mainPage();
	}
}