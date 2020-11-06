package com.cdac.service;

import com.cdac.dto.Customer;

public interface CustomerService {
	
	void insertCustomer(Customer customer);
	boolean checkCustomer(Customer customer);
	String forgotPassword(String custEmail);

}
