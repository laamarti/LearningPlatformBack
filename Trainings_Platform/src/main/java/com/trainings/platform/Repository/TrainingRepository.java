package com.trainings.platform.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainings.platform.Models.Training;


public interface TrainingRepository extends JpaRepository<Training,Long>{
	
	List<Training> findByStartingDateBefore(Date date);

	Training findTrainingById(Long id);

	Training findTrainingByNameContaining(String name);

}