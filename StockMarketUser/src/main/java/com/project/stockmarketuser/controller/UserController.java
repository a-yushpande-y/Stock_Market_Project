package com.project.stockmarketuser.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarketuser.model.User;
import com.project.stockmarketuser.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
	
	@Autowired
	UserService userservice;
	@GetMapping("/users")
	public List<User> getUsers(){
		return userservice.getUsers();
	}
	
	@PostMapping("/user")
	public void insertUser(@RequestBody User user) {
		userservice.saveUser(user);
	}

}
