package com.boa.customerapidocker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customerapidocker.models.Address;

public interface AddressRepo extends JpaRepository<Address,Long>{

}
