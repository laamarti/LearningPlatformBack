package com.trainings.platform.security.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.trainings.platform.Models.Beneficiary;
import com.trainings.platform.Models.CronJobTable;
import com.trainings.platform.Models.Element;
import com.trainings.platform.Models.Training;
import com.trainings.platform.Repository.BeneficiaryRepository;
import com.trainings.platform.Repository.CronJobTableRepository;
import com.trainings.platform.Repository.TrainingRepository;
import com.trainings.platform.controllers.TrainingController;

@Component
public class CronJob {
	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	@Autowired
	TrainingRepository trainingRepository;
	
	@Autowired
	CronJobTableRepository CJTRepository;
	
	// one week in ms is 86,400,000‬ 
    @Scheduled(fixedRate = 86400000 )
    public void publish() {
      List<Beneficiary> bens =  beneficiaryRepository.findAll();
      List<Element> elems = new ArrayList<Element>();
      for(Beneficiary b : bens) {
    	  for(Element el : b.getElements()) {
    		  System.out.println(el.getTraining().getId());
    		  Optional<Training> tr = trainingRepository.findById(el.getTraining().getId());
    		  if(!tr.get().isConfirmed()) {
    			  System.out.println(1);
    			  Long id = CJTRepository.getbyids(el.getId(), b.getId());
    			  Optional<CronJobTable> cjt = CJTRepository.findById(id);
    			  java.sql.Date todaysDate = new java.sql.Date(new java.util.Date().getTime());
    			  java.sql.Date futureDate = TrainingController.addDays(cjt.get().getAdditionDate(), 7);
    			  if(futureDate.before(todaysDate)) {
    				  System.out.println(2);
    				  elems.add(el);
//    				  b.getElements().remove(el);
//    				  beneficiaryRepository.save(b);
    				  CJTRepository.deleteById(id);
    			  }
    		  }
    	  }
    	  for(Element e:elems) {
    		  System.out.println("final stage");
    		  b.getElements().remove(e);
    	  }
    	  beneficiaryRepository.save(b);
      }
    }

}
