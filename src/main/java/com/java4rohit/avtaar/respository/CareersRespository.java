package com.java4rohit.avtaar.respository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java4rohit.avtaar.entities.Careers;


@Repository
public interface CareersRespository  extends CrudRepository<Careers, Integer>{

	public Careers findByCareersName(String name);
	
	public Optional<Careers> findById(Integer id); // Select Name from Careers where id = 'id';
	
}
