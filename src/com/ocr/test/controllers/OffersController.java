package com.ocr.test.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		
		//offersService.throwTestException();
		
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "jstl";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate",method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("Form does not validate");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
						
		}
		
		offersService.create(offer);


		
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
	
	/*
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		
		return "error";
	}*/
}
