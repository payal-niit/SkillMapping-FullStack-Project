package com.niit.skillmapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserCertificationMapping {
	@Id
	private int userCertification_id;
	
	@Column(name="certification_id")
	private int certification_id;
	@ManyToOne
	@JoinColumn(name="certification_id", nullable = false, updatable = false, insertable = false)
	private Certifications certifications;
	
	@Column(name="user_id")
	private int user_id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false, updatable = false, insertable = false)
	private User user;

	public int getUserCertification_id() {
		return userCertification_id;
	}

	public void setUserCertification_id(int userCertification_id) {
		this.userCertification_id = userCertification_id;
	}

	public int getCertification_id() {
		return certification_id;
	}

	public void setCertification_id(int certification_id) {
		this.certification_id = certification_id;
	}

	public Certifications getCertifications() {
		return certifications;
	}

	public void setCertifications(Certifications certifications) {
		this.certifications = certifications;
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
}
