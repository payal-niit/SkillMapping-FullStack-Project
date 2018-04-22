package com.niit.skillmapping.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Certifications {
	@Id
	private int certification_id;
	private String certification_name;
	private String technology_name;

	public int getCertification_id() {
		return certification_id;
	}

	public void setCertification_id(int certification_id) {
		this.certification_id = certification_id;
	}

	public String getCertification_name() {
		return certification_name;
	}

	public void setCertification_name(String certification_name) {
		this.certification_name = certification_name;
	}

	public String getTechnology_name() {
		return technology_name;
	}

	public void setTechnology_name(String technology_name) {
		this.technology_name = technology_name;
	}
}
