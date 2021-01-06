package com.java4rohit.avtaar.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java4rohit.avtaar.entities.User;


@Repository
public interface UserRespository extends CrudRepository<User, Integer> {

}
