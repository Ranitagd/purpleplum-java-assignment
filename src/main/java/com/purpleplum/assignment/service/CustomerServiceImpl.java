package com.purpleplum.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purpleplum.assignment.entity.CustomerEntity;
import com.purpleplum.assignment.model.CustomerModel;
import com.purpleplum.assignment.repository.ICustomerRepository;
import com.purpleplum.assignment.transformer.CustomerTransformer;

@Service
public class CustomerServiceImpl {

	@Autowired
    private ICustomerRepository customerRepository;
	@Autowired
    private CustomerTransformer customerTransformer;

    // Fetch all customers
    public List<CustomerModel> getAllCustomers() {
    	List<CustomerModel> customerModels = new ArrayList<CustomerModel>();
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        for (CustomerEntity customerEntity : customerEntities) {
        	CustomerModel customerModel = customerTransformer.convertEntityToModel(customerEntity);
        	customerModels.add(customerModel);
		}        
    	return customerModels;
    }

    // Fetch customer by ID
    public CustomerModel getCustomerById(Long customerId) {
        CustomerModel customerModel = customerTransformer.convertEntityToModel(customerRepository.findByCustomerId(customerId));
    	return customerModel;
    }
}