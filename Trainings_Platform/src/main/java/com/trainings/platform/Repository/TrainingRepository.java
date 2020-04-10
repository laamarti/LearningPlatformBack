package com.trainings.platform.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainings.platform.Models.Trainer;
import com.trainings.platform.Models.Training;


public interface TrainingRepository extends JpaRepository<Training,Long>{
	
	List<Training> findByStartingDateBefore(Date date);

	Training findTrainingById(Long id);

	Training findTrainingByNameContaining(String name);

	List<Training> findByStartingDateBetween(Date todaysDate, Date futureDate);

	List<Training> findTrainingByTrainer(Trainer tr);

	Training findTrainingById(long id);

}