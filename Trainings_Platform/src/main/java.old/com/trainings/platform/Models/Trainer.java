package com.trainings.platform.Models;

import java.io.File;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@DiscriminatorValue("1")
public class Trainer extends User {
	
	@Column
	private File cv;
	
	@OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Training> trainings;
	
	@OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<TrainerRate> rates;

	public Trainer() {
		
	}
	
	
	
	public Trainer(String firstName, String lastName, @Email String email, @NotBlank String username, String phone,
			String strRole, String password,File cv) {
		super(firstName, lastName, email, username, phone, strRole, password);
		this.cv= cv;
		// TODO Auto-generated constructor stub
	}



	public Trainer(@NotBlank String username, @Email String email, String password, String strRole) {
		super(username, email, password, strRole);
		// TODO Auto-generated constructor stub
	}



	public File getCv() {
		return cv;
	}

	public void setCv(File cv) {
		this.cv = cv;
	}

	public Set<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

	public Set<TrainerRate> getRates() {
		return rates;
	}

	public void setRates(Set<TrainerRate> rates) {
		this.rates = rates;
	}
	
	

}
