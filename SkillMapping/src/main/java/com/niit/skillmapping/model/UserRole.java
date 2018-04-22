package com.niit.skillmapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	@Id
	private int userRole_id;
	
	@Column(name="role_id")
	private int role_id;
	
	@Column(name="user_id")
	private int user_id;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable = false, updatable = false, insertable = false)
	private User user;
	
	@ManyToOne
    @JoinColumn(name="role_id", nullable = false, updatable = false, insertable = false)
	private Role role;

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getUserRole_id() {
		return userRole_id;
	}

	public void setUserRole_id(int userRole_id) {
		this.userRole_id = userRole_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
