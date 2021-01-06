package com.java4rohit.avtaar.services;

import java.util.List;
import java.util.Optional;

import com.java4rohit.avtaar.entities.Activities;

public interface ActivitiesServices {

	
	
	public List<Activities> getActivities();

	public Activities saveActivities(Activities activities);

	public void updateActivities(Activities activities);

	public void deleteActivities(Long activitiesId);
	
	public Activities findByActivitiesName(String name);
	
	public Optional<Activities> findById(Long Id);

}
