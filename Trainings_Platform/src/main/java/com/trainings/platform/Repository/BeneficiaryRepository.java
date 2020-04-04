package com.trainings.platform.Repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trainings.platform.Models.Beneficiary;


public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>{
	
	Optional<Beneficiary> findById(Long id);
}
