package com.boa.customerapidocker.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapidocker.models.Corporate;
import com.boa.customerapidocker.models.FullName;
import com.boa.customerapidocker.services.CorporateService;
import com.boa.customerapidocker.vos.CorporateInput;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class CorporateMutation implements GraphQLMutationResolver{
    @Autowired 
	private CorporateService corporateService;
    
    public Corporate addCorporate(CorporateInput corporateInput) {
    	
    	Corporate corporate= Corporate.builder()
    			.customerId(corporateInput.getCustomerId())
    			.contactNo(corporateInput.getContactNo())
    			
    			.email(corporateInput.getEmail())
    			.companyType(corporateInput.getCompanyType())
    			.password(corporateInput.getPassword())
    			.name(FullName.builder()
    					.firstName(corporateInput.getName().getFirstName())
    					.lastName(corporateInput.getName().getLastName())
    					.middleName(corporateInput.getName().getMiddleName()).build()
    					)
    			
    			.build();
    	
    	return this.corporateService.addCorporate(corporate);
    	
    	
    }
   public Corporate updateCorporate(long customerId, String email) {
	   
	   return this.corporateService.updateCorporateEmail(customerId, email);
   }
    public boolean deleteCorporate(long customerId) {
    
    	return this.corporateService.deleteCorporate(customerId);
    }
    
}
