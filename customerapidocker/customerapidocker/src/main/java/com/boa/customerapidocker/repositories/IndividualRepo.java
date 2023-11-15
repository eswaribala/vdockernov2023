package com.boa.customerapidocker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boa.customerapidocker.models.Individual;

public interface IndividualRepo extends JpaRepository<Individual,Long> {

	
	@Query("Select i from Individual i where i.contactNo=:contactNo")
	public List<Individual> findByContactNo(@Param("contactNo") long contactNo);
	
}
