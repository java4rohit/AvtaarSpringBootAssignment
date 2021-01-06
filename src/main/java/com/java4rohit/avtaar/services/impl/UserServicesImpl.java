package com.java4rohit.avtaar.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4rohit.avtaar.entities.User;
import com.java4rohit.avtaar.respository.UserRespository;
import com.java4rohit.avtaar.services.UserServies;


@Service
public class UserServicesImpl implements UserServies {

	@Autowired
	UserRespository userRespository;

	@Override
	public Optional<User> getCareers(Integer userId) {
		return userRespository.findById(userId);
	}

	@Override
	public List<User> getUsers() {
		return (List<User>) userRespository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRespository.save(user);
	}

	@Override
	public void updateUser(User user) {
		userRespository.save(user);

	}

	@Override
	public void deleteUser(Integer userId) {
		userRespository.deleteById(userId);

	}

	



}
