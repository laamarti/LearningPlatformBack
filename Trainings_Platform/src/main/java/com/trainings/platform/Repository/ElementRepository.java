package com.trainings.platform.Repository;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trainings.platform.Models.Beneficiary;
import com.trainings.platform.Models.Element;
import com.trainings.platform.Models.Training;


public interface ElementRepository extends JpaRepository<Element, Long>{

	Set<Element> findByTraining(Training training);
	Set<Element> findByTraining_Id(long id);
	Set<Element> findByTrainingId(long id);
	List<Element> findByBeneficiaries(Beneficiary b);
	
}
