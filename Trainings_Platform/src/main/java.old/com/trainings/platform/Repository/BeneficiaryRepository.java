package com.trainings.platform.Repository;


import java.util.Collection;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trainings.platform.Models.Beneficiary;
import com.trainings.platform.Models.Element;
import com.trainings.platform.Models.Training;;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>{
	
	Optional<Beneficiary> findById(Long id);
	
	@Query("SELECT e FROM Element e WHERE ")
	Collection<Element> findmyelement();
}
