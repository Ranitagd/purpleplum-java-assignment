package com.purpleplum.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.purpleplum.assignment.entity.CustomerEntity;
import com.purpleplum.assignment.model.CustomerModel;
import com.purpleplum.assignment.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
    @Autowired
    private CustomerServiceImpl customerService;
	 
    @GetMapping("/")
    public List<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    
    @GetMapping("/{customerId}")
    public CustomerModel getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }
    
    // Get decrypted identifier
    @GetMapping("decrypt/{customerId}")
    public CustomerModel getCustomerDecrypted(@PathVariable Long customerId) {
        return customerService.getCustomerDecrypted(customerId);
    }
    
 // Create a new customer
    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customer) {
        CustomerModel createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
    
    // Update a customer
    @PutMapping("/{id}")
    public ResponseEntity<CustomerModel> updateCustomer(@PathVariable Long id, @RequestBody CustomerModel customer) {
        try {
            CustomerModel updatedCustomer = customerService.updateCustomer(id, customer);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Get all customers with pagination, sorting, and filtering
    @GetMapping
    public ResponseEntity<Page<CustomerModel>> getAllCustomers(
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "customerName") String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir) {

        Page<CustomerModel> customers = customerService.getAllCustomers(filter, page, size, sortBy, sortDir);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


}
