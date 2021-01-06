package com.java4rohit.avtaar.services;

import java.util.List;
import java.util.Optional;

import com.java4rohit.avtaar.entities.User;


public interface UserServies {

	public Optional<User> getCareers(Integer userId);

	public List<User> getUsers();

	public User saveUser(User user);

	public void updateUser(User user);

	public void deleteUser(Integer userId);
	
	

}
