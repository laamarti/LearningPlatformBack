package com.trainings.platform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trainings.platform.Models.Trainer;
import com.trainings.platform.Models.TrainerRate;

public interface TrainerRateRepository extends JpaRepository<TrainerRate, Long>{
	
	@Query("SELECT AVG(e.skill) FROM TrainerRate e WHERE e.trainer = ?1")
	float averageOfSkillRateings(Trainer t);
	
	@Query("SELECT AVG(e.subject) FROM TrainerRate e WHERE e.trainer = ?1")
	float averageOfSubjectRateings(Trainer t);
	
	@Query("SELECT AVG(e.kindness) FROM TrainerRate e WHERE e.trainer = ?1")
	float averageOfKindnessRateings(Trainer t);
}
