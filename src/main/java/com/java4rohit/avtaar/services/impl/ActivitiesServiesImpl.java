package com.java4rohit.avtaar.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4rohit.avtaar.entities.Activities;
import com.java4rohit.avtaar.respository.ActivitiesRespository;
import com.java4rohit.avtaar.services.ActivitiesServices;

@Service
public class ActivitiesServiesImpl implements ActivitiesServices {

	@Autowired
	ActivitiesRespository activitiesRespository;

	@Override
	public List<Activities> getActivities() {

		return (List<Activities>) activitiesRespository.findAll();
	}

	@Override
	public Activities saveActivities(Activities activities) {
		return activitiesRespository.save(activities);
	}

	@Override
	public void updateActivities(Activities activities) {
		activitiesRespository.save(activities);

	}

	@Override
	public void deleteActivities(Long activitiesId) {
		activitiesRespository.deleteById(activitiesId);
	}

	@Override
	public Activities findByActivitiesName(String name) {
		return activitiesRespository.findByActivitiesName(name);
	}
	
	@Override
	public Optional<Activities> findById(Long activitiesId) {
		return activitiesRespository.findById(activitiesId);
	}

}
