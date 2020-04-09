package com.trainings.platform.Models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="training")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","trainer"})

public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private String hostInstitution;
	
	@Column
	private int maxNumber;
	
	@Column
	private int minNumber;
	
	@Column
	private int hours;
	
	@Column
	private int price;
	
	

	@Column
	private Date startingDate;
	
	@Column
	private Date endingDate;
	
	@Column
	private boolean isConfirmed;
	
//	@OneToMany(mappedBy = "training", fetch = FetchType.LAZY,
//	            cascade = CascadeType.ALL)
//	    private Set<Element> elements;
	 
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "trainer_id", nullable = false)
	private User trainer;
	
	//@JsonBackReference
	@OneToMany(mappedBy = "training", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Element> elements;
	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinTable(	name = "trainings_elements", 
//			joinColumns = @JoinColumn(name = "training_id"), 
//			inverseJoinColumns = @JoinColumn(name = "element_id"))
//	private Set<Element> elements = new HashSet<>();
	
//	@ManyToMany(mappedBy = "Trainings")
//	private Set<Beneficiary> beneficiaries = new HashSet<>();
	
//	
//	@OneToMany(mappedBy = "training", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<User> recipients;

	public Set<Element> getElements() {
		return elements;
	}

	public void setElements(Set<Element> elements) {
		this.elements = elements;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
//	public Set<Beneficiary> getBeneficiaries() {
//		return beneficiaries;
//	}
//
//
//
//	public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
//		this.beneficiaries = beneficiaries;
//	}
	
	
	
}
