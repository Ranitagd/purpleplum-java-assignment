package com.purpleplum.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_master")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId; // Primary key

	@Column(name = "customer_name", nullable = false)
	private String customerName;

	@Column(name = "customer_address1", nullable = false)
	private String customerAddress1;

	@Column(name = "customer_address2")
	private String customerAddress2;

	@Column(name = "customer_city")
	private String customerCity;

	@Column(name = "customer_state", nullable = false)
	private String customerState;

	@Column(name = "customer_country", nullable = false)
	private String customerCountry;

	@Column(name = "customer_mobile", nullable = false, unique = true)
	private String customerMobile;

	@Column(name = "customer_identifier", nullable = false)
	private String customerIdentifier;

	@Column(name = "customer_identifier_number", nullable = false, unique = true)
	private String customerIdentifierNumber;

	@Column(name = "customer_email", nullable = false, unique = true)
	private String customerEmail;

	// Getters and Setters

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress1() {
		return customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public String getCustomerAddress2() {
		return customerAddress2;
	}

	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getCustomerIdentifierNumber() {
		return customerIdentifierNumber;
	}

	public void setCustomerIdentifierNumber(String customerIdentifierNumber) {
		this.customerIdentifierNumber = customerIdentifierNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
}
