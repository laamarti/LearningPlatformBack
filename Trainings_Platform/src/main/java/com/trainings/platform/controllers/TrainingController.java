package com.trainings.platform.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainings.platform.Models.Training;
import com.trainings.platform.Repository.TrainingRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/training")
public class TrainingController {
	
	@Autowired
	TrainingRepository trainingRepository;
	
	@GetMapping("/alltrainings")
	List<Training> getAllTrainings(){
		
		return trainingRepository.findAll();

	}
	
	@PostMapping("/gestiontraining")
	public ResponseEntity<Training> createActualite(@RequestBody Training training) {
		try {
			Training _training = trainingRepository.save(training) ;
			return new ResponseEntity<>(_training, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
//	List<Training> getAllTrainings(){
//		java.sql.Date todaysDate = new java.sql.Date(new java.util.Date().getTime());
//		java.sql.Date futureDate = this.addDays(todaysDate, 30);
//		List<Training> l =training.findByStartingDateBefore(futureDate);
//		return training.findByStartingDateBefore(futureDate);
//	}
	
	
	 public static Date addDays(Date date, int days) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(Calendar.DATE, days);
	        return new Date(c.getTimeInMillis());
	    }

}
