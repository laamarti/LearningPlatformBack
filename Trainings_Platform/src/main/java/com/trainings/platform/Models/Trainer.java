package com.trainings.platform.Models;

import java.io.File;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


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
