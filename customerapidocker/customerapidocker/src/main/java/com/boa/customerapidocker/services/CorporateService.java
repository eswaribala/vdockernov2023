package com.boa.customerapidocker.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerapidocker.models.Corporate;
import com.boa.customerapidocker.repositories.CorporateRepo;

@Service
public class CorporateService {
	@Autowired
	private CorporateRepo corporateRepo;
	
	@Autowired
	private EntityManager entityManager;
	//insert
	
	public Corporate addCorporate(Corporate Corporate) {
		return this.corporateRepo.save(Corporate);
	}
	
	//retrieve
	
	public List<Corporate> getAllCorporates(){
		return this.corporateRepo.findAll();
	}
	
	//retrieve by pk
	
	public Corporate getCorporateById(long customerId) {
		return this.corporateRepo.findById(customerId).orElse(null);
		
	}
	
	//non primary key
	public List<Corporate> getCorporateByContactNo(long contactNo) {
		return this.corporateRepo.findByContactNo(contactNo);
		
	}
	//non primary key
	public List<Corporate> getCorporateByFirstName(String firstName){

    	CriteriaBuilder cb= entityManager.getCriteriaBuilder();
    	AbstractQuery<Corporate> cq=cb.createQuery(Corporate.class);
    	
    	Root<Corporate> CorporateObject=cq.from(Corporate.class);
    	cq.where(cb.equal(CorporateObject.get("name").<String> get("firstName") ,firstName));
    	
    	CriteriaQuery<Corporate> selectResult=((CriteriaQuery<Corporate>)cq).select(CorporateObject);
    	TypedQuery<Corporate> tq=entityManager.createQuery(selectResult);
    	return tq.getResultList();

	}
	
	//update
	
	public Corporate updateCorporateEmail(long customerId,String email) {
		
		Corporate Corporate=this.getCorporateById(customerId);
		
		if(Corporate !=null) {
			Corporate.setEmail(email);
			this.corporateRepo.save(Corporate);
			return Corporate;
		}
		else
			return null;
		
		
		
	}
	
	
	//delete 
	

	public boolean deleteCorporate(long customerId) {
		boolean status=false;
		Corporate Corporate=this.getCorporateById(customerId);
		
		if(Corporate !=null) {
			
			this.corporateRepo.deleteById(customerId);
			status=true;
			return status;
		}
		else
			return status;
		
		
		
	}
	
}
