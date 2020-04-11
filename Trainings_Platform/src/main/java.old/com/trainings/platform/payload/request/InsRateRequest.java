package com.trainings.platform.payload.request;

public class InsRateRequest {

	
	
	private int workspace;
	
	private int property;
	
	private int equipment;

	public InsRateRequest(int workspace, int property, int equipment) {
		super();
		this.workspace = workspace;
		this.property = property;
		this.equipment = equipment;
	}

	public int getWorkspace() {
		return workspace;
	}

	public void setWorkspace(int workspace) {
		this.workspace = workspace;
	}

	public int getProperty() {
		return property;
	}

	public void setProperty(int property) {
		this.property = property;
	}

	public int getEquipment() {
		return equipment;
	}

	public void setEquipment(int equipment) {
		this.equipment = equipment;
	}
	
}
