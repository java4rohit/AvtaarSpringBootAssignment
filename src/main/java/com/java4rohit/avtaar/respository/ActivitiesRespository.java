package com.java4rohit.avtaar.respository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java4rohit.avtaar.entities.Activities;


@Repository
public interface ActivitiesRespository extends CrudRepository<Activities, Long>  {


	public Activities findByActivitiesName(String name);
	
	public Optional<Activities> findById(Long id); // Select Name from Activities where id = 'id';
	
	
	

}
