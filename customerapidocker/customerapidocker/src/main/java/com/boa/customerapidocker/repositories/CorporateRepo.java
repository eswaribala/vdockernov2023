package com.boa.customerapidocker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boa.customerapidocker.models.Corporate;


public interface CorporateRepo extends JpaRepository<Corporate,Long>{
	@Query("Select c from Corporate c where c.contactNo=:contactNo")
	public List<Corporate> findByContactNo(@Param("contactNo") long contactNo);

}
