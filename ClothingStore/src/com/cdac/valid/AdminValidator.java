package com.cdac.valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Admin;


@Service
public class AdminValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Admin.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"adminName","anameKey","Please Enter Name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminPass","apassKey","Please Enter Password");
		
		
		Admin admin = (Admin)target;
		if(admin.getAdminPass()!=null) {
			if(admin.getAdminPass().length()<2) {
				errors.rejectValue("adminPass","apassKey","Password should be more than 6 character");
			}
		}
		
	}

}
