package com.trainings.platform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trainings.platform.Models.CronJobTable;

public interface CronJobTableRepository extends JpaRepository<CronJobTable,Long>  {

	
	@Query("SELECT id FROM CronJobTable c WHERE c.elemId = ?1 and c.benId= ?2")
	Long getbyids(Long elemId,Long bneId);
}
