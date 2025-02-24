package com.trainings.platform.Repository;

import java.util.List;

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


	@Query("SELECT AVG(e.workspace) FROM InstitutionRate e")
	float avgWorkspace();

	@Query("SELECT AVG(e.equipment) FROM InstitutionRate e")
	float avgProperty();
	@Query("SELECT AVG(e.property) FROM InstitutionRate e")
	float avgEquipment();
	
	@Query("SELECT e.property, count(e.property) FROM InstitutionRate e GROUP BY e.property")
	List noProperty();

	@Query("SELECT e.equipment, count(e.equipment) FROM InstitutionRate e GROUP BY e.equipment")
	List noEquipment();

	@Query("SELECT e.workspace, count(e.workspace) FROM InstitutionRate e GROUP BY e.workspace")
	List noWorkspace();
}
