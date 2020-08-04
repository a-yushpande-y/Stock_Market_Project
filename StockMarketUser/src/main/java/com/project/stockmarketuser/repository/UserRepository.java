package com.project.stockmarketuser.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.stockmarketuser.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByIdAndPassword(Integer id, String password);

}
