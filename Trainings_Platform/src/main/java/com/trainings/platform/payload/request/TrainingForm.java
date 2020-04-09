package com.trainings.platform.payload.request;

import java.sql.Date;
import java.util.ArrayList;
import com.trainings.platform.Models.User;
import com.trainings.platform.Models.Element;



public class TrainingForm {
	
		
	private String name;
	
	private String description;
	
	
	private String hostInstitution;
	
	private int maxNumber;
	
	private int minNumber;
	
	private int hours;
	
	private int price;
	

	private Date startingDate;
	
	private Date endingDate;
	
	private boolean isConfirmed;
	
    private ArrayList<Element> elements;
	 
	private User trainer;

	public TrainingForm(String name, String description, String hostInstitution, int maxNumber, int minNumber, int price,
			int hours, Date startingDate, Date endingDate, boolean isConfirmed, ArrayList<Element> elements,
			User trainer) {
		super();
		this.name = name;
		this.description = description;
		this.hostInstitution = hostInstitution;
		this.maxNumber = maxNumber;
		this.minNumber = minNumber;
		this.price= price;
		this.hours = hours;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.isConfirmed = isConfirmed;
		this.elements = elements;
		this.trainer = trainer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHostInstitution() {
		return hostInstitution;
	}

	public void setHostInstitution(String hostInstitution) {
		this.hostInstitution = hostInstitution;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public int getMinNumber() {
		return minNumber;
	}

	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public ArrayList<Element> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Element> elements) {
		this.elements = elements;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
		

}
