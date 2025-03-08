package com.purpleplum.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.purpleplum.assignment.entity.CustomerEntity;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long>{
    
    CustomerEntity findByCustomerId(Long customerId);

}
