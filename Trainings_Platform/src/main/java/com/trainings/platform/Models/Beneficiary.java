package com.trainings.platform.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;






@Entity
@DiscriminatorValue("2")
public class Beneficiary extends User{
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "ben_Element", 
    	joinColumns = @JoinColumn(name = "ben_id"), 
    	inverseJoinColumns = @JoinColumn(name = "Element_id"))
	private Set<Element> Elements = new HashSet<>();

	
//	@ManyToMany(fetch=FetchType.EAGER)
//    @JoinTable(name = "ben_Training", 
//    	joinColumns = @JoinColumn(name = "ben_id"), 
//    	inverseJoinColumns = @JoinColumn(name = "Training_id"))
//	private Set<Training> Trainings = new HashSet<>();


	public Beneficiary( String firstName, String lastName, String email,String username, String phone,
			String strRole, String password) {
		super(firstName,lastName,email,username,phone,strRole,password);
	}
	
	

	public Beneficiary() {
	
}



	public Set<Element> getElements() {
		return Elements;
	}


	public void setElements(Set<Element> elements) {
		Elements = elements;
	}


//	public Set<Training> getTrainings() {
//		return Trainings;
//	}
//
//
//	public void setTrainings(Set<Training> trainings) {
//		Trainings = trainings;
//	}

	
	

}
