package com.niit.skillmapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserSkillMapping {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userSkill_id;
	
	@Column(name = "skill_id")
	private int skill_id;;

	@Column(name="user_id")
	private int user_id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false, updatable = false, insertable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="skill_id", nullable = false, updatable = false, insertable = false)
	private Skills skills;

	public int getUserSkill_id() {
		return userSkill_id;
	}

	public void setUserSkill_id(int userSkill_id) {
		this.userSkill_id = userSkill_id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}		
}
