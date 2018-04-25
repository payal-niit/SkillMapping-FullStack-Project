package com.niit.skillmapping.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	
	@NotEmpty(message="Name is required")
	private String fname;
	
	@NotEmpty(message="Name is required")
	private String lname;
	
	/*@NotEmpty(message="Number is required")
	@Pattern(regexp = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$")*/
	private String email_id;
	
	/*@NotEmpty(message="phone number is required")
	@Pattern(regexp = "\\d{10}")*/
	private String phone_number;
	
	/*@NotEmpty(message="Password needs to be set")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z]).{8,}$")*/
	private String password;
	private Date date_of_birth;
	private boolean status;
	private int manager_id;
	private int total_no_of_yrs_experience;
	private int total_no_of_students_handled;
	public int getTotal_no_of_yrs_experience() {
		return total_no_of_yrs_experience;
	}

	public void setTotal_no_of_yrs_experience(int total_no_of_yrs_experience) {
		this.total_no_of_yrs_experience = total_no_of_yrs_experience;
	}

	public int getTotal_no_of_students_handled() {
		return total_no_of_students_handled;
	}

	public void setTotal_no_of_students_handled(int total_no_of_students_handled) {
		this.total_no_of_students_handled = total_no_of_students_handled;
	}

	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}	

}
