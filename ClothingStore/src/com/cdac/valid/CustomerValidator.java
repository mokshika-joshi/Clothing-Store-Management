package com.cdac.valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Customer;

@Service
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Customer.class);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"custName","cnameKey","Please Enter Name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","cemailKey","Please Enter EmailId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "custPass","cpassKey","Please Enter Password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"gender","cgenderKey","Please Select Gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"city","ccityKey","Please Enter Address");
		
		
		Customer customer = (Customer)target;
		if(customer.getCustPass()!=null) {
			if(customer.getCustPass().length()<6) {
				errors.rejectValue("custPass","cpassKey","Password should be more than 6 character");
			}
		}

		
	}

}
