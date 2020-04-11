package com.trainings.platform.controllers;

import java.sql.Date;
import java.util.Calendar;
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

import com.trainings.platform.Models.Element;
import com.trainings.platform.Models.Trainer;
import com.trainings.platform.Models.Training;
import com.trainings.platform.Repository.ElementRepository;
import com.trainings.platform.Repository.TrainingRepository;
import com.trainings.platform.payload.request.TrainingForm;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/training")
public class TrainingController {
	
	@Autowired
	TrainingRepository trainingRepository;
	
	@Autowired
	ElementRepository elementRepository;
	
	@GetMapping("/alltrainings")
	//@PreAuthorize("hasRole('ROLE_FORMATEUR')")
	List<Training> getAllTrainings(){
		
		return trainingRepository.findAll();

	}
	
	@GetMapping("/alltrainings/{id}")
	//@PreAuthorize("hasRole('ROLE_FORMATEUR')")
	Training getrainingbyId(@PathVariable("id") long id){
		Training training  = trainingRepository.findTrainingById(id);
		return training;

	}
	
	@PostMapping("/gestiontraining")
	@PreAuthorize("hasRole('ROLE_FORMATEUR')")
	public ResponseEntity<Training> createTraining(@RequestBody TrainingForm training) {
		try {
			Training _training = new Training();
			_training.setDescription(training.getDescription());
			_training.setConfirmed(training.isConfirmed());
			_training.setEndingDate(training.getEndingDate());
			_training.setHostInstitution(training.getHostInstitution());
			_training.setHours(training.getHours());
			_training.setPrice(training.getPrice());
			_training.setMaxNumber(training.getMaxNumber());
			_training.setMinNumber(training.getMinNumber());
			_training.setName(training.getName());
			_training.setStartingDate(training.getStartingDate());
			Trainer t = new Trainer();
			t.setId(training.getTrainer().getId());
			_training.setTrainer(t);
			trainingRepository.save(_training);
			for(Element element:training.getElements()) {
				element.setTraining(_training);
				elementRepository.save(element);
			}
			return new ResponseEntity<>(_training, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	@GetMapping("/alltrainings30")
	List<Training> getAllNewTrainings(){
		java.sql.Date todaysDate = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date futureDate = this.addDays(todaysDate, 30);
		List<Training> l =trainingRepository.findByStartingDateBefore(futureDate);
		return trainingRepository.findByStartingDateBefore(futureDate);
	}
	
	
	 public static Date addDays(Date date, int days) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(Calendar.DATE, days);
	        return new Date(c.getTimeInMillis());
	    }

}
