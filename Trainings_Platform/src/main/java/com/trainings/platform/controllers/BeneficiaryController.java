package com.trainings.platform.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.trainings.platform.Repository.ElementRepository;
import com.trainings.platform.Repository.TrainingRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/beneficiary")
public class BeneficiaryController {
	
	
	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	@Autowired
	TrainingRepository trainingRepository;
	
	@Autowired
	ElementRepository elementRepository;
	
	
	@GetMapping("/getbeneficiary/{id}")
	User getbeneficiarybyId(@PathVariable("id") long id){
		System.out.println(id);
		System.out.println(beneficiaryRepository.findAll().size());
		
		return beneficiaryRepository.findById(id).get();

	}
	
	
	@PostMapping("/addElement")
	public ResponseEntity<Beneficiary> addElement(@RequestBody Beneficiary beneficiary) {
		try {
			Optional<Beneficiary> b = beneficiaryRepository.findById(beneficiary.getId());
				beneficiary.setElements(b.get().getElements());
			beneficiaryRepository.save(beneficiary);
			System.out.println(beneficiary.getElements());
		return new ResponseEntity<>(beneficiary, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
		}
	
	
	@GetMapping("/mesFormation/{id}")
	public List<Training> myTrainings(@PathVariable("id") long id) {
		Beneficiary b = new Beneficiary();
		b.setId(id);
		List<Training> t = new ArrayList<Training>();
		List<Element> elements = elementRepository.findByBeneficiaries(b);
		for(Element e:elements) {
			Training tr = new Training();
		if(!t.contains(e.getTraining()))
			t.add(e.getTraining());
		}
		for(Training e:t) {
			e.setElements(new HashSet<Element>());
		}
		for(Element e:elements) {
			Set<Element> set = new HashSet<Element>();
			set = t.get(t.indexOf(e.getTraining())).getElements();
			set.add(e);
			t.get(t.indexOf(e.getTraining())).setElements(set);	
		}
		
		return t;
	}

}
