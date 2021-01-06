package com.java4rohit.avtaar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java4rohit.avtaar.entities.User;
import com.java4rohit.avtaar.services.UserServies;

/**
 * 
 * @author java4rohit
 *this is User controller  which content user related endpoint..
 */
@RestController
public class UserController {
	@Autowired
	UserServies userServies;

	@GetMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUser() {
		List<User> list = userServies.getUsers();
		return new ResponseEntity<List<User>>(list, list.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

	@PostMapping(value = "/saveUser")
	public ResponseEntity<User> saveUser(@Validated @RequestBody User user) {
		User resposneUser = userServies.saveUser(user);
		return new ResponseEntity<User>(resposneUser, HttpStatus.CREATED);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		userServies.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int UserId) {
		userServies.deleteUser(UserId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
