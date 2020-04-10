package com.trainings.platform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trainings.platform.Models.Trainer;
import com.trainings.platform.Models.Training;

public interface TrainerRepository  extends JpaRepository<Trainer, Long>{

	@Query("SELECT trainer.id FROM Training t WHERE t.id = ?1")
	Long findTrainerByTraining(Long id);

}
