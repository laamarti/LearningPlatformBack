package com.trainings.platform.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainings.platform.Models.Element;
import com.trainings.platform.Models.Training;


public interface ElementRepository extends JpaRepository<Element, Long>{

	Set<Element> findByTraining(Training training);
	Set<Element> findByTraining_Id(long id);
	Set<Element> findByTrainingId(long id);
	
}
