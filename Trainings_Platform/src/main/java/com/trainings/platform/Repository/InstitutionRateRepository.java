package com.trainings.platform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trainings.platform.Models.InstitutionRate;

public interface InstitutionRateRepository extends JpaRepository< InstitutionRate, Long> {

	@Query("SELECT AVG(e.workspace) FROM InstitutionRate e WHERE e.institutionName = ?1")
	float averageOfWorkspaceRateings(String s);

	@Query("SELECT AVG(e.property) FROM InstitutionRate e WHERE e.institutionName = ?1")
	float averageOfPropertyRateings(String s);

	@Query("SELECT AVG(e.equipment) FROM InstitutionRate e WHERE e.institutionName = ?1")
	float averageOfEquipmentRateings(String s);

}
