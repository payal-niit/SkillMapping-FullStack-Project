package com.niit.skillmapping.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skillmapping.dao.UserDAO;
import com.niit.skillmapping.daoimpl.UserDAOImpl;
import com.niit.skillmapping.model.User;
import com.niit.skillmapping.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	public boolean createUser(User user) {
		if (userDAO.getUserById(user.getUser_id()) != null) {
			return false;
		} else {
			userDAO.createUser(user);
			return true;
		}
	}

	public User getUserById(int user_id) {
		System.out.println("fethching user by id");
		return userDAO.getUserById(user_id);
	}

	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}

	public List<User> getUserList() {		
		return userDAO.getUserList();
	}

	public String getUserListByJSON() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserforActivation() {
		
		return userDAO.getUserforActivation();
	}

	public List<User> getUserOnSearch(String fname) {
		
		return userDAO.getUserOnSearch(fname);
	}

	public boolean getUserActivated(int user_id) {
		if(userDAO.getUserById(user_id) != null) {
			userDAO.getUserActivated(user_id);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean updateUser(User user) {
		if (userDAO.getUserById(user.getUser_id()) != null) {
			userDAO.updateUser(user);
			return true;
		} else {
			return false;
		}
	}
	public boolean deleteUser(int user_id) {
		User user = userDAO.getUserById(user_id);
		if (userDAO.getUserById(user.getUser_id()) != null) {
			userDAO.deleteUser(user_id);
			return true;
		} else {
			return false;
		}
		/*userDAO.deleteUser(user_id);
		return true;*/
	}
}
