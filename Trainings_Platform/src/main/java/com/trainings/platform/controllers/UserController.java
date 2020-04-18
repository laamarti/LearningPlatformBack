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

import com.trainings.platform.Models.Trainer;
import com.trainings.platform.Models.User;
import com.trainings.platform.Repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/getone/{id}")
	User getOne(@PathVariable("id") long id){
		
		return userRepository.findById(id).get();
	}
	
	@PostMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user) {

		
		try {
			User b = userRepository.findById(user.getId()).get();
			b.setFirstName(user.getFirstName());
			b.setLastName(user.getLastName());
			b.setEmail(user.getEmail());
			b.setUsername(user.getUsername());
			b.setPhone(user.getPhone());
			
			userRepository.save(b);

		return new ResponseEntity<>(b, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
		}

}
