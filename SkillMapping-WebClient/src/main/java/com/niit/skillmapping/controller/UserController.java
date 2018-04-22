package com.niit.skillmapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillmapping.model.User;
import com.niit.skillmapping.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> userList() {
		if (userService.getUserList().size() != 0) {
			return new ResponseEntity<List<User>>(userService.getUserList(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/toapprove")
	public ResponseEntity<List<User>> userListToApprove() {
		if (userService.getUserList().size() != 0) {
			return new ResponseEntity<List<User>>(userService.getUserforActivation(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/search/{name}")
	public ResponseEntity<List<User>> searchUsers(@PathVariable("name") String name) {
		if (userService.getUserList().size() != 0) {
			return new ResponseEntity<List<User>>(userService.getUserOnSearch(name), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping()
	public ResponseEntity<Void> createUser(@RequestBody User user) {
		if (userService.getUserByUsername(user.getEmail_id()) == null) {
			userService.createUser(user);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<User> getUserById(@PathVariable("user_id") int user_id) {
		return new ResponseEntity<User>(userService.getUserById(user_id),HttpStatus.OK);
	}
	
	@PutMapping("/{user_id}")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		if (userService.getUserById(user.getUser_id()) == null) {
			userService.updateUser(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/activate/{user_id}")
	public ResponseEntity<Void> activateUser(@PathVariable("user_id") int user_id) {
		if (userService.getUserById(user_id) != null) {
			userService.getUserActivated(user_id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{user_id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("user_id") int user_id) {
		if(userService.getUserById(user_id) != null) {
			userService.deleteUser(user_id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	

}
