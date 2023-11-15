package com.boa.customerapidocker.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapidocker.models.FullName;
import com.boa.customerapidocker.models.Individual;
import com.boa.customerapidocker.services.IndividualService;
import com.boa.customerapidocker.vos.IndividualInput;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class IndividualMutation implements GraphQLMutationResolver{
    @Autowired 
	private IndividualService individualService;
    
    public Individual addIndividual(IndividualInput individualInput) {
    	
    	Individual individual= Individual.builder()
    			.customerId(individualInput.getCustomerId())
    			.contactNo(individualInput.getContactNo())
    			.dob(individualInput.getDob())
    			.email(individualInput.getEmail())
    			.gender(individualInput.getGender())
    			.password(individualInput.getPassword())
    			.name(FullName.builder()
    					.firstName(individualInput.getName().getFirstName())
    					.lastName(individualInput.getName().getLastName())
    					.middleName(individualInput.getName().getMiddleName()).build()
    					)
    			
    			.build();
    	
    	return this.individualService.addIndividual(individual);
    	
    	
    }
   public Individual updateIndividual(long customerId, String email) {
	   
	   return this.individualService.updateIndividualEmail(customerId, email);
   }
    public boolean deleteIndividual(long customerId) {
    
    	return this.individualService.deleteIndividual(customerId);
    }
    
}
