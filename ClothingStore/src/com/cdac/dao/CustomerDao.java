package com.cdac.dao;

import com.cdac.dto.Customer;

public interface CustomerDao {
	
	void insertCustomer(Customer customer);
	boolean checkCustomer(Customer customer);
	String findPassword(String custEmail);
	

}
