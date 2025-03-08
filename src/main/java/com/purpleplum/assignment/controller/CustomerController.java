package com.purpleplum.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.purpleplum.assignment.entity.CustomerEntity;
import com.purpleplum.assignment.model.CustomerModel;
import com.purpleplum.assignment.service.CustomerServiceImpl;

@RestController
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

}
