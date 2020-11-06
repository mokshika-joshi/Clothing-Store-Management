package com.cdac.cntr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.Admin;
import com.cdac.service.AdminService;
import com.cdac.valid.AdminValidator;

@Controller
public class AdminController {
	
	 @Autowired
     private AdminService adminService;
	 @Autowired
	 private AdminValidator adminValidator;
	
	@RequestMapping(value="/prep_admin_form.htm", method=RequestMethod.GET)
	public String prepAdminForm(ModelMap map) {
		map.put("adminform", new Admin());
		return "admin_form";
		
	} 
	
	
	@RequestMapping(value="/validate_admin_form.htm", method=RequestMethod.POST)
	public String validateUser(Admin admin, ModelMap map,HttpSession session)
	{
		/*
		 * adminValidator.validate(admin,result); if(result.hasErrors()) { return
		 * "admin_form"; }
		 */
		
		boolean t=adminService.checkAdmin(admin);
		if(t)
		{
			session.setAttribute("admin", admin);
			return "home2";
		}
		else {
			map.put("admin", new Admin());
			return "admin_form";
		}
		
	}
	
	
	
	


}
