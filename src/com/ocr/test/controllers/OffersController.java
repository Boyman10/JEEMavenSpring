package com.ocr.test.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OffersController {

	/*
	@RequestMapping("/spring")
	public ModelAndView showHome() {
		
		ModelAndView mv = new ModelAndView("spring");
		Map<String, Object> model = mv.getModel();
		
		model.put("name", "<b>Maven</b>");
		
		// Return view
		return mv;
	}
	*/
	
	
	@RequestMapping("/spring")
	public String showHome(Model model) {
		
		model.addAttribute("name", "Kevin");
		
		return "spring";
	}
	
	@RequestMapping("/jstl")
	public String showJstl(Model model) {
		
		model.addAttribute("name", "Welcome JSTL");
		
		return "jstl";
	}
	
	
}
