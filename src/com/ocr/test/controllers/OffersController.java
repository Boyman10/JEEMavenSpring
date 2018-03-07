package com.ocr.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ocr.test.dao.Offer;
import com.ocr.test.service.OffersService;

@Controller
public class OffersController {

	private OffersService offersService;
	
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
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/spring")
	public String showHome(Model model) {
		
		model.addAttribute("name", "Kevin");
		
		return "spring";
	}
	
	@RequestMapping("/jstl")
	public String showJstl(Model model) {
		
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "jstl";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer() {
		
		
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate",method=RequestMethod.POST)
	public String doCreate(Model model, Offer offer) {
		
		System.out.println(offer);
		return "docreate";
	}
	/**
	 * Testing a GET request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		
		System.out.println("id is " + id);
	
		return "spring";
	}
	
}
