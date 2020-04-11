package com.trainings.platform.controllers;

import java.util.List;

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

import com.trainings.platform.Models.Trainer;
import com.trainings.platform.Models.TrainerRate;
import com.trainings.platform.Models.Training;
import com.trainings.platform.Repository.TrainerRateRepository;
import com.trainings.platform.payload.request.TrainerRateRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/trainerRate")
public class TrainerRateController {
	
	@Autowired
	TrainerRateRepository tRateRepository;
	
	@GetMapping("/{id}")
	 TrainerRate TrainerRate(@PathVariable (value="id") Long id){
		Trainer t = new Trainer();
		t.setId(id);
		float skill = tRateRepository.averageOfSkillRateings(t);
		float subject =tRateRepository.averageOfSubjectRateings(t);
		float kindness= tRateRepository.averageOfKindnessRateings(t);
		TrainerRate tr = new TrainerRate();
		tr.setKindness(kindness);
		tr.setSkill(skill);
		tr.setSubject(subject);
		tr.setTrainer(t);
		return tr;

	}
	@PostMapping("/ratingTrainer")
//	@PreAuthorize("hasRole('ROLE_FORMATEUR')")
	public ResponseEntity<TrainerRate> rating(@RequestBody TrainerRate trate){
		try {
			
			tRateRepository.save(trate);
			return new ResponseEntity<>(trate, HttpStatus.CREATED);
		}
		
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

}
