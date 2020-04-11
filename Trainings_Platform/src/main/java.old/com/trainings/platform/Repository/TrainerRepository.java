package com.trainings.platform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainings.platform.Models.Trainer;

public interface TrainerRepository  extends JpaRepository<Trainer, Long>{

}
