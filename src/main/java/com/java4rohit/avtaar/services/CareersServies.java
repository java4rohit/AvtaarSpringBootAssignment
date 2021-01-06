package com.java4rohit.avtaar.services;

import java.util.List;
import java.util.Optional;

import com.java4rohit.avtaar.entities.Careers;


public interface CareersServies {


	public List<Careers> getCareers();

	public Careers saveCareers(Careers careers);

	public void updateCareers(Careers careers);

	public void deleteCareers(Long careersId);
	
	public Careers findByCareersName(String name);

	public Optional<Careers> findById(Long careersId);



}
