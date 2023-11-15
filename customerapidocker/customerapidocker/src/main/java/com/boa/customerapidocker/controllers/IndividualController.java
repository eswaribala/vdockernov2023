package com.boa.customerapidocker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerapidocker.models.Individual;
import com.boa.customerapidocker.services.IndividualService;
import com.boa.customerapidocker.vos.ResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;

@RestController
@RequestMapping("/individuals")
public class IndividualController {

	@Autowired
	private IndividualService individualService;
	
	//add
	@PostMapping({"/v1.0/"})
	public ResponseEntity<ResponseWrapper> addIndividual(@RequestBody Individual individual){
		
		Individual obj=this.individualService.addIndividual(individual);
		
		if(obj!=null)
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseWrapper<Individual>(obj));
		else
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseWrapper("Customer Not created"));	
		
	}
	
	
	@GetMapping({"/v1.0/"})
	public List<Individual> getAllIndividuals(){
		
        return this.individualService.getAllIndividuals();

	}

	@GetMapping({"/v1.0/{customerId}"})
	public ResponseEntity<ResponseWrapper> getAllIndividualById(@PathVariable("customerId") long customerId){
		
		Individual obj=this.individualService.getIndividualById(customerId);
		if(obj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new ResponseWrapper<Individual>(obj));
		else
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseWrapper("Customer Not found"));	

	}
	
	@GetMapping({"/v1.0/contactno/{contactNo}"})
	public ResponseEntity<ResponseWrapper> getAllIndividualByContactNo(@PathVariable("contactNo") long contactNo){
		
		List<Individual> individuals=this.individualService.getIndividualByContactNo(contactNo);
		if(individuals.size()>0)
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new ResponseWrapper<List<Individual>>(individuals));
		else
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseWrapper("Customer Not found"));	

	}
	
	@GetMapping({"/v1.0/firstname/{firstName}"})
	public ResponseEntity<ResponseWrapper> getAllIndividualByFirstName(@PathVariable("firstName") String firstName){
		
		List<Individual> individuals=this.individualService.getIndividualByFirstName(firstName);
		if(individuals.size()>0)
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new ResponseWrapper<List<Individual>>(individuals));
		else
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseWrapper("Customer Not found"));	

	}
	
	@PutMapping({"/v1.0/{customerId}"})
	public ResponseEntity<ResponseWrapper> updateIndividual
	(@PathVariable("customerId") long customerId, @RequestParam("email") String email){
		
		Individual obj=this.individualService.updateIndividualEmail(customerId, email);
		
		if(obj!=null)
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseWrapper<Individual>(obj));
		else
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseWrapper("Customer Not updated"));	
		
	}
	@DeleteMapping({"/v1.0/{customerId}"})
	public ResponseEntity<ResponseWrapper> deleteIndividual	(@PathVariable("customerId") long customerId){
				
		if(this.individualService.deleteIndividual(customerId))
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new ResponseWrapper("Customer Deleted"));
		else
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseWrapper("Customer Not deleted"));	
		
	}
	
	
	//http://localhost:7072/individuals/v1.0/filters?fields=customerId,name
		@GetMapping({"/v1.0/filters"})
	    public String getFilteredIndividual(@RequestParam(name = "fields", required = false) 
	    String fields) 
		{

			List<Individual> customersList =this.individualService.getAllIndividuals();
			ObjectMapper mapper = Squiggly.init(new ObjectMapper(), fields);  
			return SquigglyUtils.stringify(mapper, customersList);
			
	    }

}
