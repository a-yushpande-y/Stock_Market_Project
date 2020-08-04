package com.project.stockmarketuser.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.stockmarketuser.model.User;
import com.project.stockmarketuser.repository.UserRepository;
@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public boolean findUser(Integer id, String pass) {
		User user = userRepository.findByIdAndPassword(id,pass);
		if(user== null)
			return false;
		else
			return true;
	}
	
	public boolean findAdmin(Integer id, String pass) {
		
		if(id== 1 && pass.equals("admin"))
			return true;
		else
			return false;
	}
}
