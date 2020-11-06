package com.cdac.cntr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Customer;
import com.cdac.service.CustomerService;
import com.cdac.valid.CustomerValidator;



@Controller
public class CustomerController {


	 @Autowired
    private CustomerService customerService;
	 @Autowired
	private CustomerValidator customerValidator; 
	 @Autowired
	private MailSender mailSender;
	
	@RequestMapping(value="/prep_reg_form.htm", method=RequestMethod.GET)
	public String prepAdminForm(ModelMap map) {
		map.put("customer", new Customer());
		return "cust_reg_form";
		
	} 
	
	@RequestMapping(value = "/reg.htm",method = RequestMethod.POST)
	public String register(Customer customer,BindingResult result ,ModelMap map) {
		
		customerValidator.validate(customer,result);
		if(result.hasErrors()) {
			return "cust_reg_form";
		}
		
		customerService.insertCustomer(customer);
		return "home";
	}
	
	@RequestMapping(value="/prep_cust_form.htm", method=RequestMethod.GET)
	public String prepCustForm(ModelMap map) {
		map.put("customerlog", new Customer());
		return "CustLogin";
		
	} 
	
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public String validateCustomer(Customer customer,BindingResult result, ModelMap map,HttpSession session)
	{
		/*
		 * customerValidator.validate(customer,result); if(result.hasErrors()) { return
		 * "CustLogin"; }
		 */			
		
	
		
		boolean t=customerService.checkCustomer(customer);
		if(t)
		{
			session.setAttribute("customer", customer);
			return "CustomerWelcome";
		}
		else {
			
			map.put("customer", new Customer() );
			return "CustLogin";
		}
		
		
	}
	
	@RequestMapping(value="/prep_forgot_password.htm", method = RequestMethod.GET)
	public String prepForgotPasswordForm(ModelMap map) {
		map.put("customer", new Customer());
		return "forgot_password";
	}
	
	@RequestMapping(value = "/forgot_password.htm",method = RequestMethod.POST)
	public String forgotPassword(@RequestParam String custEmail,ModelMap map) {		
		String pass = customerService.forgotPassword(custEmail);
		String msg = "you are not registered";
		if(pass!=null) {	
			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("cdacmumbai3@gmail.com");  
	        message.setTo(custEmail);  
	        message.setSubject("Your password");  
	        message.setText(pass);  
	        //sending message   
	        mailSender.send(message);
			msg = "check the mail for password";
		}
		map.put("msg", msg);
		return "info_cust";
	}
	
	
	
	
	
	
	
	
	
}
