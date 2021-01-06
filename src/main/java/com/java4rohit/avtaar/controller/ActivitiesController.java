package com.java4rohit.avtaar.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java4rohit.avtaar.entities.Activities;
import com.java4rohit.avtaar.services.ActivitiesServices;

/**
 * 
 * @author java4rohit The controller of application,ActivitiesController,define
 *         the Rest API endpoint. The code of activitiesController is this. this
 *         is activitiesController which content Activities related endpoint..
 *
 */

@RestController
public class ActivitiesController {

	@Autowired
	ActivitiesServices activitiesServices;

	@GetMapping(value = "/getActivity/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Activities> findById(@PathVariable("id") Long activitiesId) {
		Optional<Activities> activitiesOPt = activitiesServices.findById(activitiesId);
		return new ResponseEntity<Activities>(activitiesOPt.isPresent() ? activitiesOPt.get() : null,
				activitiesOPt.isPresent() ? HttpStatus.OK : HttpStatus.NO_CONTENT);

	}

	@GetMapping(value = "/getActivities/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Activities> getActivities(@PathVariable("name") String activityName) {
		Activities activity = activitiesServices.findByActivitiesName(activityName);
		return new ResponseEntity<>(activity, HttpStatus.OK);

	}

	@GetMapping(value = "/getActivities", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Activities>> getActivities() {
		List<Activities> list = activitiesServices.getActivities();
		return new ResponseEntity<List<Activities>>(list, list.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);

	}

	@PostMapping(value = "/saveActivities")
	public ResponseEntity<Activities> saveActivities(@Validated @RequestBody Activities activities) {
		Activities responseActivities = activitiesServices.saveActivities(activities);
		return new ResponseEntity<Activities>(responseActivities, HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateActivities")
	public ResponseEntity<Void> updateActivities(@RequestBody Activities activities) {
		activitiesServices.updateActivities(activities);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteActivity/{id}")
	public ResponseEntity<Void> deleteActivities(@PathVariable("id") Long ActivitiesId) {
		activitiesServices.deleteActivities(ActivitiesId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
