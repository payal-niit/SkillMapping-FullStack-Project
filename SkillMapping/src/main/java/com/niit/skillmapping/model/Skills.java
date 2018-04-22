package com.niit.skillmapping.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Skills {
	@Id
	private int skill_id;
	
	@NotEmpty(message = "Skill name cannot be empty")
	private int skill_name;
	private int total_hrs_taught;
	private int total_years_of_experience;

	public int getTotal_hrs_taught() {
		return total_hrs_taught;
	}

	public void setTotal_hrs_taught(int total_hrs_taught) {
		this.total_hrs_taught = total_hrs_taught;
	}

	public int getTotal_years_of_experience() {
		return total_years_of_experience;
	}

	public void setTotal_years_of_experience(int total_years_of_experience) {
		this.total_years_of_experience = total_years_of_experience;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public int getSkill_name() {
		return skill_name;
	}

	public void setSkill_name(int skill_name) {
		this.skill_name = skill_name;
	}	

}
