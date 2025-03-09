package com.purpleplum.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    
 // Create a new customer
    public CustomerModel createCustomer(CustomerModel customer) {
    	CustomerEntity customerEntity = customerTransformer.convertModelToEntity(customer);
    	CustomerModel customerResponse = customerTransformer.convertEntityToModel(customerRepository.save(customerEntity));
        return customerResponse;
    }
    
 // Update a customer
    public CustomerModel updateCustomer(Long customerId, CustomerModel updatedCustomer) {
        if (customerRepository.existsById(customerId)) {
            updatedCustomer.setCustomerId(customerId);
            CustomerEntity customerEntity = customerTransformer.convertModelToEntity(updatedCustomer);
            CustomerModel customerResponse = customerTransformer.convertEntityToModel(customerRepository.save(customerEntity));
            return customerResponse;
        } else {
            throw new RuntimeException("Customer not found with id " + customerId);
        }
    }

    // Delete a customer
    public void deleteCustomer(Long customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
        } else {
            throw new RuntimeException("Customer not found with id " + customerId);
        }
    }
    
    // Get all customers with pagination, sorting, and filtering
    public Page<CustomerModel> getAllCustomers(String filter, int page, int size, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortBy);
        if (filter == null || filter.isEmpty()) {
        	Page<CustomerEntity> customerEntityPage = customerRepository.findAll(pageable);
        	List<CustomerModel> customerModels = customerEntityPage.getContent().stream()
                    .map(customerTransformer::convertEntityToModel)
                    .collect(Collectors.toList());
            return new PageImpl<CustomerModel>(customerModels, pageable, customerEntityPage.getTotalElements());
        } else {
        	
        	Page<CustomerEntity> customerEntityPage = customerRepository.findAll(pageable);
        	Page<CustomerEntity> customerEmailFilter = customerRepository.findByCustomerEmailContainingIgnoreCase(filter, pageable);
        	Page<CustomerEntity> customerCountryFilter = customerRepository.findByCustomerCountryContainingIgnoreCase(filter, pageable);
        	Page<CustomerEntity> customerStateFilter = customerRepository.findByCustomerStateContainingIgnoreCase(filter, pageable);
        	if(customerEmailFilter.getNumberOfElements()>0) {
        		customerEntityPage = customerEmailFilter;
        	} else if(customerCountryFilter.getNumberOfElements()>0) {
        		customerEntityPage = customerCountryFilter;
        	} else if (customerStateFilter.getNumberOfElements()>0){
        		customerEntityPage = customerStateFilter;
        	}        	
        	// Convert Page<Customer> to Page<CustomerModel>
            List<CustomerModel> customerModels = customerEntityPage.getContent().stream()
                    .map(customerTransformer::convertEntityToModel)
                    .collect(Collectors.toList());
            return new PageImpl<CustomerModel>(customerModels, pageable, customerEntityPage.getTotalElements());
        }
    }
    
    
}