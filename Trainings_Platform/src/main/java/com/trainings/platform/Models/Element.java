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


@Entity
@Table(name="element")
public class Element {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String subject;
	
	@Column
	private int price;
	
	@Column
	private int duration;
	
	@Column
	private Date startingDate;
	
	public Element() {}
	
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "Training_id", nullable = false)
//	private Training training;
	
	
	
//	
//	@OneToMany(mappedBy = "element", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<User> recipients;

//	public Training getTraining() {
//		return training;
//	}
//
//	public void setTraining(Training training) {
//		this.training = training;
//	}

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
