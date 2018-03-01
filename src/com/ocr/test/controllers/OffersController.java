package com.ocr.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OffersController {

	@RequestMapping("/spring")
	public String showHome() {
		
		// Return view
		return "home";
	}
}
