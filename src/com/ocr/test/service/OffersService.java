package com.ocr.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.test.dao.Offer;
import com.ocr.test.dao.OffersDAO;

@Service("offersService")
public class OffersService {

	private OffersDAO offersDao;
	
	public List<Offer> getCurrent() {
		
		return offersDao.getOffers();
	}

	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}


	
}
