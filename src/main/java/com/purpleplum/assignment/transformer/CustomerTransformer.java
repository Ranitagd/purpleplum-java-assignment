package com.purpleplum.assignment.transformer;

import org.springframework.stereotype.Service;

import com.purpleplum.assignment.entity.CustomerEntity;
import com.purpleplum.assignment.model.CustomerModel;

@Service
public class CustomerTransformer {	
	// Convert Entity to Model (DTO)
    public CustomerModel convertEntityToModel(CustomerEntity customer) {
        CustomerModel model = new CustomerModel();
        model.setCustomerId(customer.getCustomerId());
        model.setCustomerName(customer.getCustomerName());
        model.setCustomerAddress1(customer.getCustomerAddress1());
        model.setCustomerAddress2(customer.getCustomerAddress2());
        model.setCustomerCity(customer.getCustomerCity());
        model.setCustomerState(customer.getCustomerState());
        model.setCustomerCountry(customer.getCustomerCountry());
        model.setCustomerMobile(customer.getCustomerMobile());
        model.setCustomerIdentifier(customer.getCustomerIdentifier());
        model.setCustomerIdentifierNumber(customer.getCustomerIdentifierNumber());
        model.setCustomerEmail(customer.getCustomerEmail());
        return model;
    }    
    // Method to convert CustomerModel to Customer (Entity)
    public CustomerEntity convertModelToEntity(CustomerModel model) {
        CustomerEntity customer = new CustomerEntity();
        customer.setCustomerId(model.getCustomerId());
        customer.setCustomerName(model.getCustomerName());
        customer.setCustomerAddress1(model.getCustomerAddress1());
        customer.setCustomerAddress2(model.getCustomerAddress2());
        customer.setCustomerCity(model.getCustomerCity());
        customer.setCustomerState(model.getCustomerState());
        customer.setCustomerCountry(model.getCustomerCountry());
        customer.setCustomerMobile(model.getCustomerMobile());
        customer.setCustomerIdentifier(model.getCustomerIdentifier());
        customer.setCustomerIdentifierNumber(model.getCustomerIdentifierNumber());
        customer.setCustomerEmail(model.getCustomerEmail());
        return customer;
    }

}
