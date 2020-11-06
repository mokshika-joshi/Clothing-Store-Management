package com.cdac.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Customer;

public class CustomerLoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		 return clazz.equals(Customer.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","cemailKey","Please Enter EmailId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "custPass","cpassKey","Please Enter Password");
		
		Customer customer = (Customer)target;
		if(customer.getCustPass()!=null) {
			if(customer.getCustPass().length()<6) {
				errors.rejectValue("custPass","cpassKey","Password should be more than 6 character");
			}
		}

		
	}

}
