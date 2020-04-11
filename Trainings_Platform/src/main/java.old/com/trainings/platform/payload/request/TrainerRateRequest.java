package com.trainings.platform.payload.request;

public class TrainerRateRequest {
	
	private float skill;
	
	private float subject;
	
	private float kindness;

	public TrainerRateRequest(int skill, int subject, int kindness) {
		super();
		this.skill = skill;
		this.subject = subject;
		this.kindness = kindness;
	}

	public float getSkill() {
		return skill;
	}

	public void setSkill(float skill) {
		this.skill = skill;
	}

	public float getSubject() {
		return subject;
	}

	public void setSubject(float subject) {
		this.subject = subject;
	}

	public float getKindness() {
		return kindness;
	}

	public void setKindness(float kindness) {
		this.kindness = kindness;
	}

	
}
