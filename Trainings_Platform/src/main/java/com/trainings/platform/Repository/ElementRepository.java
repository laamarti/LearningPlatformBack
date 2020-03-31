package com.trainings.platform.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainings.platform.Models.Element;


public interface ElementRepository extends JpaRepository<Element, Long>{

}
