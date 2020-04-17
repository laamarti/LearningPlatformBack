package com.trainings.platform.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cronJob")
public class CronJobTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private Long elemId;
	
	@Column
	private Long benId;
	
	@Column
	private Date additionDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getElemId() {
		return elemId;
	}

	public void setElemId(Long elemId) {
		this.elemId = elemId;
	}

	public Long getBenId() {
		return benId;
	}

	public void setBenId(Long benId) {
		this.benId = benId;
	}

	public Date getAdditionDate() {
		return additionDate;
	}

	public void setAdditionDate(Date additionDate) {
		this.additionDate = additionDate;
	}
	


}
