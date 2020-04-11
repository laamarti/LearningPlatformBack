package com.trainings.platform.payload.request;

import java.sql.Date;




public class ElementForm {
	
	
	private Long id;
	
	
	private String subject;
	
	
	private int price;
	
	
	private int duration;
	
	
	private Date startingDate;


	public ElementForm(Long id, String subject, int price, int duration, Date startingDate) {
		super();
		this.id = id;
		this.subject = subject;
		this.price = price;
		this.duration = duration;
		this.startingDate = startingDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public Date getStartingDate() {
		return startingDate;
	}


	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	
	
	

}
