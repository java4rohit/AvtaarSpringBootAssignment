package com.java4rohit.avtaar.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4rohit.avtaar.entities.Careers;
import com.java4rohit.avtaar.respository.CareersRespository;
import com.java4rohit.avtaar.services.CareersServies;

@Service
public class CareersServiesImpl implements CareersServies {

	@Autowired
	CareersRespository careersRespository;
	
	@Override
	public List<Careers> getCareers() {
		return (List<Careers>) careersRespository.findAll();
	}
	@Override
	public Careers saveCareers(Careers careers) {
		careers.getActivities().stream().forEach(a -> a.setCareers(careers));
		Careers savedcareer=careersRespository.save(careers);
		return savedcareer ;
	}
	@Override
	public void updateCareers(Careers careers) {
		careersRespository.save(careers);
		
	}
	@Override
	public void deleteCareers(Long careersId) {

		careersRespository.deleteById(careersId);
	}

	@Override
	public Careers findByCareersName(String name) {
		return careersRespository.findByCareersName(name);
	}

	@Override
	public Optional<Careers> findById(Long careersId) {
		return careersRespository.findById(careersId);
	}


}
