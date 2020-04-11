package com.trainings.platform.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainings.platform.Models.Beneficiary;
import com.trainings.platform.Models.Element;
import com.trainings.platform.Models.Trainer;
import com.trainings.platform.Models.Training;
import com.trainings.platform.Repository.ElementRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/element")
public class ElementController {
	
	@Autowired
	ElementRepository elementRepository;
	
	
	@PostMapping("/addElement")
	@PreAuthorize("hasRole('ROLE_FORMATEUR')")
	public ResponseEntity<Element> addElement(@RequestBody Element element) {
		try {
		elementRepository.save(element);
		return new ResponseEntity<>(element, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
		}
	
	@PostMapping("/suppElement")
	@PreAuthorize("hasRole('ROLE_FORMATEUR')")
	public ResponseEntity<Element> suppElement(@RequestBody Element element) {
		try {
		elementRepository.delete(element);
		return new ResponseEntity<>(element, HttpStatus.ACCEPTED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
		}
	
	@PostMapping("/modElement")
	@PreAuthorize("hasRole('ROLE_FORMATEUR')")
	public ResponseEntity<Element> modElement(@RequestBody Element element) {
		try {
		elementRepository.save(element);
		return new ResponseEntity<>(element, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
	}
		}
	

}
