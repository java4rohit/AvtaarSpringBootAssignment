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
import org.springframework.web.bind.annotation.RestController;

import com.java4rohit.avtaar.entities.Careers;
import com.java4rohit.avtaar.services.CareersServies;
/**
 * 
 * @author java4rohit
 *
 *this is CareerController which content  Career related endpoint..
 *
 */
@RestController
public class CareerController {

	@Autowired
	CareersServies careersServies;

	@GetMapping(value = "/getCareers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Careers> findById(@PathVariable("id") int careersId) {
		Optional<Careers> careersOPt = careersServies.findById(careersId);
		return new ResponseEntity<Careers>(careersOPt.isPresent() ? careersOPt.get() : null,
				careersOPt.isPresent() ? HttpStatus.OK : HttpStatus.NO_CONTENT);

	}

	@GetMapping(value = "/getCareers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Careers>> getCareers() {
		List<Careers> list = careersServies.getCareers();
		return new ResponseEntity<List<Careers>>(list, list.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);

	}
	@PostMapping(value = "/saveCareers")
	public ResponseEntity<Careers> saveCareers(@Validated @RequestBody Careers careers) {

		Careers reponseCareers = careersServies.saveCareers(careers);
		return new ResponseEntity<Careers>(reponseCareers, HttpStatus.OK);

	}
	@PutMapping("/updateCareers")
	public ResponseEntity<Careers> updateCareer(@RequestBody Careers careers) {
		careersServies.updateCareers(careers);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	@DeleteMapping(value = "/deleteCareers/{id}")
	public ResponseEntity<Void> deleteCareer(@PathVariable("id") int CareerId) {
		careersServies.deleteCareers(CareerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
