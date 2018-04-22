package com.niit.skillmapping.dao;

import java.util.List;

import com.niit.skillmapping.model.User;

public interface UserDAO {
	
	public List<User> getUserList();
	public boolean createUser(User user);
	public String getUserListByJSON();
	public User getUserById(int user_id);
	public User getUserByUsername(String username);
	public List<User> getUserforActivation();
	public List<User> getUserOnSearch(String fname);
	public boolean getUserActivated(int user_id);
	public boolean updateUser(User user);
	public boolean deleteUser(int user_id);
}
