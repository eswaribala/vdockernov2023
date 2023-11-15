package com.boa.customerapidocker.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapidocker.models.Corporate;
import com.boa.customerapidocker.services.CorporateService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class CorporateQuery implements GraphQLQueryResolver {
	@Autowired
	private CorporateService corporateService;
	

	public List<Corporate> findAllCorporates(){
		return this.corporateService.getAllCorporates();
		
	}
	
	public Corporate findCorporateById(long customerId) {
	
		return this.corporateService.getCorporateById(customerId);
	}
	
	public List<Corporate> findCorporateByFirstName(String firstName){
		return this.corporateService.getCorporateByFirstName(firstName);
	}
	
	
	public List<Corporate> findCorporateByContactNo(long contactNo){
		return this.corporateService.getCorporateByContactNo(contactNo);
	}
	
}
