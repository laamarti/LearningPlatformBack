package com.trainings.platform.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="InstitutionRate")
public class InstitutionRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String institutionName;
	
	@Column
	private float workspace;
	
	@Column
	private float property;
	
	@Column
	private float equipment;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public float getWorkspace() {
		return workspace;
	}

	public void setWorkspace(float workspace) {
		this.workspace = workspace;
	}

	public float getProperty() {
		return property;
	}

	public void setProperty(float property) {
		this.property = property;
	}

	public float getEquipment() {
		return equipment;
	}

	public void setEquipment(float equipment) {
		this.equipment = equipment;
	}

	

	
}
