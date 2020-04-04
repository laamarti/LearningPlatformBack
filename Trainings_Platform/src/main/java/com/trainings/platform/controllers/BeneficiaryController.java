package com.trainings.platform.controllers;

import java.util.Optional;

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
import com.trainings.platform.Models.Training;
import com.trainings.platform.Models.User;
import com.trainings.platform.Repository.BeneficiaryRepository;
import com.trainings.platform.Repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/beneficiary")
public class BeneficiaryController {
	
	
	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/getbeneficiary/{id}")
	User getbeneficiarybyId(@PathVariable("id") long id){
System.out.println(id);
		System.out.println(userRepository.findAll().size());
		
		return userRepository.findById(id).get();

	}
	
	
	@PostMapping("/addElement")
	public ResponseEntity<Beneficiary> addElement(@RequestBody Beneficiary beneficiary) {
		try {
			beneficiaryRepository.save(beneficiary);
		return new ResponseEntity<>(beneficiary, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
		}
	
	

}
