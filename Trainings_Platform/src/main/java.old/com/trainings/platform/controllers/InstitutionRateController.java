package com.trainings.platform.controllers;

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

import com.trainings.platform.Models.InstitutionRate;
import com.trainings.platform.Models.TrainerRate;
import com.trainings.platform.Repository.InstitutionRateRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/InstitutionRate")
public class InstitutionRateController {
	
	@Autowired
	InstitutionRateRepository IRateRepository;
	
	@GetMapping("/{name}")
	 InstitutionRate getRate(@PathVariable (value="name") String name){
		
		float workspace = IRateRepository.averageOfWorkspaceRateings(name);
		float property = IRateRepository.averageOfPropertyRateings(name);
		float equipment= IRateRepository.averageOfEquipmentRateings(name);
		InstitutionRate tr = new InstitutionRate();
		tr.setInstitutionName(name);
		tr.setWorkspace(workspace);
		tr.setProperty(property);
		tr.setEquipment(equipment);
		return tr;

	}
	
	@PostMapping("/ratingInstitution")
//	@PreAuthorize("hasRole('ROLE_FORMATEUR')")
	public ResponseEntity<InstitutionRate> rating(@RequestBody InstitutionRate Irate){
		try {
			IRateRepository.save(Irate);
			return new ResponseEntity<>(Irate, HttpStatus.CREATED);
		}
		
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

}
