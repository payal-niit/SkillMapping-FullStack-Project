package com.niit.skillmapping.dao;

import java.util.List;

import com.niit.skillmapping.model.Skills;
import com.niit.skillmapping.model.User;

public interface SkillDAO {
	
	public List<User> getUserList();
	public boolean createUser(User user);
	public String getUserListByJSON();
	public Skills getUserById(int user_id);
	public Skills getUserByUsername(String username);
	public List<Skills> getUserforActivation();
	public List<Skills> getUserOnSearch(String fname);
	public boolean getUserActivated(int user_id);
	public boolean updateUser(User user);
	public boolean deleteUser(int user_id);

}
