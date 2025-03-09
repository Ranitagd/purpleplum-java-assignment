package com.purpleplum.assignment.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import com.purpleplum.assignment.entity.CustomerEntity;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long>{
    
    CustomerEntity findByCustomerId(Long customerId);
    Page<CustomerEntity> findByCustomerCountryContainingIgnoreCase(String country, Pageable pageable);
    Page<CustomerEntity> findByCustomerEmailContainingIgnoreCase(String email, Pageable pageable);
    Page<CustomerEntity> findByCustomerStateContainingIgnoreCase(String state, Pageable pageable);

}
