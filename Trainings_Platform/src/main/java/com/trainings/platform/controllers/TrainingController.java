package com.trainings.platform.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainings.platform.Models.Element;
import com.trainings.platform.Models.Trainer;
import com.trainings.platform.Models.Training;
import com.trainings.platform.Repository.ElementRepository;
import com.trainings.platform.Repository.TrainerRepository;
import com.trainings.platform.Repository.TrainingRepository;
import com.trainings.platform.payload.request.TrainingForm;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/training")
public class TrainingController {
	
	@Autowired
	TrainerRepository trainerRepository;
	
	@Autowired
	TrainingRepository trainingRepository;
	
	@Autowired
	ElementRepository elementRepository;
	
	@GetMapping("/alltrainings")
	//@PreAuthorize("hasRole('ROLE_FORMATEUR')")
	List<Training> getAllTrainings(){
		
//		 trainingRepository.findAll();
		java.sql.Date todaysDate = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date futureDate = TrainingController.addDays(todaysDate, 30);
		return trainingRepository.findByStartingDateBetween(todaysDate,futureDate);
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
	@GetMapping("/allMyTrainings/{id}")
	List<Training> getAllNewTrainings(@PathVariable("id") Long id){
		Trainer tr = new Trainer();
		tr.setId(id);
		List<Training> l =trainingRepository.findTrainingByTrainer(tr);
		return l;
	}

	
	 public static Date addDays(Date date, int days) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(Calendar.DATE, days);
	        return new Date(c.getTimeInMillis());
	    }
	 
	 @GetMapping("/countTrainings")
		public long countByTenantName() {
			return  trainingRepository.count();
		}

		
		@GetMapping("/countPrice")
		public Float getForecastTotals() {
		
		    Float a = trainingRepository.selectTotals();
			System.out.println(a);
				return a;
		}
		
		
		@DeleteMapping("/alltrain/{id}")
		public ResponseEntity<HttpStatus> deleteTraining(@PathVariable("id") long id) {
		 try { 
			
			 trainingRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
			}
		}
		
		@GetMapping("/getTrainer/{id}")
		@ResponseBody
		String gettrainerfromTraining(@PathVariable("id") Long id){

			return trainerRepository.findTrainerNameByTraining(id);
		}
		
		@GetMapping("/countbens/{id}")
		public float countbens(@PathVariable("id") long id) {
			Set<Element> elements = elementRepository.findByTrainingId(id);
			float avg = 0;
			for(Element el:elements) {
				avg+= el.getBeneficiaries().size();
			}
			avg = avg/elements.size();
		
			
			return avg;
		}
		
		@GetMapping("/declancher/{id}")
		public void declanger(@PathVariable("id") long id) {
		Optional<Training> training =	trainingRepository.findById(id);
		training.get().setConfirmed(true);
		trainingRepository.save(training.get());
		}

}
