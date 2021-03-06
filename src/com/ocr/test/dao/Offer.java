package com.ocr.test.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ocr.test.validation.ValidEmail;

public class Offer {

	private int id;
	
	@NotNull
	@Size(min=5, max=30, message="Name must be 5 and 30 characters")
	private String name;
	
	@NotNull
	@ValidEmail(min=6, message="This email address is not proper")
	private String email;
	
	@Size(min=10, max=300, message="Name must be 10 and 300 characters")
	private String text;
	
	public Offer()
	{
		
		
	}
	public Offer(String name, String email, String text) {
		
		this.name = name;
		this.email = email;
		this.text = text;
	}
	public Offer(int id, String name, String email, String text) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}
	
	
}
