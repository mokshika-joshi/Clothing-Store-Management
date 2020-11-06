package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.AdminDao;
import com.cdac.dto.Admin;

@Service
public class AdminServiceImple implements AdminService {
	

	@Autowired  
    private AdminDao adminDao;
     
	@Override
	public boolean checkAdmin(Admin admin) {
		
		return adminDao.checkAdmin(admin);
	}

}
