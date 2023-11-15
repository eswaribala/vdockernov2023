package com.boa.customerapidocker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customerapidocker.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
